package Shows;

import Workers.Director;
import Workers.Person;

public class MusicalShow extends Show {
    protected String libretto;
    protected Person authorOfMusic;

    protected MusicalShow(String title, int duration, Director director, String libretto, Person authorOfMusic) {
        super(title, duration, director);
        this.libretto = libretto;
        this.authorOfMusic = authorOfMusic;
    }

    public void printLibretto() {
        if (libretto == null || libretto.isEmpty()) {
            System.out.println("У представления пока нет либретто\n");
            return;
        }

        System.out.println("Либретто:");
        System.out.println(libretto);
    }

    //Getters and Setters=====================================
    public boolean setLibretto(String libretto) {
        if (libretto == null)
            return false;

        this.libretto = libretto;
        return true;
    }

    public String getLibretto() {
        return libretto;
    }

    public Person getAuthorOfMusic() {
        return authorOfMusic;
    }

    public boolean setAuthorOfMusic(Person authorOfMusic) {
        if (authorOfMusic == null) {
            return false;
        }

        this.authorOfMusic = authorOfMusic;
        return true;
    }
    //=========================================================

    public void printAuthorOfMusic() {
        if (authorOfMusic == null) {
            System.out.println("AuthorOfMusic = null");
            return;
        }

        System.out.println("Автор композиций:");
        System.out.println(authorOfMusic + "\n");
    }
}
