package clock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Observable;
//import java.util.GregorianCalendar;
import queuemanager.PriorityQueue;
import queuemanager.QueueOverflowException;
import queuemanager.SortedArrayPriorityQueue;
import java.util.Calendar;
import java.util.Date;



public class Model extends Observable {
    
    int hour = 0;
    int minute = 0;
    int second = 0;
    int oldSecond = 0;
    
    SortedArrayPriorityQueue<NewAlarm> sortedArrayPriorityQueue;
    
    Alarm alarm;
    
    public Model() {
        update();
    }
    
    public void update() {
        Calendar date = Calendar.getInstance();
        hour = date.get(Calendar.HOUR);
        minute = date.get(Calendar.MINUTE);
        oldSecond = second;
        second = date.get(Calendar.SECOND);
        if (oldSecond != second) {
            setChanged();
            notifyObservers();
        }
    }
    
    public void createAlarm(Date datetime){
        
        sortedArrayPriorityQueue = new SortedArrayPriorityQueue(8);
        
        //DateFormat date (HH:mm dd/MM/yyyy) (Input from newAlarm)
        DateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        //Formatting the date &time from the JSpinner
        
        
        
        
    }

}