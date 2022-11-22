package com.revature.novels.novelsproject.novel;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "novels")
@Repository

public class Novels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int novelId;

    @Column(name = "novelYear", nullable = false, unique = true)
    private String novelYear;

    @Column(name = "novel", nullable = false, unique = true)
    private String novel;

    @Column(name = "genre", nullable = false, unique = true)
    private String genre;


    public Novels(){
        super();


    }

    public Novels(int novelId, String novelYear, String novel, String genre){
        this.novelId = novelId;
        this.novelYear = novelYear;
        this.novel = novel;
        this.genre = genre;
    }

    public int getNovelId() {
        return novelId;
    }

    public void setNovelId(int novelId) {
        this.novelId = novelId;
    }

    public String getNovelYear() {
        return novelYear;
    }

    public void setNovelYear(String novelYear) {
        this.novelYear = novelYear;
    }

    public String getNovel() {
        return novel;
    }

    public void setNovel(String novel) {
        this.novel = novel;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Novels novels = (Novels) o;
        return novelId == novels.novelId && novelYear.equals(novels.novelYear) && novel.equals(novels.novel) && genre.equals(novels.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(novelId, novelYear, novel, genre);
    }

    @Override
    public String toString() {
        return "Novels{" +
                "novelId=" + novelId +
                ", novelYear='" + novelYear + '\'' +
                ", novel='" + novel + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}

