package com.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.characters.CharacterDetails;
import com.model.characters.CharacterResponse;
import com.model.info.Info;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class RickAndMortyService {
    private static final String API_URL = "https://rickandmortyapi.com/api/character";

    private final RestTemplate restTemplate = new RestTemplate();

    public CharacterResponse getCharacters() {
        return restTemplate.getForObject(API_URL, CharacterResponse.class);
    }

    public CharacterDetails getCharacterById(Long id) {
        String characterUrl = API_URL + "/" + id;
        return restTemplate.getForObject(characterUrl, CharacterDetails.class);
    }

}
