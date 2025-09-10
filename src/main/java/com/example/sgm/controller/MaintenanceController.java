package com.example.sgm.controller;

import com.example.sgm.model.Maintenance;
import com.example.sgm.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/maintenance")
@CrossOrigin(origins = "*") // Útil para desarrollo
public class MaintenanceController {

    private final MaintenanceService service;

    @Autowired // O constructor sin @Autowired
    public MaintenanceController(MaintenanceService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Maintenance> create(@RequestBody Maintenance m) {
        Maintenance createdMaintenance = service.create(m);
        return ResponseEntity.ok(createdMaintenance);
    }

    @GetMapping
    public ResponseEntity<List<Maintenance>> list() {
        List<Maintenance> maintenanceList = service.listAll();
        return ResponseEntity.ok(maintenanceList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> get(@PathVariable Long id) {
        Maintenance maintenance = service.findById(id);
        return ResponseEntity.ok(maintenance);
    }

    // Método PUT para actualizar completamente un mantenimiento
    @PutMapping("/{id}")
    public ResponseEntity<Maintenance> update(@PathVariable Long id, @RequestBody Maintenance m) {
        Maintenance updatedMaintenance = service.update(id, m);
        return ResponseEntity.ok(updatedMaintenance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        // 204 No Content es el código de estado adecuado
        return ResponseEntity.noContent().build();
    }
}