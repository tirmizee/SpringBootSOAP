package com.spring.bean;

import java.io.Serializable;

public class Response<T> implements Serializable {

	private static final long serialVersionUID = -182509847570999087L;

	private String messageCode;
	private String messageDesc;
	private T detail;

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getMessageDesc() {
		return messageDesc;
	}

	public void setMessageDesc(String messageDesc) {
		this.messageDesc = messageDesc;
	}

	public T getDetail() {
		return detail;
	}

	public void setDetail(T detail) {
		this.detail = detail;
	}
	
}
