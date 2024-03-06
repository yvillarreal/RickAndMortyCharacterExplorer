package com.service;

import com.model.characters.CharacterDetails;
import com.model.characters.CharacterResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RickAndMortyService {
    private static final String API_URL_BASE = "https://rickandmortyapi.com/api/character";
    private final RestTemplate restTemplate = new RestTemplate();

    public CharacterResponse getCharacters() {
        return restTemplate.getForObject(API_URL_BASE, CharacterResponse.class);
    }
    public CharacterResponse getPage(int page) {
        String url = String.format(API_URL_BASE + "?page=" + page);
        return restTemplate.getForObject(url, CharacterResponse.class);
    }

    public CharacterDetails getCharacterById(Long id) {
        String characterUrl = API_URL_BASE + "/" + id;
        return restTemplate.getForObject(characterUrl, CharacterDetails.class);
    }
}
