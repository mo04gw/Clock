/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clock;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import queuemanager.SortedArrayPriorityQueue;
import queuemanager.PriorityQueue;
import queuemanager.QueueOverflowException;


/**
 *
 * @author heidi 
 * 
 * @notes: Class Alarm, stores alarm information.
 */
public class Alarm {

    int hours;
    int min;
    int priority;
    
    SortedArrayPriorityQueue<NewAlarm> sortedArrayPriorityQueue;
    Alarm alarm;

    public Alarm(Date alarm) {
       
        SimpleDateFormat  dt = new SimpleDateFormat("hh:mm"); 

    }

  
    
    //https://stackoverflow.com/questions/14922782/convert-string-date-to-alarm
    
    public void AddAlarm(){
    
    //Date date=  dt.parse(str); // GET TIME HERE
    //Calendar cal=Calendar.getInstance();
    //cal.setTime(date);
    //String hours=cal.get(Calendar.HOUR);
    //String minutes=cal.get(Calendar.MINUTE);
    }
    
       public void createAlarm(Date datetime) {

        //new alarm object
        alarm = new Alarm(datetime);
        sortedArrayPriorityQueue = new SortedArrayPriorityQueue(3);

        //DateFormat date (HH:mm dd/MM/yyyy) (Input from newAlarm)
        //DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        //Formatting the date &time from the JSpinner

    }
    
}
