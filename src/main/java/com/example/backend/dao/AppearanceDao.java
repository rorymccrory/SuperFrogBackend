package com.example.backend.dao;

import com.example.backend.domain.Appearance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppearanceDao extends JpaRepository<Appearance, String> {
    List<Appearance> findAllByCreateTimeBetween(LocalDate startDate, LocalDate endDate);

    //List<Appearance> findAllApproved();
}
