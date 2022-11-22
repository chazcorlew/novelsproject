package com.revature.novels.novelsproject.novel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NovelRepo extends JpaRepository<Novels, UUID> {



    List<Novels> findNovelsByNovel(String novel);




}
