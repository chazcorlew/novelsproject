package com.revature.novels.novelsproject.novel;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "novels")
@Repository

public class Novels {

    @Id
    @Column(name = "novel_id")
    private UUID novel_id;

    @Column(name = "novel_year", nullable = false, unique = true)
    private String novel_year;

    @Column(name = "novel", nullable = false, unique = true)
    private String novel;

    @Column(name = "genre", nullable = false, unique = true)
    private String genre;


    public Novels(){
        super();


    }

    public Novels(UUID novel_id, String novel_year, String novel, String genre){
        this.novel_id = novel_id;
        this.novel_year = novel_year;
        this.novel = novel;
        this.genre = genre;
    }

    public UUID getNovel_id() {
        return novel_id;
    }

    public void setNovel_id(UUID novel_id) {
        this.novel_id = novel_id;
    }

    public String getNovel_year() {
        return novel_year;
    }

    public void setNovel_year(String novel_year) {
        this.novel_year = novel_year;
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
        return novel_id.equals(novels.novel_id) && novel_year.equals(novels.novel_year) && novel.equals(novels.novel) && genre.equals(novels.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(novel_id, novel_year, novel, genre);
    }

    @Override
    public String toString() {
        return "Novels{" +
                "novel_id=" + novel_id +
                ", novel_year='" + novel_year + '\'' +
                ", novel='" + novel + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
