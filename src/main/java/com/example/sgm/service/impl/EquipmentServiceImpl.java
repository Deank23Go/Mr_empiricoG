package com.example.sgm.service.impl;

import com.example.sgm.model.Equipment;
import com.example.sgm.repository.EquipmentRepository;
import com.example.sgm.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    public Equipment create(Equipment e) {
        // Puedes añadir lógica adicional aquí, como establecer fechas createdAt/updatedAt
        return equipmentRepository.save(e);
    }

    @Override
    public List<Equipment> listAll() {
        return equipmentRepository.findAll();
    }

    @Override
    public Equipment findById(Long id) {
        // Es mejor manejar el Optional para evitar NoSuchElementException
        Optional<Equipment> equipment = equipmentRepository.findById(id);
        if (equipment.isPresent()) {
            return equipment.get();
        } else {
            // Lanza una excepción más específica o maneja el caso de no encontrado
            throw new RuntimeException("Equipo no encontrado con id: " + id);
        }
    }

    @Override
    public Equipment update(Long id, Equipment equipmentDetails) {
        Equipment equipment = this.findById(id); // Reutiliza la lógica de findById
        // Actualiza los campos necesarios
        equipment.setCode(equipmentDetails.getCode());
        equipment.setName(equipmentDetails.getName());
        equipment.setSerialNumber(equipmentDetails.getSerialNumber());
        equipment.setLocation(equipmentDetails.getLocation());
        equipment.setType(equipmentDetails.getType());
        equipment.setStatus(equipmentDetails.getStatus());
        // Nota: createdAt y updatedAt normalmente se gestionan con listeners de JPA
        // o en la capa de servicio. Aquí los actualizamos manualmente.
        // equipment.setUpdatedAt(OffsetDateTime.now()); // Si decides hacerlo aquí

        return equipmentRepository.save(equipment);
    }

    @Override
    public void delete(Long id) {
        // Opcional: verificar si existe antes de eliminar
        if (equipmentRepository.existsById(id)) {
            equipmentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Equipo no encontrado con id: " + id);
        }
    }
}