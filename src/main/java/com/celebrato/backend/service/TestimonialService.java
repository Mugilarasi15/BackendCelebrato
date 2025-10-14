package com.celebrato.backend.service;


import com.celebrato.backend.dto.TestimonialDTO;

import java.util.List;

public interface TestimonialService {

    TestimonialDTO createTestimonial(TestimonialDTO dto);

    List<TestimonialDTO> getAllTestimonials();

    TestimonialDTO getTestimonialById(Long id);

    void deleteTestimonial(Long id);
}
