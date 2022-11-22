package com.revature.novels.novelsproject.characters;

import com.revature.novels.novelsproject.novel.Novels;
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

    @Column(unique = true, nullable = false)
    private String fullName;

    @Column
    private boolean mainProtagonist;

    @Column
    private boolean adaptedForAnime;


    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL, targetEntity = Novels.class)
    @JoinColumn(name = "novel_id")
    private Novels novel;


    public NovelCharacters() {
        super();

    }

    public NovelCharacters(int charId, String fullName, boolean mainProtagonist, boolean adaptedForAnime, Novels novel) {
        this.charId = charId;
        this.fullName = fullName;
        this.mainProtagonist = mainProtagonist;
        this.adaptedForAnime = adaptedForAnime;
        this.novel = novel;
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

    public Novels getNovel() {
        return novel;
    }

    public void setNovel(Novels novel) {
        this.novel = novel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NovelCharacters)) return false;
        NovelCharacters that = (NovelCharacters) o;
        return getCharId() == that.getCharId() && isMainProtagonist() == that.isMainProtagonist() && isAdaptedForAnime() == that.isAdaptedForAnime() && getFullName().equals(that.getFullName()) && getNovel().equals(that.getNovel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCharId(), getFullName(), isMainProtagonist(), isAdaptedForAnime(), getNovel());
    }

    @Override
    public String toString() {
        return "NovelCharacters{" +
                "charId=" + charId +
                ", fullName='" + fullName + '\'' +
                ", mainProtagonist=" + mainProtagonist +
                ", adaptedForAnime=" + adaptedForAnime +
                ", novel=" + novel +
                '}';
    }
}