package com.example.webcty.entities;

import com.example.webcty.entities.bases.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "company_managers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CompanyManager extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private String description;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String image;

    private int orderIndex;
}