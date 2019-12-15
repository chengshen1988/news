package com.news.hr.framework.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.PutObjectResult;
import com.news.hr.framework.model.FileSettings;
import com.news.hr.framework.model.Properties;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OSSUtils {

    private static String endpoint = Properties.endpoint;
    private static String accessKeyId = Properties.accessKeyId;
    private static String accessKeySecret = Properties.accessKeySecret;
    private static String bucket = Properties.bucket;

    public static OSS getOSSClient() {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        return ossClient;
    }

    /**
     * 上传文件
     * @param file
     * @param fileSettings
     * @return
     */
    public static String upload(MultipartFile file, FileSettings fileSettings) {
        OSS ossClient = null ;
        InputStream inputStream = null;
        if(StringUtils.isEmpty(fileSettings.getFileStoreName())){
            fileSettings.setFileStoreName(UUID.randomUUID().toString());
        }
        if(fileSettings.getFileDir()==null){
            fileSettings.setFileDir(FileSettings.FileDirEnum.DEFAULT_DIRECOTRY);
        }
        String destFileName = String.format("%s.%s", fileSettings.getFileStoreName(), FilenameUtils.getExtension(file.getOriginalFilename()));
        String filePath = fileSettings.getFileDir().getDir() + destFileName;
        try {
            ossClient = getOSSClient();
            inputStream = file.getInputStream();
            PutObjectResult result = ossClient.putObject(bucket, filePath, inputStream);
        } catch (Exception e) {
            throw new RuntimeException("文件上传失败", e);
        } finally {
            IOUtils.closeQuietly(inputStream);
            if(ossClient!=null){
                ossClient.shutdown();
            }
        }
        return filePath;
    }

    /**
     * 下载文件
     * @param filePath
     * @param fileName
     */
    public static void download(String filePath, String fileName) {
        OSS ossClient = null ;
        InputStream in = null;
        OutputStream out = null;
        try {
            ossClient = getOSSClient();
            HttpServletResponse response = WebUtils.getResponse();
            OSSObject ossObject = ossClient.getObject(bucket, filePath);
            response.reset();
            response.addHeader("Access-Control-Expose-Headers", "Content-Disposition");
            response.addHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "utf-8"));
            response.setHeader("Access-Control-Allow-Origin", "*"); 
            out = response.getOutputStream();
            in = ossObject.getObjectContent();
            int b=0;
            byte[] buffer = new byte[512];
            while (b != -1){
                b = in.read(buffer);
                out.write(buffer,0,b);
            }
        } catch (Exception e) {
            throw new RuntimeException("文件下载失败", e);
        } finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
            if(ossClient!=null){
                ossClient.shutdown();
            }
        }
    }

    /**
     * 根据文件路径删除文件
     * @param filePath
     */
    public static void delete(String filePath){
        OSS ossClient = null ;
        try {
            ossClient = getOSSClient();
            ossClient.deleteObject(bucket, filePath);
        } catch (Exception e) {
            throw new RuntimeException("文件删除失败", e);
        } finally {
            if(ossClient!=null){
                ossClient.shutdown();
            }
        }
    }

    /**
     * 获取已上传的文件列表
     * @return
     */
    public List<String> getList(){
        OSS ossClient = null ;
        List<String> listName = new ArrayList();
        try {
            ossClient = getOSSClient();
            ObjectListing objectListing = ossClient.listObjects(bucket);
            List<OSSObjectSummary> list = objectListing.getObjectSummaries();
            for (int i = 0; i < list.size(); i++) {
                listName.add(list.get(i).getKey());
            }
            return listName;
        } catch (Exception e) {
            throw new RuntimeException("文件删除失败", e);
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

}
