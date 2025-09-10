package com.example.sgm.service.impl;

import com.example.sgm.model.Technician;
import com.example.sgm.repository.TechnicianRepository;
import com.example.sgm.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicianServiceImpl implements TechnicianService {

    @Autowired
    private TechnicianRepository technicianRepository;

    @Override
    public Technician create(Technician technician) {
        return technicianRepository.save(technician);
    }

    @Override
    public List<Technician> listAll() {
        return technicianRepository.findAll();
    }

    @Override
    public Technician findById(Long id) {
        Optional<Technician> technician = technicianRepository.findById(id);
        if (technician.isPresent()) {
            return technician.get();
        } else {
            throw new RuntimeException("Técnico no encontrado con id: " + id);
        }
    }

    @Override
    public Technician update(Long id, Technician technicianDetails) {
        Technician technician = this.findById(id);
        technician.setFirstName(technicianDetails.getFirstName());
        technician.setLastName(technicianDetails.getLastName());
        technician.setEmail(technicianDetails.getEmail());
        technician.setPhone(technicianDetails.getPhone());
        return technicianRepository.save(technician);
    }

    @Override
    public void delete(Long id) {
        if (technicianRepository.existsById(id)) {
            technicianRepository.deleteById(id);
        } else {
            throw new RuntimeException("Técnico no encontrado con id: " + id);
        }
    }
}