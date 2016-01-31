package com.tuanche.common.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import com.tuanche.commons.util.StringUtils;

public class FtpUtil {
    private static String encoding = System.getProperty("file.encoding");
	
    public static boolean delFile(String ftpHost,String ftpUserName,String ftpPassword,String filePath){
        FTPClient ftpClient = new FTPClient();
        FileInputStream fis = null;
        System.out.println("ftpHost="+ftpHost+" ftpUserName="+ftpUserName+" ftpPassword="+ftpPassword);
        boolean  res=false;
        File srcFile = null;
        try {
            ftpClient.setDataTimeout(60000);
            ftpClient.setDefaultTimeout(60000);
            ftpClient.connect(ftpHost);
            ftpClient.login(ftpUserName, ftpPassword);
            return ftpClient.deleteFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
           // throw new RuntimeException("FTP客户端出错！", e);
        } finally {
            try {
                ftpClient.logout();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
               // throw new RuntimeException("关闭FTP连接发生异常！", e);
            }

        }
           return false;
    }
    
    /**
     * FTP上传单个文件测试
     */
    public static boolean ftpUpload(String ftpHost,String ftpUserName,String ftpPassword,InputStream srcFile , String destDir,String fileName) {
        FTPClient ftpClient = new FTPClient();
        /*FileInputStream fis = null;*/
        boolean  res=false;
        try {
        	ftpClient.setDataTimeout(60000);
        	ftpClient.setDefaultTimeout(60000);
            ftpClient.connect(ftpHost);
            ftpClient.login(ftpUserName, ftpPassword);
            
            boolean result=FtpUtil.setDirectory(ftpClient,destDir);
            if(result){
                /* fis = new FileInputStream(srcFile);*/
                 ftpClient.setBufferSize(1024);
                 ftpClient.setControlEncoding("GBK");
                 ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE); 
                 ftpClient.storeFile(fileName, srcFile);
                
                 res=true;
            }else{
            	System.out.println("上传失败！！！！！");
            }
         
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("FTP客户端出错！", e);
        } finally {
            IOUtils.closeQuietly(srcFile);
            try {
				ftpClient.logout();
			} catch (IOException e) {
				e.printStackTrace();
			}
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("关闭FTP连接发生异常！", e);
            }
            
        }
        if(res){
        	/*srcFile.delete();*/
        	/*System.out.println("======delete=======");*/
        }
        /*System.out.println(res+"================================");*/
        return res;
    }
    public static boolean setDirectory(FTPClient ftpClient,String filePath,int index,int length) throws IOException{
    	boolean result=true;
    		 String[] ds=filePath.split("/");
    		 if(ds!=null&&ds.length>0){
    			
    			 result =ftpClient.changeWorkingDirectory(ds[index-1]);
    			 System.out.println(result+" change="+ds[index-1]);
    			 if(!result){
    				 
    				 result=ftpClient.makeDirectory(ds[index-1]);
    				 System.out.println(result+" make="+ds[index-1]);
    				 if(result){
    					
    					 result=ftpClient.changeWorkingDirectory(ds[index-1]);
    					 System.out.println(result+" change="+ds[index-1]);
    					 if(index+1<length&&result){
    						 System.out.println(result+" ========="+ds[index-1]);
        					 return	setDirectory(ftpClient,filePath,index+1,length);
    	    			 }else{
    	    				 
    	    				 return result;
    	    			 }
    				 }
    			 }else{
    				 if(index+1<length&&result){
 						return setDirectory(ftpClient,filePath,index+1,length);
	    			 }
    			 }
    		 }
    		 return false;
    }
    public static boolean setDirectory(FTPClient ftpClient,String filePath) throws IOException{
    	System.out.println("filePath="
    			+ ""+filePath);
    	int length=0;
    	if(StringUtils.isNotEmpty(filePath)){
	   		 String[] tmp=filePath.split("/");
	   		length=tmp.length;
	   	 }
	   	 boolean result =ftpClient.changeWorkingDirectory(filePath);
	   	 if(!result){
	   		result=setDirectory(ftpClient,filePath,1,length+1);
	   	 }
	   	 return result;
   }
   
    
    /**
     * FTP上传单个文件测试 (方法二)
     */
    public static boolean ftpUpload(String ftpHost,String ftpUserName,String ftpPassword,String  srcDir,String destDir,String fileName) {
        FTPClient ftpClient = new FTPClient();
        FileInputStream fis = null;
        /*System.out.println("ftpHost="+ftpHost+" ftpUserName="+ftpUserName+" ftpPassword="+ftpPassword);
        System.out.println("srcDir="+srcDir+" destDir="+destDir+" fileName="+fileName);*/
        boolean  res=false;
        File srcFile = null;
        try {
        	ftpClient.setDataTimeout(60000);
        	ftpClient.setDefaultTimeout(60000);
            ftpClient.connect(ftpHost);
            boolean isLogin = ftpClient.login(ftpUserName, ftpPassword);
            if(!isLogin){
            	throw new RuntimeException("ftp user"+ftpUserName+ "login failed!");
            }
            boolean result=FtpUtil.setDirectory(ftpClient,destDir);
            if(result){
            	  srcFile = new File(srcDir+fileName);
                 fis = new FileInputStream(srcFile);
                 ftpClient.setBufferSize(1024);
                 ftpClient.setControlEncoding("GBK");
                 ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                 ftpClient.storeFile(fileName, fis);
                
                 res=true;
            }else{
            	System.out.println("上传失败！！！！！");
            }
           
           
         
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("======delete======="+e.toString());  
            throw new RuntimeException("FTP客户端出错！", e);
        } finally {
            IOUtils.closeQuietly(fis);
            if(res){
            	srcFile.delete();
            	System.out.println("======delete=======");
            }
            try {
				ftpClient.logout();
			} catch (IOException e) {
				e.printStackTrace();
			}
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("关闭FTP连接发生异常！", e);
            }
            
        }
        return res;
    }
    
    public static boolean downFile(String url, int port, String username,
            String password, String remotePath, String fileName,
            String localPath) {
    	FTPClient ftpClient = new FTPClient();
        boolean result = false;
        try {
            int reply;
           
            ftpClient.setControlEncoding(encoding);
             
            /*
             *  为了上传和下载中文文件，有些地方建议使用以下两句代替
             *  new String(remotePath.getBytes(encoding),"iso-8859-1")转码。
             *  经过测试，通不过。
             */
//            FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
//            conf.setServerLanguageCode("zh");
 
            ftpClient.connect(url, port);
            // 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
            ftpClient.login(username, password);// 登录
            // 设置文件传输类型为二进制
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            // 获取ftp登录应答代码
            reply = ftpClient.getReplyCode();
            // 验证是否登陆成功
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                System.err.println("FTP server refused connection.");
                return result;
            }
            // 转移到FTP服务器目录至指定的目录下
            ftpClient.changeWorkingDirectory(new String(remotePath.getBytes(encoding),"iso-8859-1"));
            // 获取文件列表
            FTPFile[] fs = ftpClient.listFiles();
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    File localFile = new File(localPath + "/" + ff.getName());
                    OutputStream is = new FileOutputStream(localFile);
                    ftpClient.retrieveFile(ff.getName(), is);
                    is.close();
                }
            }
 
            ftpClient.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }
}

