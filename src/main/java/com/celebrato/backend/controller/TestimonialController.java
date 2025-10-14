package com.celebrato.backend.controller;


import com.celebrato.backend.dto.TestimonialDTO;
import com.celebrato.backend.service.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testimonials")
@CrossOrigin(origins = "*")
public class TestimonialController {

    @Autowired
    private TestimonialService testimonialService;

    // POST - create testimonial
    @PostMapping
    public ResponseEntity<TestimonialDTO> createTestimonial(@RequestBody TestimonialDTO dto) {
        return ResponseEntity.ok(testimonialService.createTestimonial(dto));
    }

    // GET - all testimonials
    @GetMapping
    public ResponseEntity<List<TestimonialDTO>> getAllTestimonials() {
        return ResponseEntity.ok(testimonialService.getAllTestimonials());
    }

    // GET - testimonial by ID
    @GetMapping("/{id}")
    public ResponseEntity<TestimonialDTO> getTestimonialById(@PathVariable Long id) {
        return ResponseEntity.ok(testimonialService.getTestimonialById(id));
    }

    // DELETE - remove testimonial
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestimonial(@PathVariable Long id) {
        testimonialService.deleteTestimonial(id);
        return ResponseEntity.noContent().build();
    }
}
