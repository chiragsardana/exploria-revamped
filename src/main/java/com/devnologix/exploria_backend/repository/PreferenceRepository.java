package com.devnologix.exploria_backend.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devnologix.exploria_backend.model.Preference;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, String> {
}
