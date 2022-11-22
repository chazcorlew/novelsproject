package com.revature.novels.novelsproject.novel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NovelRepo extends JpaRepository<Novels, Integer> {



    List<Novels> findNovelsByNovel(String novel);




}
