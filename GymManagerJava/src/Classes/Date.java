package Classes ;

import java.io.Serializable;

public class Date implements Serializable {
    private int year;
    private int month;
    private int day;

    public Date (){
        this.day = 0;
        this.month = 0;
        this.year = 0;
    }

    public Date(int day, int month, int year) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Date(Date d) {
        this.year = d.year;
        this.month = d.month;
        this.day = d.day;
    }

    @Override
    public String toString() {
        return "Classes.Date{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }


}

