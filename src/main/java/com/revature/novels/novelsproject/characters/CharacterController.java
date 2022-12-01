package com.revature.novels.novelsproject.characters;


import com.revature.novels.novelsproject.exceptions.ResourceNotFoundException;
import com.revature.novels.novelsproject.novel.NovelRepo;
import com.revature.novels.novelsproject.novel.Novels;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/novelcharacters")

public class CharacterController {

    private final NovelRepo novelRepo;
    private final CharacterRepo characterRepo;

    @Autowired
    public CharacterController(CharacterRepo characterRepo, NovelRepo novelRepo){
        this.characterRepo = characterRepo;
        this.novelRepo = novelRepo;
    }



    @GetMapping(produces = "application/json")
    public List<NovelCharacters> getAllNovelCharacters() {
        return characterRepo.findAll();
    }

    @GetMapping(value = "/names/{fullName}",produces = "application/json")
    public List<NovelCharacters> getCharactersByFullName(@PathVariable String fullName) {

        try{
            return characterRepo.findNovelCharactersByFullName(fullName);


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @GetMapping(value = "/characters/{novelId}", produces = "application/json")
    public List<NovelCharacters> getNovelCharactersByNovelId(@PathVariable int novelId) {

        Novels novel = novelRepo.findById(novelId).orElseThrow(RuntimeException::new);
        return characterRepo.findNovelCharactersByNovel(novel);
    }




    @PostMapping("/addCharacters")
    NovelCharacters newCharacter(@RequestBody NovelCharacters newCharacter){
        return characterRepo.save(newCharacter);
    }

    @PutMapping("{charId}")
    public ResponseEntity<NovelCharacters> updateCharacter(@PathVariable("charId") int charId, @RequestBody NovelCharacters characters){
        NovelCharacters updateCharacter = characterRepo.findNovelCharactersByCharId(charId).orElseThrow(() -> new ResourceNotFoundException("Character does not exist with ID: " + charId));

   updateCharacter.setFullName(characters.getFullName());
   updateCharacter.setMainProtagonist(characters.isMainProtagonist());
   updateCharacter.setAdaptedForAnime(characters.isAdaptedForAnime());

   characterRepo.save(updateCharacter);

   return ResponseEntity.ok(updateCharacter);

    }

    @OnDelete(action = OnDeleteAction.CASCADE)
    @DeleteMapping(path = "/deleteCharacters/{charId}")
    public void deleteCharacter(@PathVariable ("charId") int charId){
        characterRepo.deleteById(charId);

    }
}




