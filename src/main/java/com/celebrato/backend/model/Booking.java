package com.celebrato.backend.model;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    // Relation with User (client)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private User client;

    // Relation with Event
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    // Relation with Package
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id", nullable = false)
    private Package bookedPackage;

    @Column(name = "booking_date", nullable = false)
    private LocalDateTime bookingDate;

    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "total_cost", nullable = false)
    private Double totalCost;

    @Column(name = "status", nullable = false)
    private String status;

    // Default constructor
    public Booking() {}

    // Parameterized constructor
    public Booking(User client, Event event, Package bookedPackage,
                   LocalDateTime bookingDate, LocalDate eventDate,
                   String location, Double totalCost, String status) {
        this.client = client;
        this.event = event;
        this.bookedPackage = bookedPackage;
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

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Package getBookedPackage() {
        return bookedPackage;
    }

    public void setBookedPackage(Package bookedPackage) {
        this.bookedPackage = bookedPackage;
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
