package com.devnologix.exploria_backend.service.impl;


import org.springframework.stereotype.Service;

import com.devnologix.exploria_backend.model.Preference;
import com.devnologix.exploria_backend.repository.PreferenceRepository;
import com.devnologix.exploria_backend.service.PreferenceService;

import java.util.List;

@Service
public class PreferenceServiceImpl implements PreferenceService {

    private final PreferenceRepository preferenceRepository;

    public PreferenceServiceImpl(PreferenceRepository preferenceRepository) {
        this.preferenceRepository = preferenceRepository;
    }

    @Override
    public Preference createPreference(Preference preference) {
        return preferenceRepository.save(preference);
    }

    @Override
    public Preference getPreferenceById(String id) {
        return preferenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Preference not found with id " + id));
    }

    @Override
    public List<Preference> getAllPreferences() {
        return preferenceRepository.findAll();
    }
}
