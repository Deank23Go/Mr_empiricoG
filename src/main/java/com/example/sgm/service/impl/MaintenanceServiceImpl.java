package com.example.sgm.service.impl;

import com.example.sgm.model.Maintenance;
import com.example.sgm.repository.MaintenanceRepository;
import com.example.sgm.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance create(Maintenance m) {
        // Puedes añadir lógica adicional aquí, como establecer fechas createdAt/updatedAt
        return maintenanceRepository.save(m);
    }

    @Override
    public List<Maintenance> listAll() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance findById(Long id) {
        Optional<Maintenance> maintenance = maintenanceRepository.findById(id);
        if (maintenance.isPresent()) {
            return maintenance.get();
        } else {
            throw new RuntimeException("Mantenimiento no encontrado con id: " + id);
        }
    }

    @Override
    public Maintenance update(Long id, Maintenance maintenanceDetails) {
        Maintenance maintenance = this.findById(id);
        // Actualiza los campos necesarios
        maintenance.setEquipment(maintenanceDetails.getEquipment());
        maintenance.setType(maintenanceDetails.getType());
        maintenance.setScheduledDate(maintenanceDetails.getScheduledDate());
        maintenance.setPerformedDate(maintenanceDetails.getPerformedDate());
        maintenance.setStatus(maintenanceDetails.getStatus());
        maintenance.setDescription(maintenanceDetails.getDescription());
        maintenance.setTechnician(maintenanceDetails.getTechnician());
        maintenance.setCost(maintenanceDetails.getCost());
        // Nota: createdAt y updatedAt normalmente se gestionan con listeners de JPA
        // o en la capa de servicio.

        return maintenanceRepository.save(maintenance);
    }

    @Override
    public void delete(Long id) {
        if (maintenanceRepository.existsById(id)) {
            maintenanceRepository.deleteById(id);
        } else {
            throw new RuntimeException("Mantenimiento no encontrado con id: " + id);
        }
    }
}