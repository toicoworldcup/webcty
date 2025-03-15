package com.example.webcty.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

import com.example.webcty.enums.MediaType;

@Entity
@Getter
@Setter
@Table(name = "media_files")
public class MediaFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MediaType entityType;

    @Column(nullable = false)
    private Long entityId;

    @Column(nullable = false, length = 255)
    private String url;

    private String fileName;
    private String filePath;
    private String fileType;
    private Integer fileSize;

    @Column(updatable = false)
    private LocalDateTime uploadedAt;

    @PrePersist
    protected void onCreate() {
        this.uploadedAt = LocalDateTime.now();
    }


    private Long uploadedBy;
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = true) // Cột khóa ngoại trong DB
    private CompanyInfo company;
    @ManyToOne
    @JoinColumn(name = "aboutus_id", nullable = true)
    private AboutUs aboutUs; // 👈 Trùng với mappedBy trong AboutUs
    @ManyToOne
    @JoinColumn(name = "companyhistory_id", nullable = true)
    private CompanyHistory companyHistory; // 👈 Trùng với mappedBy trong AboutUs
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = true)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "member_id", nullable = true)
    private Member member;
    @ManyToOne
    @JoinColumn(name = "news_id", nullable = true)
    private News news;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = true)
    private Product product;


//    @ManyToOne
//    @JoinColumn(name = "product_id", nullable = true)
//    private Product product;

//    @ManyToOne
//    @JoinColumn(name = "news_id", nullable = true)
//    private News news;
}
