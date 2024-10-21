package com.BRYANFront.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BRYANFront.Client.AlumnoClient;
import com.BRYANFront.Entidades.Alumno;

import feign.FeignException;

@Controller
public class AlumnoController {
	
	 // Cliente Feign para consumir el servicio de alumnos
	  private final AlumnoClient alumnoClient;

	  // Constructor que inyecta el AlumnoClient en el controlador
	    public AlumnoController(AlumnoClient alumnoClient) {
	        this.alumnoClient = alumnoClient;
	    }

	    // Maneja las solicitudes GET mosytrar la vista para la ruta "/buscar"
	    @GetMapping("/buscar")
	    public String index() {
	        return "busqueda";
	    }

	    // Maneja las solicitudes POST para la ruta "/buscar"
	    @PostMapping("/buscar")
	    public String buscarAlumno(@RequestParam String codigo, Model model) {
	        try {
	            Alumno alumno = alumnoClient.buscarAlumno(codigo);
	            if (alumno != null) {
	                model.addAttribute("alumno", alumno);
	                return "detalle";
	            } else {
	                model.addAttribute("mensaje", "No se encontraron resultados");
	                return "busqueda";
	            }
	        } catch (FeignException e) {
	            model.addAttribute("mensaje", "ESTE USURIO NO SE ENCUENTRA");
	            return "busqueda";
	        }
	    }
}
