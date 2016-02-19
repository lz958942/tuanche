package com.tuanche.common.imageUtil;

import java.io.*;
import java.util.Date;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import com.sun.image.codec.jpeg.*;

/**
 * 图片压缩处理
 * 
 * @author zhangpeng
 */
public class ImgCompress {
	private Image img;
	private int width;
	private int height;
	private String fileName;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		System.out.println("开始：" + new Date().toLocaleString());
		ImgCompress imgCom = new ImgCompress("f:\\桥.png");//要压缩的文件
		File file=imgCom.resizeFix(400, 4000,"_b");//压缩的宽和高
		System.out.println("结束：" + new Date().toLocaleString());
		System.out.println(file.getName());
	}

	/**
	 * 构造函数
	 */
	public ImgCompress(String fileName) throws IOException {
		File file = new File(fileName);// 读入文件
		img = ImageIO.read(file); // 构造Image对象
		width = img.getWidth(null); // 得到源图宽
		height = img.getHeight(null); // 得到源图长
		this.fileName=fileName;// 得到文件名称
	}

	/**
	 * 按照宽度还是高度进行压缩
	 * 
	 * @param w
	 *            int 最大宽度
	 * @param h
	 *            int 最大高度
	 * @param afterStr
	 *            String 压缩后图片所跟后缀
	 * @return 
	 */
	public File resizeFix(int w, int h,String afterStr) throws IOException {
		if (width / height > w / h) {
			return resizeByWidth(w,afterStr);
		} else {
			return resizeByHeight(h,afterStr);
		}
	}

	/**
	 * 以宽度为基准，等比例放缩图片
	 * 
	 * @param w
	 *            int 新宽度
	 * @return 
	 */
	public File resizeByWidth(int w,String afterStr) throws IOException {
		int h = (int) (height * w / width);
		return resize(w, h, afterStr);
	}

	/**
	 * 以高度为基准，等比例缩放图片
	 * 
	 * @param h
	 *            int 新高度
	 * @return 
	 */
	public File resizeByHeight(int h,String afterStr) throws IOException {
		int w = (int) (width * h / height);
		return resize(w, h, afterStr);
	}

	/**
	 * 强制压缩/放大图片到固定的大小
	 * 
	 * @param w
	 *            int 新宽度
	 * @param h
	 *            int 新高度
	 */
	public File resize(int w, int h,String afterStr) throws IOException {
		// SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
		BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图
		int point=fileName.lastIndexOf(".");
		String frontName=fileName.substring(0, point);
		String lastName=fileName.substring(point);
		File destFile = new File(frontName+afterStr+lastName);
		FileOutputStream out = new FileOutputStream(destFile); // 输出到文件流
		// 可以正常实现bmp、png、gif转jpg
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(image); // JPEG编码
		out.close();
		return destFile;
	}
}
