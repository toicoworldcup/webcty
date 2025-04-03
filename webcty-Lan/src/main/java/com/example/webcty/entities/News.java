package com.example.webcty.entities;

import com.example.webcty.entities.bases.BaseEntity;
import com.example.webcty.utils.SlugUtil;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "news")
@NoArgsConstructor
@AllArgsConstructor
public class News extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(unique = true, nullable = false, length = 255)
    private String slug;

    @PrePersist
    @PreUpdate
    public void generateSlug() {
        if (title != null && !title.isEmpty()) {
            this.slug = SlugUtil.generateSlug(title);
        }
    }

    @PostPersist
    @PostUpdate
    public void updateSlugWithId() {
        if (this.slug != null && !this.slug.endsWith("-" + this.id)) {
            this.slug = this.slug + "-" + this.id;
        }
    }

    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }
}