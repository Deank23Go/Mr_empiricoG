package com.empirico.Model;

import java.time.LocalDate;

public class Mantenimiento {
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fecha;

    public Mantenimiento() {}

    public Mantenimiento(String nombre, String descripcion, LocalDate fecha) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}
