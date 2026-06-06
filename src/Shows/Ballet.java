package Shows;

import Workers.Director;
import Workers.Person;

public class Ballet extends MusicalShow {
    private Person choreographer;

    public Ballet(String title, int duration, Director director, String libretto, Person authorOfMusic, Person choreographer) {
        super(title, duration, director, libretto, authorOfMusic);
        this.choreographer = choreographer;
    }

    //Getters and Setters================================
    public Person getChoreographer() {
        return choreographer;
    }

    public boolean setChoreographer(Person choreographer) {
        if (choreographer == null)
            return false;

        this.choreographer = choreographer;
        return true;
    }
    //===================================================

    public void printChoreographer() {
        if (choreographer == null) {
            System.out.println("choreographer = null");
            return;
        }

        System.out.println("Хореограф балета:");
        System.out.println(choreographer + "\n");
    }
}
