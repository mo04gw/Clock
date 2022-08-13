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

    JFrame frameAdd = new JFrame("Add Alarm");
    Date date = new Date();

    //Asks for parameters to set an alarm (asking from user to click button or menu add alarm)
    //Changed from View Class to -> NewAlarm (model)
    
    
    public NewAlarm(Model model) {
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        JSpinner spinner = new JSpinner(sm);
        JSpinner.DateEditor de = new JSpinner.DateEditor(spinner, "HH:mm dd/MM/yyyy");

        JButton buttonAccept = new JButton("Set Alarm");
        JButton buttonCancel = new JButton("Cancel");
        JButton buttonClear = new JButton("Clear");

        JPanel panel = new JPanel();

        panel.add(buttonAccept);
        panel.add(buttonCancel);
        panel.add(buttonClear);
        frameAdd.getContentPane().add(panel);

        frameAdd.pack();
        frameAdd.setLocationRelativeTo(null);
        frameAdd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameAdd.setVisible(true);

    }

    public void update(Observable o, Object o1) {

    }

}
