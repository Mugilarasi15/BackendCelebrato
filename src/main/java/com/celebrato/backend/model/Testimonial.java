package com.celebrato.backend.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "testimonials")
public class Testimonial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testimonialId;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private User client;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String message;

    @Column(nullable = false)
    private int rating; // 1 to 5

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Getters and Setters
    public Long getTestimonialId() { return testimonialId; }
    public void setTestimonialId(Long testimonialId) { this.testimonialId = testimonialId; }

    public User getClient() { return client; }
    public void setClient(User client) { this.client = client; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
