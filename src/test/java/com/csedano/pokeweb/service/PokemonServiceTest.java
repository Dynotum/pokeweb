package com.csedano.pokeweb.service;

import com.csedano.pokeweb.entity.Pokemon;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class PokemonServiceTest {
    private Logger logger = LoggerFactory.getLogger(PokemonServiceTest.class);
    @Autowired
    PokemonService pokemonService;

    @Test
    public void getPokemonById() {
        final Optional<Pokemon> optionPokemon = pokemonService.getById(1);
        final Pokemon pokemon;
        if (optionPokemon.isPresent()) {
            pokemon = optionPokemon.get();
            logger.info(pokemon.toString());
            assertEquals(pokemon.getId(), 1);
            assertEquals(pokemon.getName(), "bulbasaur");
        }
    }

}