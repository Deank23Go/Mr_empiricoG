package com.example.sgm.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "equipment_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;
}