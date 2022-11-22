package com.revature.novels.novelsproject.characters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CharacterRepo extends JpaRepository <NovelCharacters, UUID>{

    List<NovelCharacters> findNovelCharactersByNovelId(int novelId);

}
