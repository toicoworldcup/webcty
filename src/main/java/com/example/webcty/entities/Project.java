package com.example.webcty.entities;

import com.example.webcty.entities.bases.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "projects")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Project extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String image;

    @ElementCollection
    @CollectionTable(
            name = "project_tags",
            joinColumns = @JoinColumn(name = "project_id")
    )
    @Column(name = "tags", nullable = false)
    private List<String> tags;
}