package com.example.webcty.entities.projectPage;

import com.example.webcty.entities.bases.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "project_component")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectComponent extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String title;

    @Column(columnDefinition = "MEDIUMTEXT", nullable = false)
    private String description;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String image;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String content;
}