package com.example.sgm.controller;

import com.example.sgm.model.Equipment;
import com.example.sgm.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/equipment")
@CrossOrigin(origins = "*") // Útil para desarrollo
public class EquipmentController {

    private final EquipmentService service;

    // Inyección de dependencias por constructor
    @Autowired // O puedes usar constructor sin @Autowired en versiones recientes de Spring
    public EquipmentController(EquipmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Equipment> create(@RequestBody Equipment e) {
        Equipment createdEquipment = service.create(e);
        return ResponseEntity.ok(createdEquipment);
    }

    @GetMapping
    public ResponseEntity<List<Equipment>> list() {
        List<Equipment> equipmentList = service.listAll();
        return ResponseEntity.ok(equipmentList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipment> get(@PathVariable Long id) {
        Equipment equipment = service.findById(id);
        return ResponseEntity.ok(equipment);
    }

    // Método PUT para actualizar completamente un equipo
    @PutMapping("/{id}")
    public ResponseEntity<Equipment> update(@PathVariable Long id, @RequestBody Equipment e) {
        Equipment updatedEquipment = service.update(id, e);
        return ResponseEntity.ok(updatedEquipment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        // 204 No Content es el código de estado adecuado para una eliminación exitosa
        return ResponseEntity.noContent().build();
    }
}