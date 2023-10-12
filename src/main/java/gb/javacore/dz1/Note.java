package gb.javacore.dz1;

import java.time.LocalDateTime;

public class Note {
    private final String note;
    private final String datetime;

    public Note(String note) {
        this.note = note;
        datetime = setDatetime();
    }

    private String setDatetime() {
        LocalDateTime now = LocalDateTime.now();
        return String.format("%d.%d.%d %d:%d", now.getDayOfMonth(), now.getMonthValue(),
                now.getYear(), now.getHour(), now.getMinute());
    }

    @Override
    public String toString() {
        return datetime + " -> " + note;
    }
}
