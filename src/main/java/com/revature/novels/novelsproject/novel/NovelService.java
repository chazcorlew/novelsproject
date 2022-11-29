package com.revature.novels.novelsproject.novel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class NovelService {

    private final NovelRepo novelRepo;


    @Autowired
    public NovelService(NovelRepo novelRepo) {
        this.novelRepo = novelRepo;
    }

    public Novels updateNovel(Novels novels, int novelId){
        Novels existingNovel = novelRepo.findNovelByNovelId(novelId).orElseThrow(ResourceNotFoundException::new);

        existingNovel.setNovelYear(novels.getNovelYear());
        existingNovel.setNovel(novels.getNovel());
        existingNovel.setGenre(novels.getGenre());

        novelRepo.save(existingNovel);

        return existingNovel;
    }


    }




