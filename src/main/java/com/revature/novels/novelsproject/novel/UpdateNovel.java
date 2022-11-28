package com.revature.novels.novelsproject.novel;

import java.util.Objects;

public class UpdateNovel {

    private String novelId;

    private String novelYear;

    private String novel;

    private String genre;


    public UpdateNovel(){
        super();
    }

    public UpdateNovel(String novelId, String novelYear, String novel, String genre){
        this.novelId = novelId;
        this.novelYear = novelYear;
        this.novel = novel;
        this.genre = genre;

    }

    public String getNovelId() {
        return novelId;
    }

    public void setNovelId(String novelId) {
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
        if (!(o instanceof UpdateNovel)) return false;
        UpdateNovel that = (UpdateNovel) o;
        return getNovelId().equals(that.getNovelId()) && getNovelYear().equals(that.getNovelYear()) && getNovel().equals(that.getNovel()) && getGenre().equals(that.getGenre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNovelId(), getNovelYear(), getNovel(), getGenre());
    }

    @Override
    public String toString() {
        return "UpdateNovel{" +
                "novelId='" + novelId + '\'' +
                ", novelYear='" + novelYear + '\'' +
                ", novel='" + novel + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
