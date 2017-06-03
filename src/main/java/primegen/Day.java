package primegen;

/**
 * Created with IntelliJ IDEA.
 * User: andy.lai
 * Date: 03/06/2017
 * Time: 3:02 PM
 */
public class Day {
    public int month;
    public int day;
    public Day(int month,int day){
        this.month=month;
        this.day=day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    public boolean isWomenDay(){
        return month==3&&day==8;
    }
    public boolean isChildenDay(){
        return month==6&&day==1;
    }
}
