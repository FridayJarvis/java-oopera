package Shows;

import java.util.ArrayList;

public class Opera extends MusicialShow{
    int choirSize;

    protected Opera(String title, int duration, String libretto, int choirSize) {
        super(title, duration, libretto);
        this.choirSize = choirSize;
    }

    public Opera(String title, int duration, int choirSize) {
        this(title, duration, "", choirSize);
    }

    public void setChoirSize(int newChoirSize) {
        choirSize = newChoirSize;
    }
}
