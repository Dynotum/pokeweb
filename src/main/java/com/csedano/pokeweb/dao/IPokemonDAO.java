package com.csedano.pokeweb.dao;

import com.csedano.pokeweb.entity.Pokemon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPokemonDAO extends CrudRepository<Pokemon, Integer> {

//    @Query(value = "select * from pokemon where id_pokemon = ?", nativeQuery = true)
    Optional<Pokemon> findByid(int id);


}
