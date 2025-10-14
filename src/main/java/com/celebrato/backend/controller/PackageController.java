package com.celebrato.backend.controller;


import com.celebrato.backend.model.Package;
import com.celebrato.backend.service.PackageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
public class PackageController {

    private final PackageService packageService;

    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping
    public List<Package> getAllPackages() {
        return packageService.getAllPackages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Package> getPackageById(@PathVariable Long id) {
        return packageService.getPackageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Package createPackage(@RequestBody Package pack) {
        return packageService.createPackage(pack);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Package> updatePackage(@PathVariable Long id, @RequestBody Package pack) {
        return packageService.updatePackage(id, pack)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackage(@PathVariable Long id) {
        packageService.deletePackage(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/event/{eventId}")
    public List<Package> getPackagesByEventId(@PathVariable Long eventId) {
        return packageService.getPackagesByEventId(eventId);
    }
}
