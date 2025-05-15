package com.example.webcty.entities;

import com.example.webcty.entities.bases.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "company_services")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CompanyService extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(columnDefinition = "LONGTEXT", nullable = false )
    private String image;

    @ElementCollection
    @CollectionTable(
            name = "company_services_tags",
            joinColumns = @JoinColumn(name = "company_services_id")
    )
    @Column(name = "tags", nullable = false)
    private List<String> tags;
}