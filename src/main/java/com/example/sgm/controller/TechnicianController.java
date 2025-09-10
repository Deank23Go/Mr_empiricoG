package com.example.sgm.controller;

import com.example.sgm.model.Technician;
import com.example.sgm.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/technicians")
@CrossOrigin(origins = "*")
public class TechnicianController {

    private final TechnicianService service;

    @Autowired
    public TechnicianController(TechnicianService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Technician> create(@RequestBody Technician technician) {
        Technician createdTechnician = service.create(technician);
        return ResponseEntity.ok(createdTechnician);
    }

    @GetMapping
    public ResponseEntity<List<Technician>> list() {
        List<Technician> technicianList = service.listAll();
        return ResponseEntity.ok(technicianList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Technician> get(@PathVariable Long id) {
        Technician technician = service.findById(id);
        return ResponseEntity.ok(technician);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Technician> update(@PathVariable Long id, @RequestBody Technician technician) {
        Technician updatedTechnician = service.update(id, technician);
        return ResponseEntity.ok(updatedTechnician);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}