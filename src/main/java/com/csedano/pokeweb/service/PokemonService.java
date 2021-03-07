package com.csedano.pokeweb.service;

import com.csedano.pokeweb.dao.IPokemonDAO;
import com.csedano.pokeweb.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service()
public class PokemonService {

    @Autowired
    private IPokemonDAO dao;

    public Pokemon save(Pokemon t) {
        return dao.save(t);
    }

    public Pokemon update(Pokemon t) {
        return dao.save(t);
    }

    public void delete(Pokemon t) {
        dao.delete(t);
    }

    public Collection<Pokemon> list() {
        return (Collection<Pokemon>) dao.findAll();
    }

    public Optional<Pokemon> listId(long id) {
        return dao.findById(id);
    }

}
