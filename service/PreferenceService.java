package com.devnologix.exploria_backend.service;

import java.util.List;

import com.devnologix.exploria_backend.model.Preference;

public interface PreferenceService {
    Preference createPreference(Preference preference);
    Preference getPreferenceById(String id);
    List<Preference> getAllPreferences();
}