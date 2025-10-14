package com.celebrato.backend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "packages")
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long packageId;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event; // Each package belongs to one event

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double price;

    // Constructors
    public Package() {}

    public Package(Event event, String name, String description, Double price) {
        this.event = event;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Getters and Setters
    public Long getPackageId() { return packageId; }
    public void setPackageId(Long packageId) { this.packageId = packageId; }

    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}
