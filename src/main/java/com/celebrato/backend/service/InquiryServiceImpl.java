package com.celebrato.backend.service;


import com.celebrato.backend.model.Inquiry;
import com.celebrato.backend.repository.InquiryRepository;
import com.celebrato.backend.service.InquiryService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InquiryServiceImpl implements InquiryService {

    private final InquiryRepository inquiryRepository;

    public InquiryServiceImpl(InquiryRepository inquiryRepository) {
        this.inquiryRepository = inquiryRepository;
    }

    @Override
    public Inquiry saveInquiry(Inquiry inquiry) {
        return inquiryRepository.save(inquiry);
    }

    @Override
    public List<Inquiry> getAllInquiries() {
        return inquiryRepository.findAll();
    }

    @Override
    public Inquiry getInquiryById(Long id) {
        return inquiryRepository.findById(id).orElse(null);
    }
}

