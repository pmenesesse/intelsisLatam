package com.intelsis.latam.saludo.domain;

public class PoemaSaludo {

	private String tituloPoema; 
	private String poema;
	private String autorPoema;
	private String msjFelicitacion;
	private Long difDiasCump ;
	
	
	

	public Long getDifDiasCump() {
		return difDiasCump;
	}
	public void setDifDiasCump(Long difDiasCump) {
		this.difDiasCump = difDiasCump;
	}
	public String getMsjFelicitacion() {
		return msjFelicitacion;
	}
	public void setMsjFelicitacion(String msjFelicitacion) {
		this.msjFelicitacion = msjFelicitacion;
	}
	public String getTituloPoema() {
		return tituloPoema;
	}
	public void setTituloPoema(String tituloPoema) {
		this.tituloPoema = tituloPoema;
	}
	public String getPoema() {
		return poema;
	}
	public void setPoema(String poema) {
		this.poema = poema;
	}
	public String getAutorPoema() {
		return autorPoema;
	}
	public void setAutorPoema(String autorPoema) {
		this.autorPoema = autorPoema;
	}
	
}
