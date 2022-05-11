package com.ceiba.infraestructura.actuator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import com.ceiba.infraestructura.error.ErrorHealthCheck;

@Configuration
public class ManejadorHealthCheckBloques {

	private Map<String, Salud> bloquesRegistrados = new HashMap<>();
	private List<ErrorHealthCheck> listadoErroresBloques = new ArrayList<>();

	public void registrarme(String nombreBloque, Salud salud) {
		this.bloquesRegistrados.put(nombreBloque, salud);
	}



	public boolean existenErrores() {
		return !listadoErroresBloques.isEmpty();
	}

	public List<ErrorHealthCheck> getListadoErroresBloques() {
		return listadoErroresBloques;
	}

}
