package com.curso.webservice;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Esto arranca un servidor web de pruebas
@SpringBootTest(classes= AppWeb.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

// Mock para poder hacer peticiones cliente
@AutoConfigureMockMvc
// Que la prueba de Junit, se haga usando el ejecutor de Springboot, para que resuelva la inyección de dependencias
@RunWith(SpringJUnit4ClassRunner.class)
// JUnit5: @ExtendWith(SpringExtension.class)

public class ControladorRestTest {

    @Autowired // Inyección de dependencias
    private MockMvc clienteDeMentira;

    @Test
    public void existeDiccionarioIdioma() throws Exception {
        clienteDeMentira.perform(MockMvcRequestBuilders.get("/api/v1/idioma/ES"))
                .andExpect(status().isOk());
        //.andExpect(jsonPath("$"))
    }
    @Test
    public void existePalabra() throws Exception {
        clienteDeMentira.perform(MockMvcRequestBuilders.get("/api/v1/idioma/ES/manzana"))
                .andExpect(status().isOk());
        //.andExpect(jsonPath("$"))
    }
    @Test
    public void noExistePalabra() throws Exception {
        clienteDeMentira.perform(MockMvcRequestBuilders.get("/api/v1/idioma/ES/manana"))
                .andExpect(status().isNotFound());
        //.andExpect(jsonPath("$"))
    }
}