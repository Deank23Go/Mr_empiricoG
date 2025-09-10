package com.example.sgm.service;

import com.example.sgm.model.Equipment;
import java.util.List;

// Interfaz del servicio
public interface EquipmentService {
    Equipment create(Equipment e);
    List<Equipment> listAll();
    Equipment findById(Long id);
    Equipment update(Long id, Equipment equipmentDetails); // Método añadido
    void delete(Long id);
}