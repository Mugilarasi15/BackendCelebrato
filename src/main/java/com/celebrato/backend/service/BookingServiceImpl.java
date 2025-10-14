package com.celebrato.backend.service;


import com.celebrato.backend.dto.BookingDTO;
import com.celebrato.backend.model.Booking;
import com.celebrato.backend.model.Event;
import com.celebrato.backend.model.Package;
import com.celebrato.backend.model.User;
import com.celebrato.backend.repository.BookingRepository;
import com.celebrato.backend.repository.EventRepository;
import com.celebrato.backend.repository.PackageRepository;
import com.celebrato.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private PackageRepository packageRepository;

    @Override
    public BookingDTO createBooking(BookingDTO dto) {
        User client = userRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + dto.getClientId()));

        Event event = eventRepository.findById(dto.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found with ID: " + dto.getEventId()));

        Package pkg = packageRepository.findById(dto.getPackageId())
                .orElseThrow(() -> new RuntimeException("Package not found with ID: " + dto.getPackageId()));

        Booking booking = new Booking();
        booking.setClient(client);
        booking.setEvent(event);
        booking.setBookedPackage(pkg);
        booking.setBookingDate(dto.getBookingDate());
        booking.setEventDate(dto.getEventDate());
        booking.setLocation(dto.getLocation());
        booking.setTotalCost(dto.getTotalCost());
        booking.setStatus(dto.getStatus());

        bookingRepository.save(booking);

        dto.setBookingId(booking.getBookingId());
        return dto;
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookingDTO getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + id));
        return convertToDTO(booking);
    }

    @Override
    public BookingDTO updateBooking(Long id, BookingDTO dto) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + id));

        User client = userRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + dto.getClientId()));

        Event event = eventRepository.findById(dto.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found with ID: " + dto.getEventId()));

        Package pkg = packageRepository.findById(dto.getPackageId())
                .orElseThrow(() -> new RuntimeException("Package not found with ID: " + dto.getPackageId()));

        booking.setClient(client);
        booking.setEvent(event);
        booking.setBookedPackage(pkg);
        booking.setBookingDate(dto.getBookingDate());
        booking.setEventDate(dto.getEventDate());
        booking.setLocation(dto.getLocation());
        booking.setTotalCost(dto.getTotalCost());
        booking.setStatus(dto.getStatus());

        bookingRepository.save(booking);
        return convertToDTO(booking);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + id));
        bookingRepository.deleteById(id);
    }

    private BookingDTO convertToDTO(Booking booking) {
        return new BookingDTO(
                booking.getBookingId(),
                booking.getClient().getId(),           // <-- replace with actual getter of User ID
                booking.getEvent().getEventId(),
                booking.getBookedPackage().getPackageId(),
                booking.getBookingDate(),
                booking.getEventDate(),
                booking.getLocation(),
                booking.getTotalCost(),
                booking.getStatus()
        );
    }
}
