package com.celebrato.backend.service;


import com.celebrato.backend.dto.TestimonialDTO;
import com.celebrato.backend.model.Testimonial;
import com.celebrato.backend.model.User;
import com.celebrato.backend.repository.TestimonialRepository;
import com.celebrato.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestimonialServiceImpl implements TestimonialService {

    @Autowired
    private TestimonialRepository testimonialRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public TestimonialDTO createTestimonial(TestimonialDTO dto) {
        User client = userRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + dto.getClientId()));

        Testimonial testimonial = new Testimonial();
        testimonial.setClient(client);
        testimonial.setMessage(dto.getMessage());
        testimonial.setRating(dto.getRating());
        testimonial.setCreatedAt(LocalDateTime.now());

        testimonialRepository.save(testimonial);

        dto.setTestimonialId(testimonial.getTestimonialId());
        dto.setCreatedAt(testimonial.getCreatedAt());
        dto.setClientName(client.getName()); // optional
        return dto;
    }

    @Override
    public List<TestimonialDTO> getAllTestimonials() {
        return testimonialRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TestimonialDTO getTestimonialById(Long id) {
        Testimonial testimonial = testimonialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Testimonial not found with ID: " + id));
        return convertToDTO(testimonial);
    }

    @Override
    public void deleteTestimonial(Long id) {
        testimonialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Testimonial not found with ID: " + id));
        testimonialRepository.deleteById(id);
    }

    private TestimonialDTO convertToDTO(Testimonial testimonial) {
        TestimonialDTO dto = new TestimonialDTO();
        dto.setTestimonialId(testimonial.getTestimonialId());
        dto.setClientId(testimonial.getClient().getId()); // adjust getter if needed
        dto.setClientName(testimonial.getClient().getName());
        dto.setMessage(testimonial.getMessage());
        dto.setRating(testimonial.getRating());
        dto.setCreatedAt(testimonial.getCreatedAt());
        return dto;
    }
}
