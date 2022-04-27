package com.example.backend.dao;

import com.example.backend.domain.SuperFrog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperFrogDao extends JpaRepository<SuperFrog, Integer> {
}