package com.cda.concesionaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cda.concesionaria.model.Vehiculo;
import com.cda.concesionaria.services.ConcesionariaService;
import com.cda.concesionaria.services.ServiceApp;

@Controller
public class ConcesionariaController {
	
	@Autowired 
	ConcesionariaService service;
	
	@Autowired
	ServiceApp h2Service;
	
	@GetMapping("/")
    	public String mostrarVehiculos(Model model) {
        	model.addAttribute("listaVehiculos", h2Service.getVehiculos());
        	return "home";
    	}
	
	@GetMapping("/cargar-auto")
	public String vistaCargarVehiculo(Model model) {
		model.addAttribute("auto", new Vehiculo());
		return "cargar";
	}
	
	@PostMapping("/cargar-auto")
	public String cargarVehiculo(@ModelAttribute Vehiculo vehiculo) {
        h2Service.setVehiculo(vehiculo);
		//service.agregarVehiculo(vehiculo);
        return "redirect:/cargar-auto";
    	
	}
	
	@GetMapping("/buscar")
    	public String buscarVehiculo(Model model) {
        	model.addAttribute("busqueda", new Vehiculo());
        	return "buscar";
    	}
	
	@PostMapping("/resultado")
    	public String vehiculoBuscado(Model model, Vehiculo buscado) {
		model.addAttribute("resultado", h2Service.filtrarVehiculos(buscado.getModelo(), buscado.getPrecio()));
		return "resultado";
	}
	
}
