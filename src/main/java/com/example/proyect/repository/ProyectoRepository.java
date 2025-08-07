package com.example.proyect.repository;

import com.example.proyect.Model.proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ProyectoRepository extends JpaRepository<proyecto, Long> {

    Optional<proyecto> findById(Long id);

    List<proyecto> findAll();

    boolean existsByNombre(String nombre);

    void deleteById(Long id);

}
