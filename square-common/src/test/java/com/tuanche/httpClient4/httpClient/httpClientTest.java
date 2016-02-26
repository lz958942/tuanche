package com.tuanche.httpClient4.httpClient;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tuanche.common.httpclient.HttpHelper;
import com.tuanche.common.httpclient.ResponseContent;
import com.tuanche.common.upload.FtpApcheUntil;

public class httpClientTest {
	  @Test
	    public void testGet(){
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
	  
	  @Test
	    public  void testGetEncoding() {
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
	       
	  @Test 
	    public  void testUploadFile() {
	        try {
	            String url = "172.16.12.71";       
	            List<String> fileList=new ArrayList<String>();
	            fileList.add("C:\\Users\\Administrator\\Desktop\\resin.xml");
	             FtpApcheUntil.upload("/testUpload", fileList, url, "activity_port", "activity_port");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	  
	  @Test 
	    public  void testDownloadFile() {
	        try {
	            String url = "172.16.12.71";       
	            List<String> fileList=new ArrayList<String>();
	            fileList.add("C:\\Users\\Administrator\\Desktop\\resin.xml");
	             FtpApcheUntil.download(url,21,"activity_port", "activity_port", "/testUpload", "resin.xml", "C:\\Users\\Administrator\\Desktop\\");   

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	  @Test
	    public  void testPost() {
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
	  @Test
	    public void testPost1() {
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
