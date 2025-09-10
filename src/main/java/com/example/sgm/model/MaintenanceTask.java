package com.example.sgm.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "maintenance_task")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaintenanceTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maintenance_id")
    private Maintenance maintenance;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "done")
    private boolean done;
}
