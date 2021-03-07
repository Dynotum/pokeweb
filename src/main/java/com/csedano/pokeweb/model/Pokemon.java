package com.csedano.pokeweb.model;

import javax.persistence.*;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPokemon;

    private String name;

    public Pokemon() {
    }

    public Pokemon(Long idPokemon, String name) {
        this.idPokemon = idPokemon;
        this.name = name;
    }

    public Long getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(Long idPokemon) {
        this.idPokemon = idPokemon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
