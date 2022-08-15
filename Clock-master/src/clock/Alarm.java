package clock;

import java.text.DateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author heidi
 *
 * @notes: Class Alarm, stores alarm information.
 */
public class Alarm implements Observer {

    Date alarmDateTime;

    DateFormat dateFormat;
    DateFormat dateFormatPriority;
    int hours;
    int min;
    int priority;

    public Alarm(Date date) {
        this.alarmDateTime = date;

//        dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        //datePriority = new SimpleDateFormat("HHmmddMMyyyy");
//
//        String pattern = "MM-dd-yyyy";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        System.out.println("date" + date);
        //References https://stackoverflow.com/questions/25811650/trying-to-compare-date-picker-time-to-current-time-ios
        //if ([date.DatePicker.date compare:(new Date())] == NSOrderedDescending) {
        //System.out.print("We have a problem");
        //}
    }

    public Date getDate() {
        return alarmDateTime;
    }

    @Override
    public void update(Observable o, Object arg) {

        System.out.println("alarm arg: " + arg);
        if (arg == null) {
            return;
        }
        System.out.println("alarm arg class name: " + arg.getClass().getName());
        System.out.println("");

        if (arg == null) {
            return;
        }
        Date currentDateTime = (Date) arg;
        //Test on the console, trying to fix de difference beween current time and time of the alarm
        //System.out.println("currentDateTime: " + currentDateTime);
        //System.out.println("alarmDateTime: " + alarmDateTime);
        if (alarmDateTime.equals(currentDateTime) || alarmDateTime.after(currentDateTime)) {

            //Tests on the console
            //   System.out.println("******************* ");
            //  System.out.println("Its time: " + alarmDateTime);
            //  System.out.println("******************* ");
        }
        //System.out.println("---------------------");

    }

    //Returning to String the alarm Date Time (similar to priority queue)
    @Override
    public String toString() {
        return "Alarm{" + "alarmDateTime=" + alarmDateTime + '}';
    }

}
