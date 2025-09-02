package com.empirico;

import com.empirico.Model.Equipo;
import com.empirico.Model.Mantenimiento;
import com.empirico.repository.EquipoRepository;
import com.empirico.repository.MantenimientoRepository;
import com.empirico.API.EquipoResource;
import com.empirico.API.MantenimientoResource;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EquipoRepository equipoRepo = new EquipoRepository();
        MantenimientoRepository mantenimientoRepo = new MantenimientoRepository();

        // Datos iniciales
        equipoRepo.save(new Equipo("Compresor", "Equipo principal"));
        equipoRepo.save(new Equipo("Motor", "Motor secundario"));

        mantenimientoRepo.save(new Mantenimiento("Revisión general", "Revisión completa", LocalDate.of(2025,9,2)));
        mantenimientoRepo.save(new Mantenimiento("Cambio de aceite", "Aceite del motor", LocalDate.of(2025,9,3)));

        // Configurar recursos
        ResourceConfig config = new ResourceConfig();
        config.register(new EquipoResource(equipoRepo));
        config.register(new MantenimientoResource(mantenimientoRepo));

        // Arrancar servidor
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create("http://localhost:8080/api/"), config);
        System.out.println("Servidor arrancado en http://localhost:8080/api/");
        System.out.println("Presiona ENTER para detener el servidor...");

        try { System.in.read(); } catch (Exception e) { e.printStackTrace(); }
        server.shutdownNow();
    }
}
