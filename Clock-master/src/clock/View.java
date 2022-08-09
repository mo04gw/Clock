package clock;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.Observer;
import java.util.Observable;
import java.util.Calendar;
import queuemanager.PriorityQueue;
import queuemanager.SortedArrayPriorityQueue;


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
 */

public class View implements Observer {
    
    ClockPanel panel;
    //Global buttons to be called from ActionEvent
    private JButton buttonAdd, buttonRemove;
    private MyActionListener act;
    JFrame frame = new JFrame();
    //Initializing Priority Queue
    queuemanager.SortedArrayPriorityQueue priority = new SortedArrayPriorityQueue<>(8);
   
    
    public View(Model model) {
        
        //Menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu addMenu = new JMenu("Add");
        JMenu editMenu = new JMenu("Edit");
        JMenu closeMenu = new JMenu("Exit");
        
        //Menu Items
        JMenuItem addAlarm = new JMenuItem("Add new Alarm");
        JMenuItem editAlarm = new JMenuItem("Edit Alarm");
        JMenuItem deleteAlarm = new JMenuItem("Delete Alarm");
        JMenuItem close = new JMenuItem("Exit Program");
        
        //Adding to Menu items options
        addMenu.add(addAlarm);
        editMenu.add(editAlarm);
        editMenu.add(deleteAlarm);
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
        frame.setSize(600,500);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setJMenuBar(menuBar);

        //JPanels to create the colour around the clock + buttons
        JPanel panel_top= new JPanel();
        JPanel panel_left = new JPanel();
        JPanel panel_right = new JPanel();
        //JPanel panel_bottom = new JPanel();
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
        //panel_bottom.setPreferredSize(new Dimension(100, 100));
        panel_centre.setPreferredSize(new Dimension(200, 200));
        
        //Buttons style
        btns.setBackground(new Color(0xcbd7df));
        btns.setBounds(80,30, 120, 40);
        btns.setFont(new Font("Calibri", Font.BOLD, 25));
        
        //Buttons alarm
        //Based on the algorithm of Choobtorials (see list of references top of the page)
        //
        buttonAdd = new JButton("Add Alarm");
        buttonRemove = new JButton("Remove Alarm");
        act = new MyActionListener();
        buttonAdd.addActionListener(act);
        buttonRemove.addActionListener(act);
        
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
        frame.pack();
        
        
    }
    
    //Alarm settings (asking from user)
    public void userInput(ActionEvent e){
        JTextField nameAlarm = new JTextField(10);
        
    }
    
    public void update(Observable o, Object arg) {
        panel.repaint();
    }

    private void setJMenuBar(JMenuBar menuBar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //Reference: Part 8 | Creating one ActionListener for Multiple Buttons using ActionEvent | Java GUI Tutorial - https://www.youtube.com/watch?v=OI-TFbHQhtA
    //Listen for events, implemented after adding the buttons
    private class MyActionListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == buttonAdd){
            System.out.println("Add Alarm");
        }else if(e.getSource()== buttonRemove){
             System.out.println("Delete Alarm");   
            }
    }}
}
