package Shows;

import Workers.Actor;
import Workers.Director;
import Workers.Genders;

import java.util.ArrayList;

public class Show {
    public enum ReplaceActorResult {
        SUCCESS,
        OLD_ACTOR_NOT_FOUND,
        NEW_ACTOR_ALREADY_EXIST
    }

    protected String title;
    protected int duration; //in minutes
    protected ArrayList<Actor> actors;
    protected ArrayList<Director> directors;

    public Show(String title, int duration) {
        this.title = title;
        this.duration = duration;
        directors = new ArrayList<>();
        actors = new ArrayList<>();
    }

    public boolean addActor(Actor actor) {
        if (actors.contains(actor)) {
            return false;
        }

        actors.add(actor);
        return true;
    }

    public boolean addDirector(Director director) {
        if (directors.contains(director)) {
            return false;
        }

        directors.add(director);
        return true;
    }

    public ReplaceActorResult replaceActor(Actor oldActor, Actor newActor) {
        if (!actors.contains(oldActor))
            return ReplaceActorResult.OLD_ACTOR_NOT_FOUND;

        if (actors.contains(newActor))
            return ReplaceActorResult.NEW_ACTOR_ALREADY_EXIST;

        actors.remove(oldActor);
        addActor(newActor);

        return ReplaceActorResult.SUCCESS;
    }

    public static String getMessageIfActorExist(Actor newActor) {
        if (newActor.getGender() == Genders.MALE)
            return "Актер " + newActor + " уже участвует в постановке. Проверьте вводимые данные";
        else
            return "Актриса " + newActor + " уже участвует в постановке. Проверьте вводимые данные";
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public ArrayList<Director> getDirectors() {
        return directors;
    }
}
