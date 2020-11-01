package com.intelsis.latam.saludo.domain;

import java.io.Serializable;

public class InfoCliente implements Serializable{
	

	private static final long serialVersionUID = -6643740854598190125L;
	
	private String primerNombre;
	private String apellidos;
	private Integer edad;
	private Integer difNacimiento;
	
	private PoemaSaludo poemaSaludo;
	
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Integer getDifNacimiento() {
		return difNacimiento;
	}
	public void setDifNacimiento(Integer difNacimiento) {
		this.difNacimiento = difNacimiento;
	}

	public PoemaSaludo getPoemaSaludo() {
		return poemaSaludo;
	}
	public void setPoemaSaludo(PoemaSaludo poemaSaludo) {
		this.poemaSaludo = poemaSaludo;
	}


	
	

}
