package clock;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.Observer;
import java.util.Observable;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import queuemanager.QueueUnderflowException;

/* 

 * @author: heidi
 * @Notes: I am importing SortedArrayPriorityQueue from Priory Queue (jar) to store the alarms
 * All the GUI interface that I tried to improved, came from the 'Java GUI by Bro Code' tutorial 
 *
 * @References: 
 * --> " How to Use Menus, The Java Tutorials, Oracle, n.d., [online] Available at: https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html, (Accessed: 02/08/2022)" 
 * --> " 'Alarm clock with "ringing" functionality' by Jamal | CodeReview, StackExchange, 22 Apr. 2014, [online] Available at: https://codereview.stackexchange.com/questions/47921/alarm-clock-with-ringing-functionality (Accessed: 05/08/2022)".
 * --> " Choobtorials, Java GUI Tutorial Part 2 - Creating an Event Handler, 18 Feb. 2019, -[online]- Available at:  https://www.youtube.com/watch?v=cyZzPo0ssp8 ,(Accessed: 02/08/2022)"
 * --> " Java GUI by Bro Code, YouTube, 14 Sep. 2020, [online] Available at: https://www.youtube.com/watch?v=Kmgo00avvEw (Accessed: 02/08/2022)" 
 * --> " Java Custom SpinnerDateModel to edit only hour and minute , Answered by MadProgrammer, Stack Overflow, 16 Feb. 2018, [online] Available at: https://stackoverflow.com/questions/48834383/java-custom-spinnerdatemodel-to-edit-only-hour-and-minute (Accessed: 08/08/2022)"
 */
public class View implements Observer {

    ClockPanel panel;
    //Global buttons to be called from ActionEvent
    private JButton buttonAdd, buttonRemove;
    private MyActionListener action;
    private int size;
    JFrame frame;
    Calendar calendar;

    //Declaring parameters to be used in Alarm.java later & userInput to get the time to set the alarm for the user
    String name;
    int hours;
    int min;

    NewAlarmDialog newAlarm;
    private final Model model;

