package com.example.proyect.controllers;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.proyect.Model.proyecto;
import com.example.proyect.repository.ProyectoRepository;
import com.example.proyect.service.ProyectoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    
    @Autowired
    private ProyectoService proyectoService;

    @GetMapping
    public List<proyecto> listar() {
        return proyectoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<proyecto> obtenerPorId(@PathVariable Long id) {
        return proyectoService.obtenerProyectoPorId(id);
    }

    @PostMapping
    public proyecto crear(@RequestBody proyecto proyecto) {
        return proyectoService.crear(proyecto);
    }

    @PutMapping("/{id}")
    public proyecto actualizar(@PathVariable Long id, @RequestBody proyecto proyecto) {
        return proyectoService.actualizar(id, proyecto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        proyectoService.eliminar(id);
    }

}
