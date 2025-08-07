package com.example.proyect.repository;

import com.example.proyect.Model.users;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<users, Long>  {

    users findByUsername(String username);
    
    Optional<users> findById(Long id);

    List<users> findAll();

    boolean existsByUsername(String username);

    void deleteById(Long id);
}
