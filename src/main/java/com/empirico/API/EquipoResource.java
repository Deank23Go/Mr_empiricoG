package com.empirico.API;

import com.empirico.Model.Equipo;
import com.empirico.repository.EquipoRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/equipos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EquipoResource {
    private EquipoRepository repository = new EquipoRepository();

    @GET
    public List<Equipo> getAllEquipos() {
        return repository.findAll();
    }

    @POST
    public Equipo addEquipo(Equipo equipo) {
        return repository.save(equipo);
    }
}
