/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import queuemanager.SortedArrayPriorityQueue;
import queuemanager.PriorityQueue;
import queuemanager.QueueOverflowException;

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
        System.out.println("currentDateTime: " + currentDateTime);
        System.out.println("alarmDateTime: " + alarmDateTime);
        //if current time >= this alarm, ring bell.
        if (alarmDateTime.equals(currentDateTime) || alarmDateTime.after(currentDateTime)) {
//            JOptionPane.showMessageDialog(null, "Its time: " + alarmDateTime);
            System.out.println("******************* ");
            System.out.println("Its time: " + alarmDateTime);
            System.out.println("******************* ");

        }
        System.out.println("---------------------");

    }

    @Override
    public String toString() {
        return "Alarm{" + "alarmDateTime=" + alarmDateTime + '}';
    }

}

//Date date=  dt.parse(str); // GET TIME HERE
//Calendar cal=Calendar.getInstance();
//cal.setTime(date);
//String hours=cal.get(Calendar.HOUR);
//String minutes=cal.get(Calendar.MINUTE);

