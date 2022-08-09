/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clock;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
    String name;

    public Alarm(String name, int min, int hours, int priority) {
        priority = this.priority;
        hours = this.hours;
        min = this.min;
        name = this.name;
        SimpleDateFormat  dt = new SimpleDateFormat("hh:mm"); 

    }

    //Getters and Setters for each attribute: priority, hours, minutes and name of the alarm
    public int getPriority() {
        return priority;
    }

    public int getHours() {
        return hours;
    }

    public int getMin() {
        return min;
    }

    public String getName() {
        return name;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    //https://stackoverflow.com/questions/14922782/convert-string-date-to-alarm
    
    public void AddAlarm(){
    
    //Date date=  dt.parse(str); // GET TIME HERE
    //Calendar cal=Calendar.getInstance();
    //cal.setTime(date);
    //String hours=cal.get(Calendar.HOUR);
    //String minutes=cal.get(Calendar.MINUTE);
    }
    
    
}
