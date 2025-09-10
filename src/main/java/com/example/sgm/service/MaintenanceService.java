package com.example.sgm.service;

import com.example.sgm.model.Maintenance;
import java.util.List;

// Interfaz del servicio
public interface MaintenanceService {
    Maintenance create(Maintenance m);
    List<Maintenance> listAll();
    Maintenance findById(Long id);
    Maintenance update(Long id, Maintenance maintenanceDetails); // Método añadido
    void delete(Long id);
}