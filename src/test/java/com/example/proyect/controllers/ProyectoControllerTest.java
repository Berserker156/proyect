package com.example.proyect.controllers;

import com.example.proyect.Model.proyecto;
import com.example.proyect.service.ProyectoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.Optional;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;






@WebMvcTest(ProyectoController.class)
public class ProyectoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProyectoService proyectoService;

    @Test
    void testListar() throws Exception {
        proyecto p1 = new proyecto();
        proyecto p2 = new proyecto();
        Mockito.when(proyectoService.listar()).thenReturn(Arrays.asList(p1, p2));

        mockMvc.perform(get("/proyectos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void testObtenerPorIdFound() throws Exception {
        proyecto p = new proyecto();
        Mockito.when(proyectoService.obtenerProyectoPorId(1L)).thenReturn(Optional.of(p));

        mockMvc.perform(get("/proyectos/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testObtenerPorIdNotFound() throws Exception {
        Mockito.when(proyectoService.obtenerProyectoPorId(2L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/proyectos/2"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    void testCrear() throws Exception {
        proyecto p = new proyecto();
        Mockito.when(proyectoService.crear(any(proyecto.class))).thenReturn(p);

        mockMvc.perform(post("/proyectos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    void testActualizar() throws Exception {
        proyecto p = new proyecto();
        Mockito.when(proyectoService.actualizar(eq(1L), any(proyecto.class))).thenReturn(p);

        mockMvc.perform(put("/proyectos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    void testEliminar() throws Exception {
        Mockito.doNothing().when(proyectoService).eliminar(1L);

        mockMvc.perform(delete("/proyectos/1"))
                .andExpect(status().isOk());
    }
}