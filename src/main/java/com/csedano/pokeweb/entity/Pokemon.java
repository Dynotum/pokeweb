package com.csedano.pokeweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pokemon {

    @Id
    @Column(name = "id_pokemon")
    private Integer idPokemon;

    private String name;

    public Pokemon() {
        super();
    }

    public Pokemon(Integer idPokemon, String name) {
        this.idPokemon = idPokemon;
        this.name = name;
    }

    public Integer getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(Integer idPokemon) {
        this.idPokemon = idPokemon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
