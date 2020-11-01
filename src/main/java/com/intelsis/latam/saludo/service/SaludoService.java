package com.intelsis.latam.saludo.service;

import java.util.Date;

import com.intelsis.latam.saludo.domain.InfoCliente;

public interface SaludoService {

	public InfoCliente GetInfoCliente(String nombre, Date fechaNacimiento);



	
}
