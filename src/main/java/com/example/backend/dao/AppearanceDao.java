package com.example.backend.dao;

import com.example.backend.domain.Appearance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppearanceDao extends JpaRepository<Appearance, String> {
}
