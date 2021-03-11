package com.csedano.pokeweb.controller;

import com.csedano.pokeweb.entity.Pokemon;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PokemonControllerTest {

    @Autowired
    TestRestTemplate template;

    @Test
    public void greeWithName() {
        final Pokemon pokemon = template.getForObject("/rest?name=mew&id=151", Pokemon.class);
        assertEquals("mew", pokemon.getName());
        assertEquals(151, pokemon.getId());
    }

    @Test
    public void greeWithoutName() {
        final ResponseEntity<Pokemon> entity = template.getForEntity("/rest", Pokemon.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
        final Pokemon pokemon= entity.getBody();
        assertEquals("chikorita", pokemon.getName());
        assertEquals(152, pokemon.getId());
    }
}
