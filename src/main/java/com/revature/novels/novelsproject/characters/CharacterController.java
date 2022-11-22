package com.revature.novels.novelsproject.characters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/novel_characters")

public class CharacterController {

    private final CharacterRepo characterRepo;

    @Autowired
    public CharacterController(CharacterRepo characterRepo){
        this.characterRepo = characterRepo;

    }

    @GetMapping(produces = "application/json")
    public List<NovelCharacters> getAllNovels() {
        return characterRepo.findAll();
    }

}
