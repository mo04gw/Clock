package clock;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.Observer;
import java.util.Observable;
import java.util.Calendar;
import java.util.Date;

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

    //Asks for parameters to set an alarm (asking from user to click button or menu add alarm)
    //Changed from View Class to -> NewAlarm (model)
    
    
    public NewAlarm(Model model) {
        GridLayout gridLayout = new GridLayout(0,2);
        jFrame = new JFrame("Add Alarm");
        date = new Date();
        this.model = model;
        //Defined in Model.java
        Container container = getContentPane();
        container.setLayout(gridLayout);
        
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        JSpinner spinner = new JSpinner(sm);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner, "HH:mm dd/MM/yyyy");
        spinner.setEditor(dateEditor);
        
    
        container.add(dateEditor);
        
        //panel.add(sm);
        
        JButton buttonAccept = new JButton("Set Alarm");
        JButton buttonCancel = new JButton("Cancel");
        JButton buttonClear = new JButton("Clear");

  

        container.add(buttonAccept);
        container.add(buttonCancel);
        container.add(buttonClear);

        // set the jframe size and location, and make it visible
        jFrame.setSize(600,500);
        jFrame.getContentPane().add(container);
        jFrame.setPreferredSize(new Dimension(400, 300));
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setVisible(true);
        System.out.println("----------------------------------->here");
        int abc = 5;

    }

    public void update(Observable o, Object o1) {

    }
    
    
    
    

}
