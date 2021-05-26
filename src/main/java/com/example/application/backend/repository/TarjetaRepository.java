package com.example.application.backend.repository;

import com.example.application.backend.model.Tarjeta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta,Long> {
}
