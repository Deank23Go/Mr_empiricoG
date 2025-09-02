package com.empirico.API;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/")
public class RootResource {
    @GET
    public String hello() {
        return "API de Gestión de Mantenimiento funcionando 🚀";
    }
}
