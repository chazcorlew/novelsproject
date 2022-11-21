package com.revature.novels.novelsproject.novel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface NovelRepo extends JpaRepository<Novels, UUID> {

    boolean existsByNovel(String novel);

    boolean existsByNovel_year (String novel_year);

    List<Novels> findAllByNovel_id (String novel_id);

    Optional<Novels> findNovelsByNovel(String novel);




}
