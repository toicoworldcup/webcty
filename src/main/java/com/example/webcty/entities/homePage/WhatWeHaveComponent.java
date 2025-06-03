package com.example.webcty.entities.homePage;

import com.example.webcty.entities.bases.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "what_we_have_component")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WhatWeHaveComponent extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String title;

    @Column(columnDefinition = "MEDIUMTEXT", nullable = false)
    private String description;

    @Column(columnDefinition = "LONGTEXT", nullable = false )
    private String image;

    @ElementCollection
    @CollectionTable(
            name = "what_we_have_component_tags",
            joinColumns = @JoinColumn(name = "what_we_have_component_id")
    )
    @Column(name = "tags", nullable = false)
    private List<String> tags;
}