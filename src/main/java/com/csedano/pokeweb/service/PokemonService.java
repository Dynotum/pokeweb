package com.csedano.pokeweb.service;

import com.csedano.pokeweb.dao.IPokemonDAO;
import com.csedano.pokeweb.entity.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository()
public class PokemonService {

    @Autowired
    private IPokemonDAO dao;

    public Pokemon save(Pokemon pokemon) {
        return dao.save(pokemon);
    }

    public Pokemon update(Pokemon t) {
        return dao.save(t);
    }

    public boolean delete(int idPokemon) {
        return dao.findByIdPokemon(idPokemon).map(pokemons -> {dao.deleteById(idPokemon);
            return true;
        }).orElse(false);
    }

    public List<Pokemon> getAll() {
        return (List<Pokemon>) dao.findAll();
    }

    public Optional<Pokemon> getById(int id) {
        return dao.findByIdPokemon(id);
    }

}
