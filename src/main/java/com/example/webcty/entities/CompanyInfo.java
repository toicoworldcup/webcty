package com.example.webcty.entities;

import com.example.webcty.entities.bases.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "company_info")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CompanyInfo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String siteName;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String siteDescription;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String icon;

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private String contactEmail;

    @Column(nullable = false)
    private String contactPhone;

    @Column(nullable = false)
    private String contactAddress;

    @Column(nullable = false)
    private String workingHours;

    @Column(nullable = false)
    private String mapUrl;
}