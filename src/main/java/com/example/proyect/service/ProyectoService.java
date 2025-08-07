package com.example.proyect.service;
import com.example.proyect.Model.proyecto;
import com.example.proyect.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProyectoService {
    @Autowired
    private ProyectoRepository proyectoRepository;

    public List<proyecto> listar() {
        return proyectoRepository.findAll();
    }

    public Optional<proyecto> obtenerProyectoPorId(Long id) {
        return proyectoRepository.findById(id);
    }

    public proyecto crear(proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public proyecto actualizar(Long id, proyecto proyecto) {
        proyecto.setId(id);
        return proyectoRepository.save(proyecto);
    }

    public void eliminar(Long id) {
        proyectoRepository.deleteById(id);
    }

}
