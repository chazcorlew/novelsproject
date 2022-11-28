package com.revature.novels.novelsproject.characters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class NovCharService {

    private final CharacterRepo characterRepo;


    @Autowired
    public NovCharService(CharacterRepo characterRepo) {
        this.characterRepo = characterRepo;
    }

    public NovelCharacters updateNovelCharacters(NovelCharacters novelCharacters, int charId){
        NovelCharacters existingNovelCharacter = characterRepo.findNovelCharactersByCharId(charId).orElseThrow(ResourceNotFoundException::new);

        existingNovelCharacter.setFullName(novelCharacters.getFullName());
        existingNovelCharacter.setMainProtagonist(novelCharacters.isMainProtagonist());
        existingNovelCharacter.setAdaptedForAnime(novelCharacters.isAdaptedForAnime());


        characterRepo.save(existingNovelCharacter);

        return existingNovelCharacter;
    }


}
