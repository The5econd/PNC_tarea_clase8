package com.uca.capas.tarea_MVC.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/nombre")
	public @ResponseBody String ejemplo() {
		String nombre = "Nombre: Fernando  ";
		String apellido = "Apellido: Salazar  ";
		String carnet = "Carnet: 00017917  ";
		String carrera = "Ing. Informática  ";
		String anio = "Anio: 4to anio";
		String texto = nombre+"<br>" + apellido+"<br>" + carnet+"<br>" + carrera+"<br>" + anio+"<br>";
		return texto;
	}
	
	
	// fecha?dia=" "&mes" "&anio"  "
	@RequestMapping("/fecha")
	public @ResponseBody String parametro(HttpServletRequest request) {
		Integer param1 = Integer.parseInt(request.getParameter("dia"));
		Integer param2 = Integer.parseInt(request.getParameter("mes"));
		Integer param3 = Integer.parseInt(request.getParameter("anio"));
		int diaObtenido;
		String diaParaImprimir;
		
		Calendar calendario = Calendar.getInstance();
		
		//(anio/mes-1/dia) El mes inicia en 0 asi que le resto 1
		calendario.set(param3,param2-1,param1);
		diaObtenido =  calendario.get(Calendar.DAY_OF_WEEK);
		
		//comprobando la fecha con este print
		System.out.println(calendario.getTime());
		
		switch(diaObtenido) {
			case 1: diaParaImprimir = "Domingo";
			break;
			case 2: diaParaImprimir = "Lunes";
			break;
			case 3: diaParaImprimir = "Martes";
			break;
			case 4: diaParaImprimir = "Miercoles";
			break;
			case 5: diaParaImprimir = "Jueves";
			break;
			case 6: diaParaImprimir = "Viernes";
			break;
			case 7: diaParaImprimir = "Sabado";
			break;
			default: diaParaImprimir = "Ninguno";
			break;
		}
		return "Dia seleccionado: " + diaParaImprimir;
	}
}
