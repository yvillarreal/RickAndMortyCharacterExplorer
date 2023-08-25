package com.controller;

import com.model.SingleCharacter;
import com.service.RickAndMortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SingleCharacterController {
    @Autowired
    private RickAndMortyService rickAndMortyService;

    @GetMapping("/character/{id}")
    public String showSingleCharacter(@PathVariable int id, Model model) {
        SingleCharacter character = rickAndMortyService.getCharacterById(id);
        model.addAttribute("character", character);
        return "singleCharacter";
    }
}
