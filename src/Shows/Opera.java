package Shows;

import Workers.Director;
import Workers.Person;

public class Opera extends MusicalShow {
    private int choirSize;

    public Opera(String title, int duration, Director director, String libretto, Person authorOfMusic, int choirSize) {
        super(title, duration, director, libretto, authorOfMusic);
        this.choirSize = choirSize;
    }

    //Getters and Setters================================
    public int getChoirSize() {
        return choirSize;
    }

    public boolean setChoirSize(int choirSize) {
        if (choirSize < 0)
            return false;

        this.choirSize = choirSize;
        return true;
    }
    //===================================================
}
