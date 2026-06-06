package Workers;

import java.util.Objects;

public class Director extends Person {
    private int numberOfShows;

    public Director(String name, String surname, Genders gender, int numberOfShows) {
        super(name, surname, gender);
        this.numberOfShows = numberOfShows;
    }

    //Getters and Setters=====================================
    public int getNumberOfShows() {
        return numberOfShows;
    }

    public boolean setNumberOfShows(int numberOfShows) {
        if (numberOfShows < 0)
            return false;

        this.numberOfShows = numberOfShows;
        return true;
    }
    //=========================================================

    //Object methods============================
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        return super.equals(obj) && ((Director) obj).numberOfShows == numberOfShows;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfShows);
    }
    //==========================================
}
