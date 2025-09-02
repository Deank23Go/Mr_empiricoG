package com.empirico.Config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

public class MantenimientoApplication extends ResourceConfig {
    public MantenimientoApplication() {
        packages("com.empirico.API");  // Tus recursos
        register(JacksonFeature.class); // Habilita JSON
    }
}
