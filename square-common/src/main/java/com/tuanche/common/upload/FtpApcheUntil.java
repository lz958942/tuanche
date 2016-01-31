package com.tuanche.common.upload;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class FtpApcheUntil {
	 /**
     * Description: 向FTP服务器上传文件
     *
     * @Version1.0
     * @param url
     *            FTP服务器hostname
     * @param port
     *            FTP服务器端口
     * @param username
     *            FTP登录账号
     * @param password
     *            FTP登录密码
     * @param path
     *            FTP服务器保存目录,如果是根目录则为“/”
     * @param filename
     *            上传到FTP服务器上的文件名
     * @param input
     *            本地文件输入流
     * @return 成功返回true，否则返回false
     */
	public static void upload(String ftpPath,List<String> fileList,String host,String userName,String passWord) throws Exception {
		 if(fileList!=null&&fileList.size()>0){
			 FileInputStream in =null;
			 for(String fileUrl:fileList){
     				try {
						in= new FileInputStream(fileUrl);
						String fileName=fileUrl.substring(fileUrl.lastIndexOf(File.separator)+1);
						FtpUtil.ftpUpload(
								host,
								userName,
								passWord,
									in, ftpPath, fileName);
						new File(fileUrl).delete();   //删除图片
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							if(in!=null){
								try {
									in.close();
								} catch (Exception e2) {
									e2.printStackTrace();
								}
					    }
					}
     			}
			 }
		 }
	
    /**
     * Description: 从FTP服务器下载文件
     *
     * @Version1.0
     * @param url
     *            FTP服务器hostname
     * @param port
     *            FTP服务器端口
     * @param username
     *            FTP登录账号
     * @param password
     *            FTP登录密码
     * @param remotePath
     *            FTP服务器上的相对路径
     * @param fileName
     *            要下载的文件名
     * @param localPath
     *            下载后保存到本地的路径
     * @return
     */
	public static void download(String ftpHost, int port, String ftpUserName,
            String ftpPassword, String remotePath, String fileName,
            String localPath) throws Exception {
		FtpUtil.downFile(ftpHost, port, ftpUserName, ftpPassword, remotePath, fileName, localPath);
		 }
}
