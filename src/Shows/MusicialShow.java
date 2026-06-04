package Shows;

import Workers.AuthorOfMusic;

import java.util.ArrayList;

public class MusicialShow extends Show {
    protected String libretto;
    protected ArrayList<AuthorOfMusic> authorsOfMusic;
    protected MusicialShow(String title, int duration, String libretto) {
        super(title, duration);
        this.libretto = libretto;
        this.authorsOfMusic = new ArrayList<>();
    }

    protected MusicialShow(String title, int duration) {
        this(title, duration, "");
    }

    public String getLibretto() {
        return libretto;
    }

    public void setLibretto(String libretto) {
        this.libretto = libretto;
    }

    public ArrayList<AuthorOfMusic> getAuthorsOfMusic() {
        return authorsOfMusic;
    }

    public boolean addAuthorOfMusic(AuthorOfMusic authorOfMusic) {
        if (authorsOfMusic.contains(authorOfMusic))
            return false;

        authorsOfMusic.add(authorOfMusic);
        return true;
    }


}
