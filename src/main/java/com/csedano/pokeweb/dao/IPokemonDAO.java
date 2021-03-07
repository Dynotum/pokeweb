package com.csedano.pokeweb.dao;

import com.csedano.pokeweb.model.Pokemon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPokemonDAO extends CrudRepository<Pokemon, Long> {

}
