package com.empirico.API;

import com.empirico.Model.Mantenimiento;
import com.empirico.service.MantenimientoService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/mantenimientos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MantenimientoResource {
    private MantenimientoService service = new MantenimientoService();

    @GET
    public List<Mantenimiento> getAllMantenimientos() {
        return service.findAll();
    }

    @POST
    public Mantenimiento addMantenimiento(Mantenimiento mantenimiento) {
        return service.save(mantenimiento);
    }
}
