package com.empirico.API;

import com.empirico.Model.Mantenimiento;
import com.empirico.repository.MantenimientoRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/mantenimientos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MantenimientoResource {
    private MantenimientoRepository repo;

    public MantenimientoResource(MantenimientoRepository repo) { this.repo = repo; }

    @GET
    public List<Mantenimiento> getAll() { return repo.findAll(); }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        Mantenimiento m = repo.findById(id);
        if (m == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(m).build();
    }

    @POST
    public Response create(Mantenimiento m) {
        repo.save(m);
        return Response.status(Response.Status.CREATED).entity(m).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Mantenimiento m) {
        Mantenimiento existing = repo.findById(id);
        if (existing == null) return Response.status(Response.Status.NOT_FOUND).build();
        existing.setNombre(m.getNombre());
        existing.setDescripcion(m.getDescripcion());
        existing.setFecha(m.getFecha());
        repo.update(existing);
        return Response.ok(existing).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Mantenimiento existing = repo.findById(id);
        if (existing == null) return Response.status(Response.Status.NOT_FOUND).build();
        repo.delete(id);
        return Response.noContent().build();
    }
}
