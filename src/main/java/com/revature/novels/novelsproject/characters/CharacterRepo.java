package com.revature.novels.novelsproject.characters;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CharacterRepo extends JpaRepository <NovelCharacters, UUID>{

    List<NovelCharacters> findNovelCharactersByNovelId(int novelId);

}
