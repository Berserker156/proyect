package com.example.proyect.controllers;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.proyect.Model.users;
import com.example.proyect.repository.UsuarioRepository;

@RestController
@RequestMapping("/auth")

public class AuthController {

       @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public String login(@RequestBody users usuario) {
        users user = usuarioRepository.findByUsername(usuario.getUsername());
        if (user != null && user.getPassword().equals(usuario.getPassword())) {
            return "Login exitoso";
        }
        return "Credenciales incorrectas";
    }

}
