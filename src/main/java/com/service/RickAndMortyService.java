package com.service;

import com.model.characters.CharacterDetails;
import com.model.characters.CharacterResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RickAndMortyService {
    private static final String API_URL = "https://rickandmortyapi.com/api/character?page=1";
    private final RestTemplate restTemplate = new RestTemplate();

    public CharacterResponse getCharacters() {
        return restTemplate.getForObject(API_URL, CharacterResponse.class);
    }

    public CharacterDetails getCharacterById(Long id) {
        String characterUrl = API_URL + "/" + id;
        return restTemplate.getForObject(characterUrl, CharacterDetails.class);
    }
}
