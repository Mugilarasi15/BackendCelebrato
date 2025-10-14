package com.celebrato.backend.service;


import com.celebrato.backend.model.Package;

import java.util.List;
import java.util.Optional;

public interface PackageService {
    List<Package> getAllPackages();
    Optional<Package> getPackageById(Long id);
    Package createPackage(Package pack);
    Optional<Package> updatePackage(Long id, Package updatedPackage);
    void deletePackage(Long id);
    List<Package> getPackagesByEventId(Long eventId);
}
