package com.intelsis.latam.saludo.domain.response;

import java.io.Serializable;

public class RsPoema implements Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String title; 
	String content;
	String url; 
	RsPoet poet;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public RsPoet getPoet() {
		return poet;
	}
	public void setPoet(RsPoet poet) {
		this.poet = poet;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	} 

	
	
}
