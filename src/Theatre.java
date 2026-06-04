import Shows.Ballet;
import Shows.MusicialShow;
import Shows.Opera;
import Shows.Show;
import Workers.*;


public class Theatre {
    private static final String SWAN_LAKE_LIBRETTO = "Либретто для лебединого озера";
    private static final String PRINCE_IGOR_LIBRETTO = "Либретто для \"Князя Игоря\"";


    public static void main(String[] args) {
        System.out.println("========================DRAMATIC===================================");

        Show show = new Show("Горе от ума", 180);

        Actor actor1 = new Actor("Михаил", "Царев", Genders.MALE, 174);
        Actor actor2 = new Actor("Игорь", "Ильинский", Genders.MALE, 172);
        Actor actor3 = new Actor("Ольга", "Андровская", Genders.FEMALE, 165);
        addActor(show, actor1);
        addActor(show, actor1); //for test
        addActor(show, actor2);
        addActor(show, actor3);

        Director director1 = new Director("Константин", "Станиславский", Genders.MALE, 45);
        Director director2 = new Director("Владимир" , "Немирович-Данченко", Genders.MALE, 30);
        addDirector(show, director1);
        addDirector(show, director1); //for test
        addDirector(show, director2);

        printActorsOfShow(show);
        printActorsOfShow(show);

        System.out.println("\n=================================BALLET==================================\n");

        MusicialShow ballet = new Ballet("Лебединое озеро", 155, SWAN_LAKE_LIBRETTO);
        printActorsOfShow(ballet); //for test

        Actor actor4 = new Actor("Сергей", "Лемешев", Genders.MALE, 167);
        Actor actor5 = new Actor("Сергей", "Лемешев", Genders.MALE, 168);
        addActor(ballet, actor1);
        addActor(ballet, actor4);
        addActor(ballet, actor5);

        addDirector(ballet, director1);
        addDirector(ballet, director2);

        AuthorOfMusic authorOfMusic1 = new AuthorOfMusic("Пётр", "Чайковский", Genders.MALE);
        addAuthorOfMusic(ballet, authorOfMusic1);
        addAuthorOfMusic(ballet, authorOfMusic1); //for test

        Choreographer choreographer1 = new Choreographer("Мариус", "Петипа", Genders.MALE);
        addChoreographer((Ballet) ballet, choreographer1);
        addChoreographer((Ballet) ballet, choreographer1); //for test

        printDirectorsOfShow(ballet);
        printActorsOfShow(ballet);
        printLibrettoOfMusicShow(ballet);

        System.out.println("\n=======================OPERA====================================\n");

        MusicialShow opera = new Opera("Князь Игорь", 210, 15);

        addActor(opera, actor1);
        addActor(opera, actor3);

        addDirector(opera, director1);

        addAuthorOfMusic(opera, new AuthorOfMusic("Александр", "Бородин", Genders.MALE));

        setLibretto(opera, PRINCE_IGOR_LIBRETTO);
        setChoirSize((Opera)opera, 23);

        printDirectorsOfShow(opera);
        printActorsOfShow(opera);
        printLibrettoOfMusicShow(opera);

        System.out.println("\n=============================REPLACE ACTOR TEST========================\n");

        replaceActor(show, actor1, actor5);
        printActorsOfShow(show);

        replaceActor(show, actor1, actor5);
        replaceActor(show, actor5, actor2);
        replaceActor(show, actor5, actor5);
        replaceActor(show, actor4, actor4);
    }

    private static void setLibretto(MusicialShow musicialShow, String libretto) {
        musicialShow.setLibretto(libretto);
        System.out.println("Либретто установлено\n");
    }

    private static void setChoirSize(Opera opera, int newChoirSize) {
        opera.setChoirSize(newChoirSize);
        System.out.println("Размер хора установлен\n");
    }

