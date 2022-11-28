package com.revature.novels.novelsproject.characters;


import com.revature.novels.novelsproject.novel.NovelRepo;
import com.revature.novels.novelsproject.novel.Novels;
import org.springframework.beans.factory.annotation.Autowired;
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


}


