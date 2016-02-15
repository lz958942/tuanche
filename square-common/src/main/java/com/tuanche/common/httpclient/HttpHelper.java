package com.tuanche.common.httpclient;
 
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.FileBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
/**
 * HTTP工具类，封装HttpClient4.3.x来对外提供简化的HTTP请求
 * @author   zhangpeng
 * @Date     2016-01-30    
 */
public class HttpHelper {
    /*GET请求的时间定义在此*/
    private static Integer socketTimeout            = 50;
    private static Integer connectTimeout           = 6000;
    private static Integer connectionRequestTimeout = 50;
    private final static Logger logger = LoggerFactory.getLogger(HttpHelper.class);
 
    /**
     * 使用Get方式 根据URL地址，获取ResponseContent对象
     * 
     * @param url
     *            完整的URL地址，编码格式默认为UTF-8
     * @return ResponseContent 如果发生异常则返回null，否则返回ResponseContent对象
     */
    public static ResponseContent getUrlRespContent(String url) throws Exception {
        HttpClientWrapper hw = new HttpClientWrapper(connectionRequestTimeout, connectTimeout, socketTimeout);
        ResponseContent response = null;
        try {
        	 if(url!=null){
    			 logger.info("getUrlRespContent方法，String格式的参数，参数为："+url.toString()); 
    		 }
            response = hw.getResponse(url);
        } catch (Exception e) {
        	logger.error("getUrlRespContent方法异常");
            e.printStackTrace();
            throw e;
        }
        return response;
    }
 
    /**
     * 使用Get方式 根据URL地址，获取ResponseContent对象
     * 
     * @param url
     *            完整的URL地址
     * @param urlEncoding 
     *            编码，可以为null
     * @return ResponseContent 如果发生异常则返回null，否则返回ResponseContent对象
     */
    public static ResponseContent getUrlRespContent(String url, String urlEncoding) throws Exception {
        HttpClientWrapper hw = new HttpClientWrapper(connectionRequestTimeout, connectTimeout, socketTimeout);
        ResponseContent response = null;
        try {
        	 if(url!=null){
    			 logger.info("getUrlRespContent方法，String格式的参数，参数为："+url.toString()); 
    		 }
            response = hw.getResponse(url, urlEncoding);
        } catch (Exception e) {
        	logger.error("getUrlRespContent方法异常");
            e.printStackTrace();
            throw e;
        }
        return response;
    }
 
