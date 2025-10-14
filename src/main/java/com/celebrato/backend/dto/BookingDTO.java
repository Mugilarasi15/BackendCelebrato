package com.celebrato.backend.dto;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingDTO {

    private Long bookingId;
    private Long clientId;
    private Long eventId;
    private Long packageId;
    private LocalDateTime bookingDate;
    private LocalDate eventDate;
    private String location;
    private Double totalCost;
    private String status;

    public BookingDTO() {}

    public BookingDTO(Long bookingId, Long clientId, Long eventId, Long packageId,
                      LocalDateTime bookingDate, LocalDate eventDate,
                      String location, Double totalCost, String status) {
        this.bookingId = bookingId;
        this.clientId = clientId;
        this.eventId = eventId;
        this.packageId = packageId;
        this.bookingDate = bookingDate;
        this.eventDate = eventDate;
        this.location = location;
        this.totalCost = totalCost;
        this.status = status;
    }

    // Getters and Setters
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
