package com.example.sgm.repository;

import com.example.sgm.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TechnicianRepository extends JpaRepository<Technician, Long> {
    Optional<Technician> findByEmail(String email);
}