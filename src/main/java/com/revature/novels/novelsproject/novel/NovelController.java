package com.revature.novels.novelsproject.novel;

import com.revature.novels.novelsproject.exceptions.ResourceNotFoundException;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/novels")
public class NovelController {


    private final NovelRepo novelRepo;

    private final NovelService novelService;

    @Autowired
    public NovelController(NovelRepo novelRepo, NovelService novelService) {
        this.novelRepo = novelRepo;
        this.novelService = novelService;
    }


    @GetMapping(produces = "application/json")
    public List<Novels> getAllNovels() {
        return novelRepo.findAll();
    }

    @GetMapping(value = "/{novel}", produces = "application/json")
    public List<Novels> getNovelByNovel(@PathVariable String novel) {

        try {
            return novelRepo.findNovelsByNovel(novel);


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    @PostMapping("/addNovels")
    Novels newNovel(@RequestBody Novels newNovel){
        return novelRepo.save(newNovel);

    }

        @PutMapping("{novelId}")
    public ResponseEntity<Novels> updateNovel(@PathVariable("novelId") int novelId, @RequestBody Novels novels){
        Novels updateNovel = novelRepo.findNovelByNovelId(novelId)
                .orElseThrow(() -> new ResourceNotFoundException("Novel does not exist with ID: " + novelId));

        updateNovel.setNovelYear(novels.getNovelYear());
        updateNovel.setNovel(novels.getNovel());
        updateNovel.setGenre(novels.getGenre());

        novelRepo.save(updateNovel);

        return ResponseEntity.ok(updateNovel);

        }
        @OnDelete(action = OnDeleteAction.CASCADE)
        @DeleteMapping(path = "/deleteNovel/{novelId}")
    public void deleteNovel(@PathVariable ("novelId") int novelId){
        novelRepo.deleteById(novelId);

    }
}