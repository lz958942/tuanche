package com.tuanche.httpClient4.httpClient;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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
		//testPost1();
		
		String str="http://12306.com4234234234fdsafsaf423432fsdf";
		Pattern pattern = Pattern.compile("[0-9]+");
		String[] strs = pattern.split(str);
		for (int i=0;i<strs.length;i++) {
		    System.out.println(strs[i]);
		} 
		
		Pattern pattern1 = Pattern.compile("[^0-9]+");
		String[] strs1 = pattern1.split(str);
		for (int i=0;i<strs1.length;i++) {
		    System.out.println(strs1[i]);
		} 
		
	}
	
    //test
    public static void testGet() {
        String url = "http://172.16.12.43:9199/chooseGoodCar/getGoodCarLabels";
        ResponseContent responseContent;
		try {
			responseContent = HttpHelper.getUrlRespContent(url);
			System.out.println(responseContent.getContent());
            System.out.println(responseContent.getContent("utf-8"));
            System.out.println(responseContent.getContentType());
            System.out.println(responseContent.getContentTypeString());
            System.out.println(responseContent.getEncoding());
            System.out.println(responseContent.getStatusCode());
            System.out.println(responseContent.getUTFContent());
            System.out.println(responseContent.getContentBytes());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
    }
    //test
    public static void testGetEncoding() {
        String url = "http://172.16.12.43:9199/chooseGoodCar/getGoodCarLabels";
        ResponseContent responseContent;
		try {
			responseContent = HttpHelper.getUrlRespContent(url,"gbk");
			 System.out.println(responseContent.getContent());
	            System.out.println(responseContent.getContent("utf-8"));
	            System.out.println(responseContent.getContentType());
	            System.out.println(responseContent.getContentTypeString());
	            System.out.println(responseContent.getEncoding());
	            System.out.println(responseContent.getStatusCode());
	            System.out.println(responseContent.getUTFContent());
	            System.out.println(responseContent.getContentBytes());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
        String url = "http://172.16.12.43:9199/chooseGoodCar/getGoodCarList?carLabelId=1";
        ResponseContent responseContent;
		try {
			responseContent = HttpHelper.postUrl(url);
			 System.out.println(responseContent.getContent());
	            System.out.println(responseContent.getContent("utf-8"));
	            System.out.println(responseContent.getContentType());
	            System.out.println(responseContent.getContentTypeString());
	            System.out.println(responseContent.getEncoding());
	            System.out.println(responseContent.getStatusCode());
	            System.out.println(responseContent.getUTFContent());
	            System.out.println(responseContent.getContentBytes());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
