package com.auto.service;

import com.auto.dto.QiNiuPutResult;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * 测试七牛云文件上传
 */
@ContextConfiguration(locations = "classpath:spring/spring-web.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class FileUploadServiceTest {

    @Autowired
    private FileUploadService fileUploadService;

    private Logger logger = LoggerFactory.getLogger(FileUploadServiceTest.class);
    @Autowired
    private Gson gson;


    /**
     * 直接文件上传
     */
    @Test
    public void uploadFile() {
        String filePath = "E:\\CURD\\ssm\\photo-ssm-version1.0\\src\\main\\webapp\\img\\boke\\3ad2b7e86f.jpg";
        File file = new File(filePath);
        Assert.assertTrue(file.exists());
        try {
            Response response = fileUploadService.uploadFile(file);
            Assert.assertTrue(response.isOK());
        } catch (QiniuException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据inputStream 上传图片
     */
    @Test
    public void testUploadFile() {
        try {
            String filePath = "E:\\CURD\\ssm\\photo-ssm-version1.0\\src\\main\\webapp\\img\\boke\\98c07f5284.jpg";
            InputStream inputStream = new FileInputStream(new File(filePath));
            Response response = fileUploadService.uploadFile(inputStream);
            QiNiuPutResult qiNiuPutResult = gson.fromJson(response.bodyString(), QiNiuPutResult.class);
            logger.debug(qiNiuPutResult + "");
            Assert.assertTrue(response.isOK());
            System.out.println("qiNiuPutResult = " + qiNiuPutResult);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (QiniuException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除图片
     */
    @Test
    public void delete() {
        String key = "FnPmHd0AlIeTVMgyOKuiyfMeIXc8";
        try {
            Response response = fileUploadService.delete(key);
            Assert.assertTrue(response.isOK());
        } catch (QiniuException e) {
            throw new RuntimeException(e);
        }
    }
}