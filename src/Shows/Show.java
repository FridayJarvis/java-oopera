package Shows;

import Workers.Actor;
import Workers.Director;
import Workers.Genders;

import java.util.ArrayList;

public class Show {
    public enum ReplaceActorResult {
        SUCCESS,
        OLD_ACTOR_NOT_FOUND,
        NEW_ACTOR_ALREADY_EXIST,
        ERROR
    }

    protected String title;
    protected int duration; //in minutes
    protected ArrayList<Actor> actors;
    protected Director director;
    protected Actor replacedOldActor = null;

    public Show(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        actors = new ArrayList<>();
    }

    public boolean addActor(Actor actor) {
        if (actors.contains(actor))
            return false;

        actors.add(actor);
        return true;
    }

    //Replace the first person with this surname
    public ReplaceActorResult replaceActor(String surnameOfOldActor, Actor newActor) {
        if (surnameOfOldActor == null || newActor == null)
            return ReplaceActorResult.ERROR;

        for (Actor actor : actors) {
            if (actor.getSurname().equals(surnameOfOldActor)) {
                replacedOldActor = actor;
                break;
            }
        }
        if (replacedOldActor == null)
            return ReplaceActorResult.OLD_ACTOR_NOT_FOUND;

        if (actors.contains(newActor))
            return ReplaceActorResult.NEW_ACTOR_ALREADY_EXIST;

        actors.remove(replacedOldActor);
        addActor(newActor);

        return ReplaceActorResult.SUCCESS;
    }

    public static String getMessageIfActorExist(Actor newActor) {
        if (newActor.getGender() == Genders.MALE)
            return "Актер " + newActor + " уже участвует в постановке. Проверьте вводимые данные";
        else
            return "Актриса " + newActor + " уже участвует в постановке. Проверьте вводимые данные";
    }

    public static String getMessageIfSuccessReplace(Actor newActor, Actor oldActor) {
        String output = "";
        if (oldActor.getGender() == Genders.MALE)
            output += "Актер " + oldActor + " успешно заменен на";
        else
            output += "Актриса " + oldActor + " успешно заменена на";

        if (newActor.getGender() == Genders.MALE)
            output += " актера " + newActor;
        else
            output += " актрису " + newActor;
        return output;
    }

    //Getters and Setters=====================================
    public Director getDirector() {
        return director;
    }

    public boolean setDirector(Director director) {
        if (director == null) {
            return false;
        }

        this.director = director;
        return true;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public String getTitle() {
        return title;
    }

    public boolean setTitle(String title) {
        if (title == null)
            return false;

        this.title = title;
        return true;
    }

    public int getDuration() {
        return duration;
    }

    public boolean setDuration(int duration) {
        if (duration < 0)
            return false;

        this.duration = duration;
        return true;
    }

    public Actor getReplacedOldActor() {
        return replacedOldActor;
    }
    //=========================================================

    public void printDirector() {
        if (director == null) {
            System.out.println("Director = null");
            return;
        }

        System.out.println("Режиссер");
        System.out.println(director);
    }

    public void printActors() {
        if (actors == null || actors.isEmpty()) {
            System.out.println("Актеры пока не добавлены\n");
            return;
        }

        System.out.println("Актерский состав: ");
        System.out.println(actors + "\n");
    }
}
