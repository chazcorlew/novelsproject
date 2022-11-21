package com.revature.novels.novelsproject.novel;

import com.sun.jdi.request.InvalidRequestStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NovelService {

    private final NovelRepo novelRepo;

    @Autowired
    public NovelService(NovelRepo novelRepo){
        this.novelRepo = novelRepo;
    }

    public List<UserResponse> getAllNovels() {
        return novelRepo.findAll()
                .stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    public UserResponse getNovelByNovel(String novelImport) {
        try{
            return novelRepo.findNovelsByNovel(novelImport)
                    .map(UserResponse::new)
                    .orElseThrow(ResourceNotFoundException::new);
        }catch (IllegalArgumentException e){
            throw new InvalidRequestStateException(" a valid novel name must be provided");
        }
    }
}
