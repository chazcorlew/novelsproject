package com.revature.novels.novelsproject.characters;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "novel_characters")
@Repository
public class NovelCharacters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int charId;

    @Column(name = "fullName", unique = true, nullable = false)
    private String fullName;

    @Column(name = "mainProtagonist")
    private boolean mainProtagonist;

    @Column(name = "adaptedForAnime")
    private boolean adaptedForAnime;

    @Column(name = "novelId", unique = true, nullable = false)
    private int novelId;

    public NovelCharacters(){
        super();

    }

    public NovelCharacters(int charId, String fullName, boolean mainProtagonist, boolean adaptedForAnime, int novelId){
        this.charId = charId;
        this.fullName = fullName;
        this.mainProtagonist = mainProtagonist;
        this.adaptedForAnime = adaptedForAnime;
        this.novelId = novelId;

    }

    public int getCharId() {
        return charId;
    }

    public void setCharId(int charId) {
        this.charId = charId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isMainProtagonist() {
        return mainProtagonist;
    }

    public void setMainProtagonist(boolean mainProtagonist) {
        this.mainProtagonist = mainProtagonist;
    }

    public boolean isAdaptedForAnime() {
        return adaptedForAnime;
    }

    public void setAdaptedForAnime(boolean adaptedForAnime) {
        this.adaptedForAnime = adaptedForAnime;
    }

    public int getNovelId() {
        return novelId;
    }

    public void setNovelId(int novelId) {
        this.novelId = novelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NovelCharacters)) return false;
        NovelCharacters that = (NovelCharacters) o;
        return getCharId() == that.getCharId() && isMainProtagonist() == that.isMainProtagonist() && isAdaptedForAnime() == that.isAdaptedForAnime() && getNovelId() == that.getNovelId() && getFullName().equals(that.getFullName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCharId(), getFullName(), isMainProtagonist(), isAdaptedForAnime(), getNovelId());
    }

    @Override
    public String toString() {
        return "NovelCharacters{" +
                "charId=" + charId +
                ", fullName='" + fullName + '\'' +
                ", mainProtagonist=" + mainProtagonist +
                ", adaptedForAnime=" + adaptedForAnime +
                ", novelId=" + novelId +
                '}';
    }
}
