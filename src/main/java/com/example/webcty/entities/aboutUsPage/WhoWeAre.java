package com.example.webcty.entities.aboutUsPage;

import com.example.webcty.entities.bases.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "who_we_are")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WhoWeAre extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String title;

    @Column(columnDefinition = "MEDIUMTEXT", nullable = false)
    private String description;

    @ElementCollection
    @CollectionTable(
            name = "who_we_are_content",
            joinColumns = @JoinColumn(name = "who_we_are_id")
    )
    @Column(name = "content", nullable = false)
    @Lob
    private List<String> content;
}