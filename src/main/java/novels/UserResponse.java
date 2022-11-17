package novels;


import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UserResponse implements Serializable {

    private String novel_id;

    private String novelYear;

    private String novel;

    private String genre;

    public UserResponse(){
        super();
    }

    public UserResponse(Novels subject) {
        this.novel_id = subject.getNovel_id().toString();
        this.novelYear = subject.getNovelYear();
        this.novel = subject.getNovel();
        this.genre = subject.getGenre();


    }

    public String getNovel_id() {
        return novel_id;
    }

    public void setNovel_id(String novel_id) {
        this.novel_id = novel_id;
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
}
