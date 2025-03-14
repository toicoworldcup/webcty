package com.example.webcty.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer_contacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String name; // Tên người liên hệ

    @Column(nullable = false, length = 255)
    private String email; // Email

    @Column(nullable = false, length = 20)
    private String phone; // Số điện thoại

    @Column(columnDefinition = "TEXT", nullable = false)
    private String message; // Nội dung liên hệ

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private ContactStatus status = ContactStatus.NEW; // Trạng thái (NEW, REPLIED, CLOSED)

    @Column(updatable = false)
    private LocalDateTime createdAt; // Ngày tạo

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public enum ContactStatus {
        NEW, REPLIED, CLOSED
    }
}
