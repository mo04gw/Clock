package clock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Observable;
//import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import queuemanager.Person;
import queuemanager.PriorityQueue;
import queuemanager.QueueOverflowException;
import queuemanager.QueueUnderflowException;
import queuemanager.SortedArrayPriorityQueue;

public class Model extends Observable {

    private static final int MAX_ALARM_COUNT = 3;

    int hour = 0;
    int minute = 0;
    int second = 0;
    int oldSecond = 0;

    SortedArrayPriorityQueue<Alarm> q;

    public Model() {
        q = new SortedArrayPriorityQueue<Alarm>(MAX_ALARM_COUNT);
    }

    public void update() {
//        System.out.println("update...");
        Calendar date = Calendar.getInstance();
        hour = date.get(Calendar.HOUR);
        minute = date.get(Calendar.MINUTE);
        oldSecond = second;
        second = date.get(Calendar.SECOND);
        if (oldSecond != second) {
            setChanged();
            notifyObservers();

            System.out.println("changed...");
        }

    }

    public void addAlarm(Date alarmDate) throws QueueOverflowException {
        Alarm alarm = new Alarm(alarmDate);
        q.add(alarm, MAX_ALARM_COUNT - 1);
    }

    public Alarm nextAlarm() {
        try {
            return q.head();
        } catch (QueueUnderflowException ex) {
            System.out.println("No Alarms found.");
            return null;
        }
    }

    public void removeAlarm() {
        try {
            //remove alarm from the queue.
            q.remove();
        } catch (QueueUnderflowException ex) {

        }
    }

}
