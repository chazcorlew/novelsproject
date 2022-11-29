package com.revature.novels.novelsproject.novel;

import com.revature.novels.novelsproject.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping("/novels")
public class NovelController {


    private final NovelRepo novelRepo;

    @Autowired
    public NovelController(NovelRepo novelRepo) {
        this.novelRepo = novelRepo;
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
        @PostMapping(path = "/addNovel", consumes = "application/json")
    public Novels createNovel(@RequestBody Novels novels){
     Novels dest = novelRepo.save(novels);
     return dest;

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
        @DeleteMapping(path = "/{novelId}")
    public ResponseEntity<Void> deleteNovel(@PathVariable String novelId) {

    novelRepo.deleteById(Integer.valueOf(novelId));
    return ResponseEntity.noContent().build();

    }
}