package com.example.webcty.entities.contactPage;

import com.example.webcty.entities.bases.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contact_banner")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactBanner extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String slogan;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String image;
}