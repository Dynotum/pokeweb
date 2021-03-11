package com.csedano.pokeweb.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {

    public Pokemon() {
    }

    public Pokemon(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                '}';
    }
}
