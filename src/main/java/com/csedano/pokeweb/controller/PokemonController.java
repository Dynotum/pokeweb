package com.csedano.pokeweb.controller;

import com.csedano.pokeweb.entity.Pokemon;
import com.csedano.pokeweb.service.PokemonService;
import org.dom4j.rule.Mode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequestMapping("/pokemon")

@Controller
public class PokemonController {
    @Autowired
    PokemonService pokemonService;
    Logger logger = LoggerFactory.getLogger(PokemonController.class);

    @PostMapping("/save")
    public ResponseEntity<Pokemon> save(@Validated @RequestBody Pokemon pokemon) {
        return new ResponseEntity<>(pokemonService.save(pokemon), HttpStatus.CREATED);
    }

    @PostMapping("/saveAll")
    public ResponseEntity<List<Pokemon>> saveAll(@Validated @RequestBody List<Pokemon> pokemons) {
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

    @GetMapping("/id/{id}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        return pokemonService.getById(id).map(pokemon -> new ResponseEntity<>(pokemon, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/model")
    public String getPokemonById(@RequestParam int id, Model model) {
        model.addAttribute("pokemon", pokemonService.getById(id).get().getName());
        logger.info("id = " + id);
//        return pokemonService.getById(id).get().getName();
        return "hello";
    }

/*    @GetMapping("/algo")
    public String sayHello(
            @RequestParam(defaultValue = "World", required = false) String algo, Model model) {
        model.addAttribute("algo", algo);
        return "hello";
    }*/

    @GetMapping("/rest")
    public ResponseEntity<Pokemon> greet(@RequestParam(required = false, defaultValue = "bulbasaur") String name,
                                         @RequestParam(required = false, defaultValue = "1") int id) {
        return pokemonService.getById(id).map(pokemon -> new ResponseEntity<>(pokemon, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
