package Shows;

import Workers.AuthorOfMusic;

import java.util.ArrayList;

public class MusicalShow extends Show {
    private String libretto;
    private ArrayList<AuthorOfMusic> authorsOfMusic;

    protected MusicalShow(String title, int duration, String libretto) {
        super(title, duration);
        this.libretto = libretto;
        this.authorsOfMusic = new ArrayList<>();
    }

    protected MusicalShow(String title, int duration) {
        this(title, duration, "");
    }

    //Getters and Setters=====================================
    public String getLibretto() {
        return libretto;
    }

    public void setLibretto(String libretto) {
        this.libretto = libretto;
    }

    public ArrayList<AuthorOfMusic> getAuthorsOfMusic() {
        return authorsOfMusic;
    }
    //=========================================================

    public boolean addAuthorOfMusic(AuthorOfMusic authorOfMusic) {
        if (authorsOfMusic.contains(authorOfMusic))
            return false;

        authorsOfMusic.add(authorOfMusic);
        return true;
    }
}
