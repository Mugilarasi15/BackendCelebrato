package com.celebrato.backend.config;

import com.celebrato.backend.model.Event;
import com.celebrato.backend.model.Package;
import com.celebrato.backend.repository.EventRepository;
import com.celebrato.backend.repository.PackageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(EventRepository eventRepository, PackageRepository packageRepository) {
        return args -> {

            // ✅ 1. Preload Events (if not exist)
            List<String> defaultEvents = Arrays.asList(
                    "Wedding", "Birthday", "Anniversary", "Engagement", "Housewarming",
                    "Baby Shower", "Naming Ceremony", "Business Meeting", "Conference",
                    "Product Launch", "Annual Gathering", "Networking Event",
                    "Team Building", "Award Ceremony"
            );

            for (String eventName : defaultEvents) {
                eventRepository.findByName(eventName).orElseGet(() -> {
                    Event e = new Event();
                    e.setName(eventName);
                    e.setDescription(eventName + " event description");
                    return eventRepository.save(e);
                });
            }

            // ✅ 2. Preload Packages for specific events
            Event wedding = eventRepository.findByName("Wedding").orElse(null);
            Event birthday = eventRepository.findByName("Birthday").orElse(null);
            Event conference = eventRepository.findByName("Conference").orElse(null);

            // 💍 Wedding Packages
            if (wedding != null && packageRepository.findByEvent_EventId(wedding.getEventId()).isEmpty()) {
                packageRepository.saveAll(Arrays.asList(
                        new Package(wedding, "Royal Affair", "A grand celebration with luxurious setup and premium catering.", 250000.00),
                        new Package(wedding, "Golden Glow", "Elegant decor and delicious buffet for intimate weddings.", 150000.00),
                        new Package(wedding, "Classic Bliss", "Traditional wedding package with essential services.", 100000.00)
                ));
            }

            // 🎂 Birthday Packages
            if (birthday != null && packageRepository.findByEvent_EventId(birthday.getEventId()).isEmpty()) {
                packageRepository.saveAll(Arrays.asList(
                        new Package(birthday, "Sparkle Bash", "Fun-filled birthday with balloons, cake, and DJ.", 25000.00),
                        new Package(birthday, "Starry Night", "Decorative theme with music and dinner.", 40000.00),
                        new Package(birthday, "Mini Fiesta", "Budget-friendly birthday package.", 15000.00)
                ));
            }

            // 🏢 Conference Packages
            if (conference != null && packageRepository.findByEvent_EventId(conference.getEventId()).isEmpty()) {
                packageRepository.saveAll(Arrays.asList(
                        new Package(conference, "Executive Meet", "Conference hall setup with refreshments.", 50000.00),
                        new Package(conference, "Pro Summit", "Includes sound system, projectors, and stage setup.", 90000.00),
                        new Package(conference, "Corporate Elite", "Complete event handling for corporate conferences.", 120000.00)
                ));
            }

            System.out.println("✅ Default Events and Packages loaded successfully!");
        };
    }
}
