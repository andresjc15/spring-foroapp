package com.app.foro.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.foro.models.entity.Carrera;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Integer> {

}
