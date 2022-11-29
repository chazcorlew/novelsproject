package com.revature.novels.novelsproject.characters;

import com.revature.novels.novelsproject.novel.Novels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepo extends JpaRepository <NovelCharacters, String>{

    List<NovelCharacters> findNovelCharactersByNovel (Novels novels);

    Optional<NovelCharacters> findNovelCharactersByFullName (String fullName);

    Optional <NovelCharacters> findNovelCharactersByCharId (String charId);


}
