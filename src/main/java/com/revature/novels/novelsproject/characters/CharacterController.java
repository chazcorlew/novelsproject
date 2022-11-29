package com.revature.novels.novelsproject.characters;


import com.revature.novels.novelsproject.exceptions.ResourceNotFoundException;
import com.revature.novels.novelsproject.novel.NovelRepo;
import com.revature.novels.novelsproject.novel.Novels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/{fullName}",produces = "application/json")
    public Optional<NovelCharacters> getCharactersByFullName(@PathVariable String fullName) {

        try{
            return characterRepo.findNovelCharactersByFullName(fullName);


        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    @GetMapping(value = "/{novelId}", produces = "application/json")
    public List<NovelCharacters> getNovelCharactersByNovelId(@PathVariable int novelId) {

        Novels novel = novelRepo.findById(novelId).orElseThrow(RuntimeException::new);
        return characterRepo.findNovelCharactersByNovel(novel);
    }




    @PostMapping(path = "/addCharacter", consumes = "application/json")
    public NovelCharacters createNovelCharacter (@RequestBody NovelCharacters characters){
        NovelCharacters dest = characterRepo.save(characters);
        return dest;
    }

    @PutMapping("{charId}")
    public ResponseEntity<NovelCharacters> updateCharacter(@PathVariable("charId") String charId, @RequestBody NovelCharacters characters){
        NovelCharacters updateCharacter = characterRepo.findNovelCharactersByCharId(charId).orElseThrow(() -> new ResourceNotFoundException("Character does not exist with ID: " + charId));

   updateCharacter.setFullName(characters.getFullName());
   updateCharacter.setMainProtagonist(characters.isMainProtagonist());
   updateCharacter.setAdaptedForAnime(characters.isAdaptedForAnime());

   characterRepo.save(updateCharacter);

   return ResponseEntity.ok(updateCharacter);

    }
    @DeleteMapping(path = "/{charId}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable String charId) {

        characterRepo.deleteById(charId);
        return ResponseEntity.noContent().build();

    }
}




