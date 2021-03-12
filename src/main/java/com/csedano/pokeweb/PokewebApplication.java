package com.csedano.pokeweb;

//import com.csedano.pokeweb.service.PokemonService;

import com.csedano.pokeweb.entity.Pokemon;
import com.csedano.pokeweb.service.PokemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PokewebApplication {
    //    private final int KANTO_REGION = 151;
    @Autowired
    PokemonService pokemonService;

    private final int KANTO_REGION = 10;

    private static final Logger log = LoggerFactory.getLogger(PokewebApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(PokewebApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            log.info("==== RESTful API Response using Spring RESTTemplate START =======");
//            List<Pokemon> pokemons = new ArrayList<>();
            for (int i = 1; i <= KANTO_REGION; i++) {
//                if (i == 141) continue;
                pokemonService.save(restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/{id}", Pokemon.class, i));
//                pokemons.add(restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + i, Pokemon.class));
                log.info("Pokemon added: " + pokemonService.getById(i));
            }
            log.info("==== RESTful API Response using Spring RESTTemplate END =======");
//            pokemonService.saveAll(pokemons);
        };
    }

}
