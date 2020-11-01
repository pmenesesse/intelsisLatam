package com.intelsis.latam.saludo.service;



import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.intelsis.latam.saludo.domain.InfoCliente;
import com.intelsis.latam.saludo.domain.PoemaSaludo;
import com.intelsis.latam.saludo.domain.response.RsPoema;

@Service
public class SaludoServiceImpl implements SaludoService {

	private static final int INDEX_P_APELLIDO = 1;

	private static final int INDEX_P_NOMBRE = 0;

	private static final String ESPACIO = " ";

	private static final String DF_CUMPLEANIOS = "dd-MM";
	private static final String DF_CUMPLEANIOS_DIAS = "dd-MM-yyyy";
	
	@Value("${service-poemist.url}")
	private String poemist;
	
	@Value("${mensaje.saludo-cumpleanio}")
	private String msjCumpleanio;

	@Override
	public InfoCliente GetInfoCliente(String nombreCompleto, Date fechaNacimiento) {
	
		InfoCliente infoCliente = new InfoCliente();
		
		infoCliente.setPoemaSaludo(getSaludo(nombreCompleto,fechaNacimiento));
		infoCliente.setEdad(calcularEdad(fechaNacimiento));
		infoCliente.setPrimerNombre(geNombreDif(nombreCompleto,INDEX_P_NOMBRE));
		infoCliente.setApellidos(geNombreDif(nombreCompleto,INDEX_P_APELLIDO));
		
		return infoCliente;
			
	}
	

	private String geNombreDif(String nombre, int idxNombre) {
		String nombreSolicitado = null;
		
		String nombreSeparado[] = nombre.split(ESPACIO);
		if(nombreSeparado.length == 2 ) {
			nombreSolicitado = nombreSeparado[idxNombre];
			
		}else if(nombreSeparado.length == 3) {
			if(idxNombre == 0 ) {
				nombreSolicitado = nombreSeparado[idxNombre].
						concat(ESPACIO + nombreSeparado[idxNombre + 1] );
			}else {
				nombreSolicitado = nombreSeparado[idxNombre +1];
			}
				
		}else if(nombreSeparado.length == 4) {
			if(idxNombre == 0 ) {
				nombreSolicitado = nombreSeparado[idxNombre].
						concat(ESPACIO + nombreSeparado[idxNombre + 1] ).
						concat(ESPACIO + nombreSeparado[idxNombre + 2] );
			}else {
				nombreSolicitado = nombreSeparado[idxNombre +2];
			}	
		}
		return nombreSolicitado;
	}






	private PoemaSaludo getSaludo(String nombre, Date fechaNacimiento ) {
		
		PoemaSaludo poemaSaludo = new PoemaSaludo(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat (DF_CUMPLEANIOS);
		if(dateFormat.format(fechaNacimiento).equals(dateFormat.format(new Date()))) {
			List<RsPoema> rs = getPoema(fechaNacimiento);
			poemaSaludo = getRandomPoema(rs,poemaSaludo );
			poemaSaludo.setMsjFelicitacion(msjCumpleanio);
			poemaSaludo.setDifDiasCump((long) 0);
		}else {
			poemaSaludo.setDifDiasCump(getDiferenciaCumpleanio(fechaNacimiento));
		}
		
		return poemaSaludo; 
	}

	private Long getDiferenciaCumpleanio(Date fechaNacimiento) {
		Long diasFaltantes; 
		Calendar calNacimiento = Calendar.getInstance();
		Calendar fchActualidad = Calendar.getInstance();
        calNacimiento.setTime(fechaNacimiento);
        int anioActual = fchActualidad.get(Calendar.YEAR);
        
        calNacimiento.set(fchActualidad.get(Calendar.YEAR), calNacimiento.get(Calendar.MONTH), calNacimiento.get(Calendar.DAY_OF_MONTH));
        if (calNacimiento.getTime().before(fchActualidad.getTime())) {
        	Long diff = fchActualidad.getTimeInMillis() - calNacimiento.getTimeInMillis();
		       diasFaltantes = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		}else {
			   calNacimiento.set(anioActual , calNacimiento.get(Calendar.MONTH), calNacimiento.get(Calendar.DAY_OF_MONTH));
		       Long diff =  calNacimiento.getTimeInMillis() - fchActualidad.getTimeInMillis();
		       diasFaltantes = 365 -(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)+1);
		}
		return  diasFaltantes; 
	}


	private List<RsPoema> getPoema(Date fechaNacimiento) {
		RestTemplate restTemplate = new RestTemplate();
		List<RsPoema> rs =  Arrays.asList(restTemplate.getForObject(poemist, RsPoema[].class));
		return rs;
	}



	private PoemaSaludo getRandomPoema(List<RsPoema> listaPoema, PoemaSaludo poemaSaludo) {
		
        Random aleatorio = new Random();
        RsPoema itemPoema = listaPoema.get(aleatorio.nextInt(listaPoema.size()));
        poemaSaludo.setAutorPoema(itemPoema.getPoet().getName());
        poemaSaludo.setPoema(itemPoema.getContent());
        poemaSaludo.setTituloPoema(itemPoema.getTitle());
		return poemaSaludo;
	}

	private Integer calcularEdad(Date fechaNacimiento) {
		Integer edad = 0; 
		if(fechaNacimiento.before(new Date())){
			Calendar calNacimiento = Calendar.getInstance();
			Calendar Actualidad = Calendar.getInstance();
	        calNacimiento.setTime(fechaNacimiento);
	        
	        
	        Integer anioNacimiento = calNacimiento.get(Calendar.YEAR);
			Integer mesNacimiento = calNacimiento.get(Calendar.MONTH);
			Integer diaNacimiento = calNacimiento.get(Calendar.DAY_OF_MONTH);

			Integer anioActual = Actualidad.get(Calendar.YEAR);
			Integer mesActual = Actualidad.get(Calendar.MONTH);
			Integer diaActual = Actualidad.get(Calendar.DAY_OF_MONTH);
			edad = anioActual - anioNacimiento;
			
			if (mesActual < mesNacimiento || (mesNacimiento == mesActual && diaActual < diaNacimiento)) {
			       edad--;
			}
			
		}
			
		return edad;
		
	}


}




