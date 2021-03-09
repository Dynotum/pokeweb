package com.csedano.pokeweb.controller;

import com.csedano.pokeweb.entity.Pokemon;
import com.csedano.pokeweb.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @PostMapping("/save")
    public ResponseEntity<Pokemon> save(@Validated @RequestBody Pokemon pokemon) {
        return new ResponseEntity<>(pokemonService.save(pokemon), HttpStatus.CREATED);
    }

    @PostMapping("/saveAll")
    public ResponseEntity<Pokemon> saveAll(@Validated @RequestBody List<Pokemon> pokemons) {
        return new ResponseEntity<>(pokemonService.saveAll(pokemons), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int pokemonId) {
        if (pokemonService.delete(pokemonId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pokemon>> listAllPokemon() {
        return new ResponseEntity<>(pokemonService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable("id") int id) {
        return pokemonService.getById(id).map(pokemon -> new ResponseEntity<>(pokemon, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
