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

//https://codereview.stackexchange.com/questions/47921/alarm-clock-with-ringing-functionality


public class View implements Observer {
    
    ClockPanel panel;
    //Container pane;
    //Global buttons to be called from ActionEvent
    private JButton buttonAdd;
    private JButton buttonRemove;
    private MyActionListener act;

    
    public View(Model model) {
        
        
        JFrame frame = new JFrame();
        //Menu bar
        JMenuBar menuBar;
        JMenu menu;
        //JPanel Clock
        panel = new ClockPanel(model);
        
        //Adding a JPanel containing buttoms, as we cannot add two items to the same BorderLayout
        JPanel btns = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        menuBar = new JMenuBar();
        menu = new JMenu("Test");
        menu.getAccessibleContext().setAccessibleDescription("Menu2");
        menuBar.add(menu);
        //frame.setMenuBar(menuBar);
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Java Clock");
        frame.setSize(600,500);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
     

        JPanel panel_top= new JPanel();
        JPanel panel_left = new JPanel();
        JPanel panel_right = new JPanel();
        //JPanel panel_bottom = new JPanel();
        JPanel panel_centre = panel;
       
        //Panel color
        panel_top.setBackground(new Color(0xcbd7df));
        panel_left.setBackground(new Color(0xcbd7df));
        panel_right.setBackground(new Color(0xcbd7df));
        
        //Panel dimension
        panel_top.setPreferredSize(new Dimension(100, 50));
        panel_left.setPreferredSize(new Dimension(100, 100));
        panel_right.setPreferredSize(new Dimension(100, 100));
        //panel_bottom.setPreferredSize(new Dimension(100, 100));
        panel_centre.setPreferredSize(new Dimension(200, 200));
        
        //Buttons styles!
        btns.setBackground(new Color(0xcbd7df));
        btns.setBounds(80,30, 120, 40);
        btns.setFont(new Font("Calibri", Font.BOLD, 25));
        
        //Buttons alarm
        //Based on the algorithm of Choobtorials
        //Choobtorials, Java GUI Tutorial Part 2 - Creating an Event Handler - https://www.youtube.com/watch?v=cyZzPo0ssp8 (18/02/2019) 
        buttonAdd = new JButton("Add Alarm");
        buttonRemove = new JButton("Remove Alarm");
        act = new MyActionListener();
        buttonAdd.addActionListener(act);
        buttonRemove.addActionListener(act);
        
        //Adding the listener to the button
        btns.add(buttonAdd);
        btns.add(buttonRemove);
        
        //btns.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        
        frame.add(panel_top, BorderLayout.NORTH);
        frame.add(panel_left, BorderLayout.WEST);
        frame.add(panel_right, BorderLayout.EAST);
        frame.add(btns, BorderLayout.SOUTH);
        frame.add(panel_centre, BorderLayout.CENTER);
        //frame.setContentPane(panel);
        frame.pack();
    }
    
    public void update(Observable o, Object arg) {
        panel.repaint();
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
