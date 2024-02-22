package com.service;

import com.model.characters.CharacterDetails;
import com.model.characters.CharacterResponse;
import com.model.characters.Characters;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public Characters getPage(Long page) {
        String characterUrl = API_URL + "/character?page=" + page;
        return restTemplate.getForObject(characterUrl, Characters.class);
    }
}
