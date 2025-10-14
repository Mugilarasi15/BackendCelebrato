package com.celebrato.backend.service;


import com.celebrato.backend.model.Package;
import com.celebrato.backend.repository.PackageRepository;
import com.celebrato.backend.service.PackageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackageServiceImpl implements PackageService {

    private final PackageRepository packageRepository;

    public PackageServiceImpl(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    @Override
    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }

    @Override
    public Optional<Package> getPackageById(Long id) {
        return packageRepository.findById(id);
    }

    @Override
    public Package createPackage(Package pack) {
        return packageRepository.save(pack);
    }

    @Override
    public Optional<Package> updatePackage(Long id, Package updatedPackage) {
        return packageRepository.findById(id).map(existing -> {
            existing.setName(updatedPackage.getName());
            existing.setDescription(updatedPackage.getDescription());
            existing.setPrice(updatedPackage.getPrice());
            existing.setEvent(updatedPackage.getEvent());
            return packageRepository.save(existing);
        });
    }

    @Override
    public void deletePackage(Long id) {
        packageRepository.deleteById(id);
    }

    @Override
    public List<Package> getPackagesByEventId(Long eventId) {
        return packageRepository.findByEvent_EventId(eventId);
    }
}
