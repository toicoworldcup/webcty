package com.example.webcty.entities.servicePage;

import com.example.webcty.entities.bases.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "service_banner")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ServiceBanner extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String slogan;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String image;
}