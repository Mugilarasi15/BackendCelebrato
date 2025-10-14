package com.celebrato.backend.service;


import com.celebrato.backend.dto.BookingDTO;
import java.util.List;

public interface BookingService {
    BookingDTO createBooking(BookingDTO bookingDTO);
    List<BookingDTO> getAllBookings();
    BookingDTO getBookingById(Long id);
    BookingDTO updateBooking(Long id, BookingDTO bookingDTO);
    void deleteBooking(Long id);
}
