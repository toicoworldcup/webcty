package com.example.webcty.entities;

import com.example.webcty.entities.bases.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "banners")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Banner extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @ElementCollection
    @CollectionTable(
            name = "banner_images",
            joinColumns = @JoinColumn(name = "banner_id")
    )
    private List<String> imageUrls;
}