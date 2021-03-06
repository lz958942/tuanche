/**
 * ResponseContent.java
 * com.jfly.core.httpclient
 * Copyright (c) 2016.
*/
 
package com.tuanche.common.httpclient;
 
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
 
/**
 * 封装HttpClient返回数据
 * <p>
 * @author   zhangpeng
 * @Date     2016-01-30     
 */
public class ResponseContent implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String encoding;
 
    private byte[] contentBytes;
 
    private int statusCode;
 
    private String contentType;
 
    private String contentTypeString;
 
    public String getEncoding() {
        return encoding;
    }
 
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
 
    public String getContentType() {
        return this.contentType;
    }
 
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
 
    public String getContentTypeString() {
        return this.contentTypeString;
    }
 
    public void setContentTypeString(String contenttypeString) {
        this.contentTypeString = contenttypeString;
    }
 
    public String getContent() throws UnsupportedEncodingException {
        return this.getContent(this.encoding);
    }
 
    @SuppressWarnings("hiding")
    public String getContent(String encoding) throws UnsupportedEncodingException {
        if (encoding == null) {
            return new String(contentBytes);
        }
        return new String(contentBytes, encoding);
    }
 
    public String getUTFContent() throws UnsupportedEncodingException {
        return this.getContent("UTF-8");
    }
 
    public byte[] getContentBytes() {
        return contentBytes;
    }
 
    public void setContentBytes(byte[] contentBytes) {
        this.contentBytes = contentBytes;
    }
 
    public int getStatusCode() {
        return statusCode;
    }
 
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
 
}