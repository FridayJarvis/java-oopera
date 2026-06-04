package Workers;

import java.util.Objects;

public class Director extends Person {
    protected int numberOfShows;

    public Director(String name, String surname, Genders gender, int numberOfShows) {
        super(name, surname, gender);
        this.numberOfShows = numberOfShows;
    }


    //Object methods============================
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        return super.equals(obj) && Objects.equals(((Director) obj).numberOfShows, numberOfShows);
    }
    //==========================================

}
