package com.example.sgm.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "technician")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Technician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;
}
