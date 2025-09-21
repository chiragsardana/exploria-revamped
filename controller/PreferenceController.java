package com.devnologix.exploria_backend.controller;


import org.springframework.web.bind.annotation.*;

import com.devnologix.exploria_backend.model.Preference;
import com.devnologix.exploria_backend.service.PreferenceService;

import java.util.List;

@RestController
@RequestMapping("/api/preferences")
public class PreferenceController {

    private final PreferenceService preferenceService;

    public PreferenceController(PreferenceService preferenceService) {
        this.preferenceService = preferenceService;
    }
    
    @PostMapping
    public Preference createPreference(@RequestBody Preference preference) {
        return preferenceService.createPreference(preference);
    }

    @GetMapping("/{id}")
    public Preference getPreferenceById(@PathVariable String id) {
        return preferenceService.getPreferenceById(id);
    }

    @GetMapping
    public List<Preference> getAllPreferences() {
        return preferenceService.getAllPreferences();
    }
}
