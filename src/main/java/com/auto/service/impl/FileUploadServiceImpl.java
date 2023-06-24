package com.auto.service.impl;

import com.auto.service.FileUploadService;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;

/**
 * 七牛云上传文件 实现类
 */
@Service
public class FileUploadServiceImpl implements FileUploadService, InitializingBean {

    @Autowired
    private UploadManager uploadManager;

    @Autowired
    private BucketManager bucketManager;

    @Autowired
    private Auth auth;

    //七牛云空间名称
    @Value("${qiniu.Bucket}")
    private String bucket;

    private StringMap putPolicy;

    /**
     * 文件方法
     * @param file
     * @return
     * @throws QiniuException
     */
    @Override
    public Response uploadFile(File file) throws QiniuException {
        Response response = this.uploadManager.put(file, null, getUploadToken());
        int retry = 0;
        while (response.needRetry() && retry < 3){
            response = this.uploadManager.put(file, null, getUploadToken());
            retry++;
        }
        return response;
    }

    /**
     * 输入流方式
     * @param inputStream
     * @return
     * @throws QiniuException
     */
    @Override
    public Response uploadFile(InputStream inputStream) throws QiniuException {
        Response response = this.uploadManager.put(inputStream, null, getUploadToken(),null,null);
        int retry = 0;
        while (response.needRetry() && retry < 3){
            response = this.uploadManager.put(inputStream, null, getUploadToken(),null,null);
            retry++;
        }
        return response;
    }

    /**
     * 删除
     * @param key
     * @return
     * @throws QiniuException
     */
    @Override
    public Response delete(String key) throws QiniuException {
        Response response = this.bucketManager.delete(bucket, key);
        int retry = 0;
        while (response.needRetry() && retry++ < 3){
            response = this.bucketManager.delete(bucket, key);
        }
        return response;
    }

    /**
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        this.putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"width\":$(imageInfo.width) ,\"height\":$(imageInfo.height)}" );
    }

    /**
     * 生成upload  token  获取上传凭证
     */
    private String getUploadToken(){
        return this.auth.uploadToken(bucket,null,3600,putPolicy);
    }


}
