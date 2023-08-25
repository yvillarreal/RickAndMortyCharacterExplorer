package com.service;

import com.model.CharacterDetails;
import com.model.CharacterResponse;
import com.model.SingleCharacter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RickAndMortyService {
    private static final String API_URL = "https://rickandmortyapi.com/api/character";

    private final RestTemplate restTemplate = new RestTemplate();

    public CharacterResponse getCharacters() {
        return restTemplate.getForObject(API_URL, CharacterResponse.class);
    }

    public SingleCharacter getCharacterById(int id) {
        String apiUrl = API_URL + "/" + id;
        return restTemplate.getForObject(apiUrl, SingleCharacter.class);
    }

    public CharacterDetails getCharacterById(Long id) {
        String characterUrl = API_URL + "/" + id;
        return restTemplate.getForObject(characterUrl, CharacterDetails.class);
    }
}