    /**
     * 将参数拼装在url中，进行post请求。
     * 返回数据用UTF-8编码
     * @param url
     * @return
     */
    public static ResponseContent postUrl(String url) throws Exception{
        HttpClientWrapper hw = new HttpClientWrapper();
        ResponseContent ret = null;
        try {
        	 if(url!=null){
    			 logger.info("postUrl方法，String格式的参数，参数为："+url.toString()); 
    		 }
            setParams(url, hw);
            ret = hw.postNV(url);
        } catch (Exception e) {
        	logger.error("postUrl方法异常");
            e.printStackTrace();
            throw e;
        }
        return ret;
    }
    /**
     * 将拼装在url中的参数，进行解析，放到List<NameValuePair>中
     * 
     * @param url hw
     * @return hw中的nameValuePostBodies属性中
     */
    private static void setParams(String url, HttpClientWrapper hw) {
        String[] paramStr = url.split("[?]", 2);
        if (paramStr == null || paramStr.length != 2) {
            return;
        }
        String[] paramArray = paramStr[1].split("[&]");
        if (paramArray == null) {
            return;
        }
        for (String param : paramArray) {
            if (param == null || "".equals(param.trim())) {
                continue;
            }
            String[] keyValue = param.split("[=]", 2);
            if (keyValue == null || keyValue.length != 2) {
                continue;
            }
            hw.addNV(keyValue[0], keyValue[1]);
        }
    }
 
    
    /**
     * 使用post方式，List<NameValuePair>
     * 
     * @param url
     *            URL地址
     * @param List<NameValuePair>
     *            NameValuePair的列表
     * @return ResponseContent 如果发生异常则返回空，否则返回ResponseContent对象
     */
    public static ResponseContent postEntity(String url, List<NameValuePair> param,String contentType)throws Exception {
    	 ResponseContent ret = null;
    	 HttpClientWrapper hw = new HttpClientWrapper();
    	 try {
    		 if(param!=null){
    			 logger.info("postEntity方法，List<NameValuePair>格式的参数，参数为："+param.toString()); 
    		 }
             hw.setNameValuePostBodies(param);
             ret = hw.postNV(url, contentType);
         } catch (Exception e) {
        	 logger.error("postEntity方法异常");
             e.printStackTrace();
             throw e;
         }
    	 return ret;
    }
    /**
     * 使用post方式，Map<String,String>
     * 
     * @param url
     *            URL地址
     * @param map<String,String>
     *            map参数键值对
     * @return ResponseContent 如果发生异常则返回空，否则返回ResponseContent对象
     */
    public static ResponseContent postEntity(String url, Map<String,String> param,String contentType)throws Exception {
    	 ResponseContent ret = null;
    	 HttpClientWrapper hw = new HttpClientWrapper();
    	 try {
    		 if(param!=null){
    			 logger.info("postEntity方法，Map<String,String>格式的参数，参数为："+param.toString()); 
    		 }
    		 setMapParams(param,hw);
             ret = hw.postNV(url, contentType);
         } catch (Exception e) {
        	 logger.error("postEntity方法异常");
             e.printStackTrace();
             throw e;
         }
    	 return ret;
    }
    /**
     * 把map<String,String>转换成List<NameValuePair>
     * 
     * @param param
     *            Map<String, String> 
     * @param hw
     *            HttpClientWrapper对象，里面有List<NameValuePair>属性
     * @return ResponseContent 如果发生异常则返回空，否则返回ResponseContent对象
     */
	public static void setMapParams(Map<String, String> param,HttpClientWrapper hw) throws Exception {
		try {
			for (String key : param.keySet()) {
				 hw.addNV(key, param.get(key));
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
/*===============================================================华丽的分割线，以下方法待研究======================================================*/
	/**
     * 上传文件（包括图片） 
     * 
     * @param url
     *            请求URL
     * @param paramsMap
     *            参数和值
     * @return
     */
    public static ResponseContent postEntity(String url, Map<String, Object> paramsMap) {
        HttpClientWrapper hw = new HttpClientWrapper();
        ResponseContent ret = null;
        try {
            setParams(url, hw);
            Iterator<String> iterator = paramsMap.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                Object value = paramsMap.get(key);
                if (value instanceof File) {
                    FileBody fileBody = new FileBody((File) value);
                    hw.getContentBodies().add(fileBody);
                } else if (value instanceof byte[]) {
                    byte[] byteVlue = (byte[]) value;
                    ByteArrayBody byteArrayBody = new ByteArrayBody(byteVlue, key);
                    hw.getContentBodies().add(byteArrayBody);
                } else {
                    if (value != null && !"".equals(value)) {
                        hw.addNV(key, String.valueOf(value));
                    } else {
                        hw.addNV(key, "");
                    }
                }
            }
            ret = hw.postEntity(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
 
    /**
     * 使用post方式，发布对象转成的json给Rest服务。
     * 
     * @param url
     * @param jsonBody
     * @return
     */
    public static ResponseContent postJsonEntity(String url, String jsonBody) {
        return postEntity(url, jsonBody, "application/json");
    }
 
    /**
     * 使用post方式，发布对象转成的xml给Rest服务
     * 
     * @param url
     *            URL地址
     * @param xmlBody
     *            xml文本字符串
     * @return ResponseContent 如果发生异常则返回空，否则返回ResponseContent对象
     */
    public static ResponseContent postXmlEntity(String url, String xmlBody) {
        return postEntity(url, xmlBody, "application/xml");
    }
    
    /**
     * 处理post请求的参数，把json和xml字符串转换成List<NameValuePair>
     * 
     * @param url
     *            完整的URL地址
     * @param body
     *            json或者xml字符串       
     * @return ResponseContent 如果发生异常则返回null，否则返回ResponseContent对象
     */
    private static ResponseContent postEntity(String url, String body, String contentType) {
        HttpClientWrapper hw = new HttpClientWrapper();
        ResponseContent ret = null;
        try {        	
            hw.addNV("body", body);
            ret = hw.postNV(url, contentType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}