package com.empirico.API;

import com.empirico.Model.Equipo;
import com.empirico.repository.EquipoRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/equipos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EquipoResource {
    private EquipoRepository repo;

    public EquipoResource(EquipoRepository repo) { this.repo = repo; }

    @GET
    public List<Equipo> getAll() { return repo.findAll(); }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        Equipo e = repo.findById(id);
        if (e == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(e).build();
    }

    @POST
    public Response create(Equipo e) {
        repo.save(e);
        return Response.status(Response.Status.CREATED).entity(e).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Equipo e) {
        Equipo existing = repo.findById(id);
        if (existing == null) return Response.status(Response.Status.NOT_FOUND).build();
        existing.setNombre(e.getNombre());
        existing.setDescripcion(e.getDescripcion());
        repo.update(existing);
        return Response.ok(existing).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Equipo existing = repo.findById(id);
        if (existing == null) return Response.status(Response.Status.NOT_FOUND).build();
        repo.delete(id);
        return Response.noContent().build();
    }
}
