package com.tuanche.httpClient4.httpClient;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.tuanche.common.imageUtil.ImgCompress;
import com.tuanche.common.upload.FtpApcheUntil;

/**
 * Unit test for simple App.
 */
public class ImageTest {
	@Test
	public void resizeFix() {
		System.out.println("开始：" + new Date().toLocaleString());
		ImgCompress imgCom;
		try {
			imgCom = new ImgCompress("f:\\桥.png");
			File file=imgCom.resizeFix(400, 4000,"_b");//压缩的宽和高
			System.out.println("结束：" + new Date().toLocaleString());
			System.out.println(file.getPath());
			String url = "172.16.12.71";       
	        List<String> fileList=new ArrayList<String>();
	        fileList.add(file.getPath());
	         FtpApcheUntil.upload("/testUpload", fileList, url, "activity_port", "activity_port");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//要压缩的文件
 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
}
