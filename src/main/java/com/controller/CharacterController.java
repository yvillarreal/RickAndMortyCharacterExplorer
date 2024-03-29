package com.controller;


import com.model.characters.CharacterDetails;
import com.model.characters.CharacterResponse;
import com.model.characters.Characters;
import com.service.RickAndMortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CharacterController {
    @Autowired
    private RickAndMortyService rickAndMortyService;

    @GetMapping("/")
    public String showCharacters(@RequestParam(name = "search", required = false) String searchQuery,
                                 @RequestParam(name = "species", required = false) String species,
                                 @RequestParam(name = "page", defaultValue = "1") int page,
                                 Model model) {
        CharacterResponse characterResponse = rickAndMortyService.getCharacters();

        // Extract pagination data
        int totalPages = characterResponse.getInfo().getPages();

        List<Characters> characters = characterResponse.getResults();

        if (searchQuery != null && !searchQuery.isEmpty()) {
            // Filtrar personajes por nombre
            characters = characters.stream()
                    .filter(character -> character.getName().toLowerCase().contains(searchQuery.toLowerCase()))
                    .collect(Collectors.toList());
        }

        if (species != null && !species.isEmpty()) {
            // Filtrar personajes por especie
            characters = characters.stream()
                    .filter(character -> character.getSpecies().equalsIgnoreCase(species))
                    .collect(Collectors.toList());
        }

        model.addAttribute("characters", characters);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "allCharacters";
    }

    @GetMapping("/characterDetails/{id}")
    public String showCharacterDetails(@PathVariable Long id, Model model) {
        CharacterDetails character = rickAndMortyService.getCharacterById(id);
        model.addAttribute("characterDetails", character);
        return "characterDetails";
    }

    @GetMapping("/page={page}")
    public String showCharactersByPage(@PathVariable int page, Model model) {
        CharacterResponse characterResponse = rickAndMortyService.getPage(page);

        // Extract pagination data
        int totalPages = characterResponse.getInfo().getPages();

        List<Characters> characters = characterResponse.getResults();

        model.addAttribute("characters", characters);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "allCharacters";
    }

    @GetMapping("/about")
    public String showAboutPage() {
        return "about"; // Retorna el nombre de la vista "about.html"
    }


}
