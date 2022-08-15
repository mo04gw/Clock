package clock;




import java.util.Observable;
//import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import queuemanager.QueueOverflowException;
import queuemanager.QueueUnderflowException;
import queuemanager.SortedArrayPriorityQueue;

public class Model extends Observable {

    //Adding the maximum of capacity of the queue to store alarms
    private static final int MAX_ALARM_COUNT = 5;

    int hour = 0;
    int minute = 0;
    int second = 0;
    int oldSecond = 0;
    
    //Initializing SortedArrayPriorityQueue
    SortedArrayPriorityQueue<Alarm> queue;

    public Model() {
        queue = new SortedArrayPriorityQueue<Alarm>(MAX_ALARM_COUNT);
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

            //Test checking observer and changes
            // System.out.println("changed...");
        }

    }

    public void addAlarm(Date alarmDate) throws QueueOverflowException {
        Alarm alarm = new Alarm(alarmDate);
        //long priority = alarmDate.getTime() % 1000;

        System.out.println("alarmDate.getTime(): " + alarmDate.getTime());

        Calendar date = Calendar.getInstance();
        date.setTime(alarmDate);

        int year = date.get(Calendar.YEAR);
        int dayOfYear = date.get(Calendar.DAY_OF_YEAR);
        hour = date.get(Calendar.HOUR);
        minute = date.get(Calendar.MINUTE);
        //Calculate the priority by multiplying time components
        int intPriority = year * dayOfYear * hour * minute;

        //The Later the time higher the priority.
        //So, the latest will be the head of queue.
        //BUT, we need the earliest as head of queue.
        //Hence, we need to NEGATHE priority
        //negate the priority so that the earliest time appears in the head
        //Example:
        //Usual Priority order  starting from head: 9 8 7
        //Negated Priority order starting from head: -7 -8 -9
        //This results in later in time to 
        intPriority = -1 * intPriority;

        queue.add(alarm, intPriority);
        // System.out.println("------------------------");
        System.out.println(queue);
        // System.out.println("------------------------");
    }

    //Try to get the next alarm, if it doesn't find it, return null
    public Alarm nextAlarm() {
        try {
            return queue.head();
        } catch (QueueUnderflowException ex) {
            System.out.println("No Alarms found.");
            return null;
        }
    }

    public void removeAlarm() throws QueueUnderflowException {
       
            if (!queue.isEmpty()) {
                queue.remove();
            } else {
                JOptionPane.showMessageDialog(null, "No Alarm found! ", "No alarm on the queue", JOptionPane.WARNING_MESSAGE);
            
            }
            
    }

}
