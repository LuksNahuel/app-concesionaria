package com.cda.concesionaria.services;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cda.concesionaria.model.Vehiculo;

@Service
public class ConcesionariaService {
	Map<String, Vehiculo> dB = DummyBase.getDummyBase();
	
	public void agregarVehiculo(Vehiculo vehiculo) {
		dB.put(vehiculo.getModelo(), vehiculo);
	}
	
	public ArrayList<Vehiculo> listaVehiculos() {
		ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>();
		dB.forEach((key, value) -> lista.add(value));
		return lista;
	}
	
	public ArrayList<Vehiculo> filtrarVehiculos(String modelo, Double precio) {
		ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>();
		dB.forEach((key, value) -> {
			if(key.equals(modelo) || value.getPrecio() <= precio) {
				lista.add(value);
			}
		});
		return lista;
	}
}
