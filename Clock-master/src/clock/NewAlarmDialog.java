package clock;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.Observer;
import java.util.Observable;
import java.util.Calendar;
import java.util.Date;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import queuemanager.QueueOverflowException;

/**
 *
 * @author heidi
 *
 * @update: NewAlarm is now in a different class to follow the
 * Model-View-Controller Architecture
 */
public class NewAlarmDialog extends JDialog {

    private final JFrame frame;

    Model model;
    Alarm alarm;
    Date date;
    JPanel jPanel;
    SpinnerDateModel dateModel;
    JSpinner jSpinner;
    JButton jButtonAdd;
    JButton jButtonCancel;
    SimpleDateFormat format;

    private MyActionListener action;


    //Asks for parameters to set an alarm (asking from user to click button or menu add alarm)
    //Changed from View Class to -> NewAlarm (model)
    //After pressing the button, it will check if the date or time selected are actually bigger than the actual date before setting the alarm
    
    
    public NewAlarmDialog(JFrame frame, Model model) {
        setTitle("Add Alarm");
        setModal(true);

        this.frame = frame;

        //references: https://stackoverflow.com/questions/21179770/jpinner-setmodel-not-allowing-to-change-value/21185580#21185580   - - https://docs.oracle.com/javase/8/docs/technotes/guides/swing/1.4/spinner.html
        this.model = model;
        //format = new SimpleDateFormat("HH:mm dd/MM/yyyy");

        this.setSize(200, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(400,100));

        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());

        jPanel = new JPanel();
        
        dateModel = new SpinnerDateModel();
        jSpinner = new JSpinner(dateModel);
        //JComponent editor = JSpinner.DateEditor(jSpinner, format.toPattern());
        jSpinner.setEditor(new JSpinner.DateEditor(jSpinner, "HH:mm dd/MM/yyyy"));

       
        //Disable edition from keyboard, so the user cannot input '550' hours for example
        //double click in each field to change the time with the arrows is not clear either for an user?!
        JFormattedTextField formatedText = ((JSpinner.DefaultEditor) jSpinner.getEditor()).getTextField();
        formatedText.setEditable(false);
        formatedText.setEnabled(true);
        formatedText.setBackground(Color.white);

        container.add(new JLabel("Add alarm"));
        container.add(jSpinner);

        jButtonAdd = new JButton("Add Alarm");
        jButtonCancel = new JButton("Cancel");

        container.add(jButtonAdd);
        container.add(jButtonCancel);

        //Adding listeners to the buttons
        action = new MyActionListener();
        jButtonAdd.addActionListener(action);
        jButtonCancel.addActionListener(action);

        //Display the window
        this.pack();

        //System.out.println("----------------------------------->here");

    }
    
 
    //Reference: Part 8 | Creating one ActionListener for Multiple Buttons using ActionEvent | Java GUI Tutorial - https://www.youtube.com/watch?v=OI-TFbHQhtA
    //Listen for events, implemented after adding the buttons
    //https://stackoverflow.com/questions/30908303/i-cannot-close-jframe?noredirect=1&lq=1 (Dispose dialog box)
    private class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jButtonAdd) {

                try {
                    System.out.println("Add Alarm");
                    Date alarmDate = (Date) jSpinner.getValue();
                    JOptionPane.showMessageDialog(frame, "Alarm Added! Time of the alarm: " + alarmDate, "Alarm set", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("New Alarm Time: " + alarmDate);
//                    model.addObserver(new Alarm(alarmDate));
                    model.addAlarm(alarmDate);
                } catch (QueueOverflowException ex) {
                   JOptionPane.showMessageDialog(frame, "Max alarm limit reached.", "Error", JOptionPane.ERROR_MESSAGE);
                   return;
                }
                
                   
            } else if (e.getSource() == jButtonCancel) {
                //System.out.println("Cancel Alarm");
                
                NewAlarmDialog.this.dispose();
            }
        }
    }

    public void update(Observable o, Object o1) {

    }

}
