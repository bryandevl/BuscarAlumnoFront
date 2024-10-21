package com.BRYANFront.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BRYANFront.Entidades.Alumno;

//Indica que esta interfaz es un cliente Feign para consumir servicios REST
@FeignClient(name = "alumno-service", url = "http://localhost:8081")
public interface AlumnoClient {
	 // Define un método que se vincula a la solicitud GET en el endpoint "/buscar"
	  @GetMapping("/buscar")
	// Este método recibe un parámetro "codigo" y devuelve un objeto Alumno
	    Alumno buscarAlumno(@RequestParam("codigo") String codigo);

}