    public View(Model model) {

        this.model = model;

        frame = new JFrame();
        calendar = Calendar.getInstance();
        //sortedArrayPriorityQueue = new SortedArrayPriorityQueue(size);

        //Menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu addMenu = new JMenu("Add");
        JMenu editMenu = new JMenu("Edit");
        JMenu closeMenu = new JMenu("Exit");

        //Menu Items
        JMenuItem menuAddAlarm = new JMenuItem("Add new Alarm", 'A');
        JMenuItem editAlarm = new JMenuItem("Edit Alarm", 'E');
        JMenuItem menuDeleteAlarm = new JMenuItem("Delete Alarm", 'D');
        JMenuItem close = new JMenuItem("Exit Program", 'X');

        //Adding to Menu items options
        addMenu.add(menuAddAlarm);
        editMenu.add(editAlarm);
        editMenu.add(menuDeleteAlarm);
        closeMenu.add(close);

        //Assigning each Menu Bar to each option
        menuBar.add(addMenu);
        menuBar.add(editMenu);
        menuBar.add(closeMenu);

        //JPanel Clock
        panel = new ClockPanel(model);

        //Frame set up
        //SetDefaultCloseOperation could be changed to DO_NOTHING_ON_CLOSE in the case of storing or making proper use of the Alarm function
        //Reference of it: https://www.clear.rice.edu/comp310/JavaResources/frame_close.html
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Java Clock");
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setJMenuBar(menuBar);

        //JPanels to create the colour around the clock + buttons
        JPanel panel_top = new JPanel();
        JPanel panel_left = new JPanel();
        JPanel panel_right = new JPanel();
        JPanel panel_bottom = new JPanel();
        JPanel panel_centre = panel;
        //Adding a JPanel containing buttoms, as we cannot add two items to the same BorderLayout
        JPanel btns = new JPanel(new FlowLayout(FlowLayout.CENTER));

        //Panel colour
        panel_top.setBackground(new Color(0xcbd7df));
        panel_left.setBackground(new Color(0xcbd7df));
        panel_right.setBackground(new Color(0xcbd7df));

        //Panel dimensions
        panel_top.setPreferredSize(new Dimension(100, 50));
        panel_left.setPreferredSize(new Dimension(100, 100));
        panel_right.setPreferredSize(new Dimension(100, 100));
        panel_bottom.setPreferredSize(new Dimension(100, 100));
        panel_centre.setPreferredSize(new Dimension(200, 200));

        //Buttons style
        btns.setBackground(new Color(0xcbd7df));
        btns.setBounds(80, 30, 120, 40);
        btns.setFont(new Font("Calibri", Font.BOLD, 25));

        //Buttons alarm
        //Based on the code of Choobtorials (see list of references top of the page)
        //
        buttonAdd = new JButton("Add Alarm");
        buttonRemove = new JButton("Remove Alarm");
        action = new MyActionListener();
        buttonAdd.addActionListener(action);
        buttonRemove.addActionListener(action);

        //Action Listener for menu items
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuAddAlarm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAlarm(e);
            }
        });

        menuDeleteAlarm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAlarm();
            }
        });

        //Adding the listener to the button
        btns.add(buttonAdd);
        btns.add(buttonRemove);

        //btns.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        //BorderLayout
        frame.add(panel_top, BorderLayout.NORTH);
        frame.add(panel_left, BorderLayout.WEST);
        frame.add(panel_right, BorderLayout.EAST);
        frame.add(btns, BorderLayout.SOUTH);
        frame.add(panel_centre, BorderLayout.CENTER);
        //frame.setContentPane(panel);

        //JComboBox comboBox = new JComboBox();
        frame.pack();

    }

    //References: https://www.youtube.com/watch?v=VL4hNtBQZuU
    public void createAlarm(ActionEvent e) {

        NewAlarmDialog alarm = new NewAlarmDialog(frame, model);
        alarm.setVisible(true);

        /*     try {
            sortedArrayPriorityQueue.add(alarm, 0);
        } catch(QueueOverflowException queueOverflowException) {
            queueOverflowException.printStackTrace();
        }
         */
    }

    private void deleteAlarm() {
        System.out.println("Delete Alarm");

        model.removeAlarm();
        JOptionPane.showMessageDialog(frame, "Removed the Next alarm.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
    }

    //Reference: Part 8 | Creating one ActionListener for Multiple Buttons using ActionEvent | Java GUI Tutorial - https://www.youtube.com/watch?v=OI-TFbHQhtA
    //Listen for events, implemented after adding the buttons
    private class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == buttonAdd) {

                System.out.println("Add Alarm");
                createAlarm(e);

            } else if (e.getSource() == buttonRemove) {
                deleteAlarm();

            }/*else if (e.getSource() == menuAddAlarm) {
                System.out.println("menuAddAlarm");
            }*/
        }
    }

    public void update(Observable o, Object arg) {
        panel.repaint();
        verifyAlarmTime();

    }

    private boolean verifyAlarmTime() {
        Alarm nextAlarm = model.nextAlarm();
        if (nextAlarm == null) {
            return false;
        }
        System.out.println("nextAlarm: " + nextAlarm);

        Date alarmDateTime = nextAlarm.getDate();
        if (alarmDateTime == null) {
            return false;
        }

        Date currentDateTime = new Date();
        System.out.println("currentDateTime: " + currentDateTime);
        System.out.println("alarmDateTime: " + alarmDateTime);
        //if current time >= this alarm, ring bell.
        if (currentDateTime.equals(alarmDateTime) || currentDateTime.after(alarmDateTime)) {
            model.removeAlarm();
            JOptionPane.showMessageDialog(null, "Its time: " + alarmDateTime);
            System.out.println("******************* ");
            System.out.println("VIEW...... >> Its time: " + alarmDateTime);
            System.out.println("******************* ");
        }
        System.out.println("---------------------");
        return false;

    }

}