    private static void addChoreographer(Ballet ballet, Choreographer choreographer) {
        if (!ballet.addChoreographer(choreographer)) {
            System.out.println("Этот хореограф уже участвует в постановке\n");
            return;
        }

        if (choreographer.getGender() == Genders.MALE)
            System.out.println("Хореограф " + choreographer + " успешно добавлен");
        else
            System.out.println("Хореограф " + choreographer + " успешно добавлена");
    }

    private static void addAuthorOfMusic(MusicialShow musicialShow, AuthorOfMusic authorOfMusic) {
        if (!musicialShow.addAuthorOfMusic(authorOfMusic)) {
            if (authorOfMusic.getGender() == Genders.MALE)
                System.out.println(authorOfMusic + " уже добавлен\n");
            else
                System.out.println(authorOfMusic + " уже добавлена");
        }
    }

    private static void addActor(Show show, Actor actor) {
        if (!show.addActor(actor)) {
            System.out.println("Вы пытаетесь добавить уже существующего в составе человека");
            System.out.println(Show.getMessageIfActorExist(actor) + "\n");
            return;
        }

        if (actor.getGender() == Genders.MALE)
            System.out.println("Актер " + actor + " успешно добавлен в состав\n");
        else
            System.out.println("Актриса " + actor + " успешно добавлена в состав\n");
    }

    private static void addDirector(Show show, Director director) {
        if (!show.addDirector(director)) {
            System.out.println("Режиссер " + director + " уже возглавляет постановку. Проверьте вводимые данные\n");
            return;
        }

        if (director.getGender() == Genders.MALE)
            System.out.println("Режиссер " + director + " успешно добавлен\n");
        else
            System.out.println("Режиссер " + director + " успешно добавлена\n");
    }

    private static void replaceActor(Show show, Actor oldActor, Actor newActor) {
        Show.ReplaceActorResult result = show.replaceActor(oldActor, newActor);

        switch (result) {
            case SUCCESS:
                String output = "";
                if (oldActor.getGender() == Genders.MALE)
                    output += "Актер " + oldActor + " успешно заменен на";
                else
                    output += "Актриса " + oldActor + " успешно заменена на";

                if (newActor.getGender() == Genders.MALE)
                    output += " актера " + newActor;
                else
                    output += " актрису " + newActor;

                System.out.println(output + "\n");
                break;
            case NEW_ACTOR_ALREADY_EXIST:
                System.out.println("Вы пытаетесь заменить уже существующего в составе человека");
                System.out.println(Show.getMessageIfActorExist(newActor) + "\n");
                break;
            case OLD_ACTOR_NOT_FOUND:
                if (oldActor.getGender() == Genders.MALE)
                    System.out.println("Актера " + oldActor + " нет. Проверьте вводимые данные\n");
                else
                    System.out.println("Актрисы " + oldActor + " нет. Проверьте вводимые данные\n");
                break;
        }
    }

    private static void printActorsOfShow(Show show) {
        var actors = show.getActors();
        if (actors.isEmpty()) {
            System.out.println("Актеры пока не добавлены\n");
            return;
        }

        System.out.println("Актерский состав: ");
        System.out.println(show.getActors() + "\n");
    }

    private static void printDirectorsOfShow(Show show) {
        var directors = show.getDirectors();
        if (directors.isEmpty()) {
            System.out.println("У представления пока нет режиссера\n");
            return;
        }

        System.out.println("Режиссеры:");
        System.out.println(directors);
    }

    private static void printLibrettoOfMusicShow(MusicialShow musicialShow) {
        String libretto = musicialShow.getLibretto();
        if (libretto.isEmpty()) {
            System.out.println("У представления пока нет либретто\n");
            return;
        }
        System.out.println(libretto + "\n");
    }

    private static void printAuthorsOfMusicShow(MusicialShow musicialShow) {
        var authorsOfMusic = musicialShow.getAuthorsOfMusic();
        if (authorsOfMusic.isEmpty()) {
            System.out.println("Композиции пока не добавлены");
            return;
        }

        System.out.println("Авторы композиций:");
        System.out.println(musicialShow.getAuthorsOfMusic() + "\n");
    }
}
