package com.example.sgm.service;

import com.example.sgm.model.Technician;
import java.util.List;

public interface TechnicianService {
    Technician create(Technician technician);
    List<Technician> listAll();
    Technician findById(Long id);
    Technician update(Long id, Technician technicianDetails);
    void delete(Long id);
}