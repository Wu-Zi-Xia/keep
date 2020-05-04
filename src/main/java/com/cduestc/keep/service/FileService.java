package com.cduestc.keep.service;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {
    @Autowired
    UserService userService;


    //获取cos客户端
    public COSClient getCosClient(){
        //1设置访问的秘钥
        String  secretId = "AKIDA7JH2ZitfBTbT5HWLuCXjmbCZgyMGibE";
        String secretKey = "XppnUosgDYcPvAG8JGvKSkna7OPAYhbI";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        Region region = new Region("ap-chengdu");
        //对客户端进行属性设置，可以设置很多的属性
        ClientConfig clientConfig = new ClientConfig(region);
        // 3 生成 cos 客户端
        COSClient cosClient = new COSClient(cred, clientConfig);
        return cosClient;
    }
    public String upload(MultipartFile file, FileInputStream fileInputStream, COSClient cosClient, String key) throws IOException {
        try {
            //从文件中去获取到文件的流
            fileInputStream =(FileInputStream)file.getInputStream();
            ObjectMetadata objectMetadata = new ObjectMetadata();
            // 设置输入流长度为500
            objectMetadata.setContentLength(fileInputStream.available());
            // 设置 Content type, 默认是 application/octet-stream
            // 指定要上传到的存储桶
            String bucketName = "wuzixia-1300212146";
            // 指定要上传到 COS 上对象键（对象键其实就是你在 存储桶中的图片所在的路径/图片的名称）

            String originalFileName=file.getOriginalFilename();
           //String key = "communityApplication/"+System.currentTimeMillis()+originalFileName;
            //通过创建的cos客户端，执行文件上传的请求。
            PutObjectResult putObjectResult = cosClient.putObject(bucketName,key,fileInputStream,objectMetadata);
            String etag = putObjectResult.getETag();
//            System.out.println("==========================="+putObjectResult.getDateStr());
            if (putObjectResult!=null&&etag!=null)
            {
//                https://wuzixia-1300212146.cos.ap-chengdu.myqcloud.com/communityApplication/2019-10-19%2017%3A27%3A29280082-151001215G3.jpg
                return " https://wuzixia-1300212146.cos.ap-chengdu.myqcloud.com/"+key;
            }

        } catch (CosServiceException serverException) {
            serverException.printStackTrace();

        } catch (CosClientException clientException) {
            clientException.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream!=null){
            fileInputStream.close();
            }
        }
        return null;
    }


    public int update(Long userId, MultipartFile file) throws IOException {
        //https://wuzixia-1300212146.cos.ap-chengdu.myqcloud.com/keep/avatarURL/37.png
        //获取当前用户原有的头像的地址
        String avatarURL = userService.getAvatarURL(userId);
        String oldKey=getOldKey(avatarURL);
        //获取客户端
        COSClient cosClient = getCosClient();
        // Bucket的命名格式为 BucketName-APPID ，此处填写的存储桶名称必须为此格式
        // 指定要上传到的存储桶
        String bucketName = "wuzixia-1300212146";
        //删除原有的头像
        cosClient.deleteObject(bucketName, oldKey);
        String originalFileName=file.getOriginalFilename();
        String newKey = "keep/avatarURL/"+System.currentTimeMillis()+originalFileName;
        FileInputStream fileInputStream=null;
        String newAvatarURLString = upload(file, fileInputStream, cosClient, newKey);
        int i = userService.updateAvatarURL(newAvatarURLString, userId);
        return i;
    }

    protected String getOldKey(String a){
        // "https://wuzixia-1300212146.cos.ap-chengdu.myqcloud.com/keep/avatarURL/37.png";
        String[] arr = a.split("/");
        int len=0;
        for(int i=0;i<3;i++){
            len+=arr[i].length();
            //System.out.println(arr[i]);
        }
        len+=3;
        //System.out.println(len);
        return a.substring(len);
    }
    //上传图片
    public String uploadPostImages(MultipartFile[] files) throws IOException {
        int length = files.length;
        List<String> URLs=new ArrayList<>();
        COSClient cosClient = getCosClient();
        for(int i=0;i<files.length;i++){
            MultipartFile file = files[i];
            String newKey = "keep/postImageURL/"+System.currentTimeMillis()+file.getOriginalFilename();
            FileInputStream fileInputStream=null;
            String newAvatarURLString = upload(file, fileInputStream, cosClient, newKey);
            URLs.add(newAvatarURLString);
        }
        //获取到url地址
        String s = StringUtils.join(URLs.toArray(),",");
        return s;
    }

    public String uploadPostVideo(MultipartFile video) throws IOException {
        COSClient cosClient = getCosClient();
        String newKey = "keep/postVideoURL/"+System.currentTimeMillis()+video.getOriginalFilename();
        FileInputStream fileInputStream=null;
        String newVideoURLString = upload(video, fileInputStream, cosClient, newKey);
        return newVideoURLString;
    }
}
