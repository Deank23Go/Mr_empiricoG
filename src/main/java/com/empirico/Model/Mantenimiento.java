package com.empirico.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Mantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private LocalDate fecha;

    @ManyToOne
    private Equipo equipo;

    public Mantenimiento() {}

    public Mantenimiento(String descripcion, LocalDate fecha, Equipo equipo) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.equipo = equipo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Equipo getEquipo() { return equipo; }
    public void setEquipo(Equipo equipo) { this.equipo = equipo; }
}
