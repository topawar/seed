package com.seed.utils;

import com.alibaba.fastjson2.JSON;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import com.qcloud.cos.utils.UrlEncoderUtils;
import com.seed.config.cosConfig;
import com.seed.constants.CosConstant;

import java.io.File;
import java.util.Base64;

/**
 * @author: YJ
 * @createTime: 2022/06/17 14:38
 * @company: https://www.xxx.cn
 * @description: 腾讯云cos存储
 */
public class CosUtils {
    static COSClient cosClient;

    static {
        BasicCOSCredentials cre = new BasicCOSCredentials(CosConstant.SECRET_ID, CosConstant.SECRET_KEY);
        ClientConfig clientConfig = new ClientConfig(new Region("ap-shanghai"));
        cosClient = new COSClient(cre, clientConfig);
    }

    static void createBucket(String bucketName) {
        bucketName = String.format("%s-%s", bucketName, CosConstant.APPID);
        System.out.println(bucketName);
        CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
        createBucketRequest.setCannedAcl(CannedAccessControlList.PublicRead);
        Bucket cosClientBucket = cosClient.createBucket(createBucketRequest);
        cosClient.shutdown();
    }

    static Object putFile(String path,String bucketPath,String bucketName) {
        cosConfig cosConfig = new cosConfig();
        Object toJSON;
        String key = bucketPath.concat(path.substring(path.lastIndexOf("/")));
        System.out.println(key);
        try {
            File file = new File(path);
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);
            cosClient.putObject(putObjectRequest);
            //https://test-1306904200.cos.ap-shanghai.myqcloud.com/favicon2.ico
            String url = String.format("%s://%s.%s/%s", CosConstant.REQUEST,bucketName,
                    CosConstant.BUCKET_REGION,key);
            cosConfig.setStatus("1");
            cosConfig.setUrl(url);
            cosConfig.setMessage("200");
            toJSON = JSON.toJSON(cosConfig);
        } catch (Exception e) {
            //todo 异常处理逻辑有问题
            cosConfig.setStatus("0");
            cosConfig.setMessage("500");
            toJSON = JSON.toJSON(cosConfig);
            e.printStackTrace();
        } finally {
            cosClient.shutdown();
        }
        return toJSON;
    }

    static void getFile(String key) {
        try {
            GetObjectRequest getObjectRequest = new GetObjectRequest(CosConstant.TEST_BUCKETNAME, key);
            File localFile = new File("头像.png");
            ObjectMetadata objectMetadata = cosClient.getObject(getObjectRequest, localFile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cosClient.shutdown();
        }
    }

    public static void main(String[] args) {
        System.out.println(putFile("src/main/resources/static/images/img1.png",CosConstant.IMAGES,CosConstant.PROD_BUCKETNAME));
//        getFile("头像");
    }
}
