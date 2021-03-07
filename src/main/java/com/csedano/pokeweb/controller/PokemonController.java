package com.csedano.pokeweb.controller;

import com.csedano.pokeweb.exception.ModelNotFoundException;
import com.csedano.pokeweb.model.Pokemon;
import com.csedano.pokeweb.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @PostMapping("/save")
    public long save(@Validated @RequestBody Pokemon pokemon) {
        pokemonService.save(pokemon);
        return pokemon.getIdPokemon();
    }


    @GetMapping("/listAll")
    public Collection<Pokemon> listAllPokemon() {
        return pokemonService.list();
    }

    @GetMapping("/list/{id}")
    public Pokemon listByPokemon(@PathVariable("id") int id) {
        Optional<Pokemon> pokemon = pokemonService.listId(id);

        if (pokemon.isPresent()) {
            return pokemon.get();
        }

        throw new ModelNotFoundException("Invalid find pokemon provided");
    }
}
