package com.cda.concesionaria.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.cda.concesionaria.model.Vehiculo;

@Service
public class VehiculosRowMapper implements RowMapper<Vehiculo>{

	@Override
    public Vehiculo mapRow(ResultSet resultSet, int i) throws SQLException {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setMarca(resultSet.getString("marca"));
        vehiculo.setModelo(resultSet.getString("modelo"));
        vehiculo.setPrecio(resultSet.getDouble("precio"));
        return vehiculo;
    }
}
