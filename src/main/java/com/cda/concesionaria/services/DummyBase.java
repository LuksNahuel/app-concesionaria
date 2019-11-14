package com.cda.concesionaria.services;

import java.util.HashMap;
import java.util.Map;

import com.cda.concesionaria.model.Vehiculo;

public class DummyBase {
	
	private static Map<String,Vehiculo> map;
    
    static {
        map = new HashMap<String, Vehiculo>();
        map.put("Ka", new Vehiculo("Ford", "Ka", 350000));
    }
    
    public static Map<String,Vehiculo> getDummyBase() {
        return map;
    }
}
