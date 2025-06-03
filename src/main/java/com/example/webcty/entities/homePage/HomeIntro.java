package com.example.webcty.entities.homePage;

import com.example.webcty.entities.bases.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "home_intro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HomeIntro extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String title;

    @Column(columnDefinition = "MEDIUMTEXT", nullable = false)
    private String description;

    @Column(columnDefinition = "MEDIUMTEXT", nullable = false)
    private String content;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String image;
}