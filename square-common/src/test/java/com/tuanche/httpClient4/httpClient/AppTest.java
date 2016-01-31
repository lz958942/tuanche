package com.tuanche.httpClient4.httpClient;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tuanche.common.httpclient.HttpHelper;
import com.tuanche.common.httpclient.ResponseContent;
import com.tuanche.common.upload.FtpApcheUntil;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	public static void main(String[] args) {
		//testGet();
		//testGetEncoding();
		//testUploadFile();
		//testPost();
		testPost1();
	}
	
    //test
    public static void testGet() {
        String url = "http://172.16.12.43:9199/chooseGoodCar/getGoodCarLabels";
        ResponseContent responseContent = HttpHelper.getUrlRespContent(url);
        try {
            System.out.println(responseContent.getContent());
            System.out.println(responseContent.getContent("utf-8"));
            System.out.println(responseContent.getContentType());
            System.out.println(responseContent.getContentTypeString());
            System.out.println(responseContent.getEncoding());
            System.out.println(responseContent.getStatusCode());
            System.out.println(responseContent.getUTFContent());
            System.out.println(responseContent.getContentBytes());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    //test
    public static void testGetEncoding() {
        String url = "http://172.16.12.43:9199/chooseGoodCar/getGoodCarLabels";
        ResponseContent responseContent = HttpHelper.getUrlRespContent(url,"gbk");
        try {
            System.out.println(responseContent.getContent());
            System.out.println(responseContent.getContent("utf-8"));
            System.out.println(responseContent.getContentType());
            System.out.println(responseContent.getContentTypeString());
            System.out.println(responseContent.getEncoding());
            System.out.println(responseContent.getStatusCode());
            System.out.println(responseContent.getUTFContent());
            System.out.println(responseContent.getContentBytes());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
       
    //test
    public static void testUploadFile() {
        try {
            String url = "172.16.12.71";       
            List<String> fileList=new ArrayList<String>();
            fileList.add("C:\\Users\\Administrator\\Desktop\\nginx配置文件.txt");
             FtpApcheUntil.upload("/testUpload", fileList, url, "activity_port", "activity_port");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //test
    public static void testPost() {
        String url = "http://172.16.4.38:3084/chooseGoodCar/getGoodCarList?carLabelId=1";
        ResponseContent responseContent = HttpHelper.postUrl(url);
        try {
            System.out.println(responseContent.getContent());
            System.out.println(responseContent.getContent("utf-8"));
            System.out.println(responseContent.getContentType());
            System.out.println(responseContent.getContentTypeString());
            System.out.println(responseContent.getEncoding());
            System.out.println(responseContent.getStatusCode());
            System.out.println(responseContent.getUTFContent());
            System.out.println(responseContent.getContentBytes());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }   
    
    public static void testPost1() {
        String url = "http://dwz.cn/create.php";
        ResponseContent responseContent = HttpHelper.postJsonEntity(url,"");
        try {
            System.out.println(responseContent.getContent());
            System.out.println(responseContent.getContent("utf-8"));
            System.out.println(responseContent.getContentType());
            System.out.println(responseContent.getContentTypeString());
            System.out.println(responseContent.getEncoding());
            System.out.println(responseContent.getStatusCode());
            System.out.println(responseContent.getUTFContent());
            System.out.println(responseContent.getContentBytes());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }   

}
