package com.intelsis.latam.saludo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intelsis.latam.saludo.domain.InfoCliente;
import com.intelsis.latam.saludo.service.SaludoService;


@RequestMapping(value = "")
@RestController
public class SaludoController {
	
@Autowired	
private SaludoService saludoService;
	
	@GetMapping(value = "/faltantes{nombre}{fechaNacimiento}")
	public ResponseEntity<InfoCliente> obtenerPeriodosFaltantes(String nombre , @DateTimeFormat(pattern="dd-MM-yyyy") Date fechaNacimiento){
		return new ResponseEntity<InfoCliente>(saludoService.GetInfoCliente(nombre,fechaNacimiento ), HttpStatus.OK);
	}
	
	
	

}
