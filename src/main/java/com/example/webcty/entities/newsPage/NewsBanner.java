package com.example.webcty.entities.newsPage;

import com.example.webcty.entities.bases.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "news_banner")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NewsBanner extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String slogan;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String image;
}