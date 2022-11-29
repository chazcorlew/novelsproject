package com.revature.novels.novelsproject.novel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NovelRepo extends JpaRepository<Novels, Integer> {



    List<Novels> findNovelsByNovel(String novel);

    Optional<Novels> findNovelByNovelId(int novelId);

    Optional<Novels> findNovelsByGenre(String genre);





}
