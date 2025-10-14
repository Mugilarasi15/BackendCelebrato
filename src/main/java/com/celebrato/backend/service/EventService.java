package com.celebrato.backend.service;


import com.celebrato.backend.model.Event;
import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> getAllEvents();
    Optional<Event> getEventById(Long id);
    Event createEvent(Event event);
    Optional<Event> updateEvent(Long id, Event eventDetails);
    void deleteEvent(Long id);
}

