package Makaoui_esercizio_agenda;
import java.util.Calendar;

public class Evento {
    private String toDo;
    private Calendar date;
    private boolean allDay;
    private String where;

    public Evento(String toDo, Calendar date, String where, boolean allDay ) {
        this.toDo = toDo;
        this.date = date;
        this.where = where;
        this.allDay = allDay;
    }

    // set
    public void setToDo(String toDo) {
        this.toDo = toDo;
    }
    public void setDate(Calendar date) {
        this.date = date;
    }
    public void setWhere(String where) {
        this.where = where;
    }
    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    // get
    public String getToDo() {
        return toDo;
    }
    public Calendar getDate() {
        return date;
    }
    public String getWhere() {
        return where;
    }
    public boolean isAllDay() {
        return allDay;
    }

    @Override
    public String toString() {
        return "To-Do: " + toDo + ", Date: " + date.getTime() +
                ", Where: " + where + ", All Day: " + allDay;
    }

}
