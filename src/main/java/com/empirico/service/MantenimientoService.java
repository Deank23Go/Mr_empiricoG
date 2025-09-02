package com.empirico.service;

import com.empirico.Model.Mantenimiento;
import com.empirico.repository.MantenimientoRepository;
import com.empirico.Model.Equipo;

import java.util.List;

public class MantenimientoService {

    private MantenimientoRepository repository;

    public MantenimientoService(MantenimientoRepository repository) {
        this.repository = repository;
    }

    /**
     * Crea un nuevo mantenimiento y lo retorna.
     * @param mantenimiento Objeto Mantenimiento a guardar.
     * @return El mantenimiento guardado con su id asignado.
     */
    public Mantenimiento crearMantenimiento(Mantenimiento mantenimiento) {
        repository.save(mantenimiento); // save es void
        return mantenimiento; // retornamos el objeto ya guardado
    }

    /**
     * Actualiza un mantenimiento existente.
     * @param mantenimiento Objeto Mantenimiento actualizado.
     * @return El mantenimiento actualizado, o null si no existe.
     */
    public Mantenimiento actualizarMantenimiento(Mantenimiento mantenimiento) {
        Mantenimiento existente = repository.findById(mantenimiento.getId());
        if (existente == null) {
            return null;
        }
        existente.setDescripcion(mantenimiento.getDescripcion());
        // Si quieres vincular un equipo, primero asegúrate que Mantenimiento tenga atributo Equipo
        if (mantenimiento.getClass().getDeclaredFields().length > 3) { // ejemplo simple
            try {
                Equipo equipo = (Equipo) mantenimiento.getClass().getMethod("getEquipo").invoke(mantenimiento);
                existente.getClass().getMethod("setEquipo", Equipo.class).invoke(existente, equipo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        repository.update(existente);
        return existente;
    }

    /**
     * Obtiene un mantenimiento por id.
     * @param id ID del mantenimiento.
     * @return El mantenimiento encontrado, o null si no existe.
     */
    public Mantenimiento obtenerMantenimiento(Long id) {
        return repository.findById(id);
    }

    /**
     * Elimina un mantenimiento por id.
     * @param id ID del mantenimiento a eliminar.
     */
    public void eliminarMantenimiento(Long id) {
        repository.delete(id);
    }

    /**
     * Retorna todos los mantenimientos.
     * @return Lista de mantenimientos.
     */
    public List<Mantenimiento> obtenerTodos() {
        return repository.findAll();
    }
}
