package com.celebrato.backend.service;


import com.celebrato.backend.model.Event;
import com.celebrato.backend.repository.EventRepository;
import com.celebrato.backend.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Optional<Event> updateEvent(Long id, Event eventDetails) {
        return eventRepository.findById(id).map(existingEvent -> {
            existingEvent.setName(eventDetails.getName());
            existingEvent.setDescription(eventDetails.getDescription());
            return eventRepository.save(existingEvent);
        });
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
