package com.celebrato.backend.dto;


import java.time.LocalDateTime;

public class TestimonialDTO {
    private Long testimonialId;
    private Long clientId;
    private String clientName; // optional, can fetch from User
    private String message;
    private int rating;
    private LocalDateTime createdAt;

    // Getters and Setters
    public Long getTestimonialId() { return testimonialId; }
    public void setTestimonialId(Long testimonialId) { this.testimonialId = testimonialId; }

    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }

    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
