package com.auto.config;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 文件上传配置类
 */
@Configuration
public class WebFileUploadConfig {

    /**
     * 华南机房 深圳
     */
    @Bean
    public com.qiniu.storage.Configuration qiuConfig(){
        return new com.qiniu.storage.Configuration(Zone.zone2());
    }

    /**
     * 构建一个七牛工具上传实例
     */
    @Bean
    public UploadManager uploadManager(){
        return new UploadManager(qiuConfig());
    }

    @Value("${qiniu.AccessKey}")
    private String accessKey;

    @Value("${qiniu.SecretKey}")
    private String secretKey;


    /**
     * 生成七牛云认证信息
     */
    @Bean
    public Auth auth(){
        return Auth.create(accessKey, secretKey);
    }

    @Value("${qiniu.Bucket}")
    private String bucket;


    /**
     * 七牛云空间管理
     */
    @Bean
    public BucketManager bucketManager(){
        return new BucketManager(auth(),qiuConfig());
    }


    /**
     * 解析 结果集 返回数据
     */
    @Bean
    public Gson gson(){
        return new Gson();
    }

}
