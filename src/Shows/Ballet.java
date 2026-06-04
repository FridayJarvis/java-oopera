package Shows;

import Workers.Choreographer;

import java.util.ArrayList;

public class Ballet extends MusicalShow {
    private ArrayList<Choreographer> choreographers;

    public Ballet(String title, int duration, String libretto) {
        super(title, duration, libretto);
        choreographers = new ArrayList<>();
    }

    public Ballet(String title, int duration) {
        this(title, duration, "");
    }

    //Getters and Setters================================
    public ArrayList<Choreographer> getChoreographers() {
        return choreographers;
    }
    //===================================================

    public boolean addChoreographer(Choreographer choreographer){
        if (choreographers.contains(choreographer))
            return false;

        choreographers.add(choreographer);
        return true;
    }
}
