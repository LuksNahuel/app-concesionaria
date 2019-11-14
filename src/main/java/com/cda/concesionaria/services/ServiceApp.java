package com.cda.concesionaria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cda.concesionaria.mappers.VehiculosRowMapper;
import com.cda.concesionaria.model.Vehiculo;

@Service
public class ServiceApp {
	
	@Autowired
    JdbcTemplate jdbcTemplate;

    public List<Vehiculo> getVehiculos() {
    	String sql = "SELECT marca, modelo, precio FROM vehiculos";
    	List<Vehiculo> query = jdbcTemplate.query(sql, new VehiculosRowMapper());
    	//query.forEach(item->System.out.println(item.getModelo()));
    	return query;
    }
    
    public void setVehiculo(Vehiculo vehiculo) {
    	String consulta = "INSERT INTO vehiculos(marca, modelo, precio) VALUES ('%s', '%s', " + vehiculo.getPrecio() + ");";
    	jdbcTemplate.execute(String.format(consulta, vehiculo.getMarca(), vehiculo.getModelo()));
    }
    
    public List<Vehiculo> filtrarVehiculos(String modelo, Double precio) {
    	if(modelo.isEmpty() && precio == 0) {
    		return this.getVehiculos();
    	} else {
    		String where = "modelo = " + "'" + modelo + "' " + "OR " + "precio <= " + precio + ";";
        	String sql = "SELECT marca, modelo, precio FROM vehiculos WHERE " + where;
    		List<Vehiculo> query = jdbcTemplate.query(sql, new VehiculosRowMapper());
    		return query;
    	}
	}
}
