import Shows.Ballet;
import Shows.MusicalShow;
import Shows.Opera;
import Shows.Show;
import Workers.*;


public class Theatre {
    private static final String SWAN_LAKE_LIBRETTO = "Либретто для лебединого озера";
    private static final String PRINCE_IGOR_LIBRETTO = "Либретто для \"Князя Игоря\"";

    public static void main(String[] args) {
        Actor actor1 = new Actor("Михаил", "Царев", Genders.MALE, 174);
        Actor actor2 = new Actor("Игорь", "Ильинский", Genders.MALE, 172);
        Actor actor3 = new Actor("Ольга", "Андровская", Genders.FEMALE, 165);

        Director director1 = new Director("Константин", "Станиславский", Genders.MALE, 45);
        Director director2 = new Director("Владимир", "Немирович-Данченко", Genders.MALE, 30);

        Person authorOfMusic = new Person("Пётр", "Чайковский", Genders.MALE);

        Person choreographer = new Person("Мариус", "Петипа", Genders.MALE);

        Show dramaticShow = new Show("Горе от ума", 180, director1);
        MusicalShow ballet = new Ballet("Лебединое озеро", 155, director2, SWAN_LAKE_LIBRETTO, authorOfMusic, choreographer);
        MusicalShow opera = new Opera("Князь Игорь", 210, director1, PRINCE_IGOR_LIBRETTO, authorOfMusic, 15);

        System.out.println("=======================================Dramatic Show=======================================");
        addActor(dramaticShow, actor1);
        addActor(dramaticShow, actor2);
        addActor(dramaticShow, actor3);
        addActor(dramaticShow, actor3); //for test

        System.out.println("=======================================Ballet Show=======================================");
        addActor(ballet, actor1);
        addActor(ballet, actor2);
        addActor(ballet, actor3);

        System.out.println("=======================================Opera Show=======================================");
        addActor(opera, actor1);
        addActor(opera, actor3);

        System.out.println("=======================================Dramatic Show=======================================");
        dramaticShow.printActors();

        System.out.println("=======================================Ballet Show=======================================");
        ballet.printActors();

        System.out.println("=======================================Opera Show=======================================");
        opera.printActors();

        replaceActor(opera, "Андровская", actor2);

        opera.printActors();

        System.out.println("=======================================Ballet Show=======================================");
        replaceActor(ballet, "Шаляпин", new Actor("Владимир", "Васильев", Genders.MALE, 178));

        System.out.println("=======================================Opera Show=======================================");
        opera.printLibretto();

        System.out.println("=======================================Ballet Show=======================================");
        ballet.printLibretto();
    }

    private static void setTitle(Show show, String title) {
        if (!show.setTitle(title)) {
            System.out.println("title = null");
            return;
        }

        System.out.println("Название установлено");
    }

    private static void setDuration(Show show, int duration) {
        if (show.setDuration(duration)) {
            System.out.println("Введена отрицательная длительность");
            return;
        }

        System.out.println("Длительность спектакля установлена");
    }

    private static void setNumberOfShows(Director director, int numberOfShows) {
        if (!director.setNumberOfShows(numberOfShows)) {
            System.out.println("Введено отрицательное количество постановок");
            return;
        }

        System.out.println("Количество постановок установлено");
    }

    private static void setLibretto(MusicalShow musicalShow, String libretto) {
        if (!musicalShow.setLibretto(libretto)) {
            System.out.println("libretto = null\n");
            return;
        }

        System.out.println("Либретто установлено\n");
    }

    private static void setAuthorOfMusic(MusicalShow musicalShow, Person authorOfMusic) {
        if (!musicalShow.setAuthorOfMusic(authorOfMusic)) {
            System.out.println("authorOfMusic = null!");
            return;
        }

        System.out.println("Композитор установлен");
    }

    private static void setChoirSize(Opera opera, int choirSize) {
        if (!opera.setChoirSize(choirSize))
            System.out.println("Введен отрицательный размер состава хора\n");

        System.out.println("Размер хора установлен\n");
    }

    private static void setDirector(Show show, Director director) {
        if (!show.setDirector(director)) {
            System.out.println("director = null");
            return;
        }

        if (director.getGender() == Genders.MALE)
            System.out.println("Режиссер " + director + " успешно добавлен\n");
        else
            System.out.println("Режиссер " + director + " успешно добавлена\n");
    }

    private static void setChoreographer(Ballet ballet, Person choreographer) {
        if (!ballet.setChoreographer(choreographer)) {
            System.out.println("choreographer = null");
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

    private static void replaceActor(Show show, String surnameOfOldActor, Actor newActor) {
        Show.ReplaceActorResult result = show.replaceActor(surnameOfOldActor, newActor);

        switch (result) {
            case SUCCESS:
                Actor oldActor = show.getReplacedOldActor();

                String output = Show.getMessageIfSuccessReplace(newActor, oldActor);
                System.out.println(output + "\n");
                break;
            case NEW_ACTOR_ALREADY_EXIST:
                System.out.println("Вы пытаетесь заменить уже существующего в составе человека");
                System.out.println(Show.getMessageIfActorExist(newActor) + "\n");
                break;
            case OLD_ACTOR_NOT_FOUND:
                System.out.println("Актера/актрисы с фамилией " + surnameOfOldActor + " нет. Проверьте вводимые данные\n");
                break;
            case ERROR:
                System.out.println("Ошибка: неверные входные параметры внутри бэкэнда\n");
                break;
        }
    }
}