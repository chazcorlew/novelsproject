package com.revature.novels.novelsproject.characters;

import com.revature.novels.novelsproject.novel.Novels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepo extends JpaRepository <NovelCharacters, Integer>{

    List<NovelCharacters> findNovelCharactersByNovel (Novels novels);

}
