package com.example.sgm.repository;

import com.example.sgm.model.MaintenanceTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceTaskRepository extends JpaRepository<MaintenanceTask, Long> {
}
