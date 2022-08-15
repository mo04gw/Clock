/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clock;

import java.text.DateFormat;
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

    SortedArrayPriorityQueue<NewAlarm> storedAlarm;
    Date date;
    Alarm alarm;
    DateFormat dateFormat;
    DateFormat dateFormatPriority;
    int hours;
    int min;
    int priority;
    

    public Alarm(Date date) {
        storedAlarm = new SortedArrayPriorityQueue(7);
        dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
        //datePriority = new SimpleDateFormat("HHmmddMMyyyy");
        this.date = date;
        
 
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        System.out.println("date" + date);
        
        
        alarm = new Alarm(date);
        
        if(!date.before(new Date())){
            long longPriority = Long.parseLong(dateFormatPriority.format(date));
        }
        
        //References https://stackoverflow.com/questions/25811650/trying-to-compare-date-picker-time-to-current-time-ios
        //if ([date.DatePicker.date compare:(new Date())] == NSOrderedDescending) {
        //System.out.print("We have a problem");
        //}
    }
    
    public Date getDate(){
        return date;
    }
    
    
        
        //alarm = new Alarm(datetime);
      /*  if (datetime.after(new Date())){
            long longPriority = Long.parseLong(dateFormat.format(datetime));
            String stringPriority =String.valueOf(longPriority);
            storedAlarm.add(stringPriority, priority);*/
            
        
        
       
    }
    
    //Date date=  dt.parse(str); // GET TIME HERE
    //Calendar cal=Calendar.getInstance();
    //cal.setTime(date);
    //String hours=cal.get(Calendar.HOUR);
    //String minutes=cal.get(Calendar.MINUTE);
    
    
     
    

