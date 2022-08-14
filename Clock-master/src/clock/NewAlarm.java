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

/**
 *
 * @author heidi
 * 
 * @update: NewAlarm is now in a different class to follow the Model-View-Controller Architecture
 */
public class NewAlarm extends JFrame {

    Model model;
    JFrame jFrame;
    Date date;
    JPanel jPanel;
    SpinnerDateModel dateModel;
    JSpinner jSpinner;
    JButton jButtonAdd;
    JButton jButtonCancel;
    
    //Asks for parameters to set an alarm (asking from user to click button or menu add alarm)
    //Changed from View Class to -> NewAlarm (model)
    
    
    public NewAlarm(Model model) {
 
        //references: https://stackoverflow.com/questions/21179770/jpinner-setmodel-not-allowing-to-change-value/21185580#21185580
        
        this.model = model;
        
        jFrame = new JFrame("Add Alarms");
        jFrame.setSize(400,300);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         jFrame.setPreferredSize(new Dimension(200, 200));
        
        Container container = jFrame.getContentPane();
        container.setLayout(new FlowLayout());
        
        jPanel = new JPanel();
 
        dateModel = new SpinnerDateModel();
        jSpinner = new JSpinner(dateModel);
        
        jSpinner.setEditor(new JSpinner.DateEditor(jSpinner, "hh:mm:ss dd/MM/yyyy"));
        container.add(new JLabel("Add alarm "));
        container.add(jSpinner);
        
        jButtonAdd = new JButton("Add Alarm");
        jButtonCancel = new JButton("Cancel");
        
        
        container.add(jButtonAdd);
        container.add(jButtonCancel);
        
        //Display the window
        jFrame.pack();

        System.out.println("----------------------------------->here");

    }

    public void update(Observable o, Object o1) {

    }

}
