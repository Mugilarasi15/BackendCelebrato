package com.celebrato.backend.repository;


import com.celebrato.backend.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<Package, Long> {
    List<Package> findByEvent_EventId(Long eventId);
}
