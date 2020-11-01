package com.intelsis.latam.saludo.domain.response;

import java.io.Serializable;

public class RsPoet  implements Serializable{

	
	private static final long serialVersionUID = 1L;

	String name ; 
	String url; 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
