package clock;

import java.awt.*;
import javax.swing.*;
import java.util.Observer;
import java.util.Observable;

public class View implements Observer {
    
    ClockPanel panel;
    //Container pane;

    
    public View(Model model) {
        
        JFrame frame = new JFrame();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Java Clock");
        frame.setSize(600,500);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        //JPanel Clock
        panel = new ClockPanel(model);

        JPanel panel_top= new JPanel();
        JPanel panel_left = new JPanel();
        JPanel panel_right = new JPanel();
        JPanel panel_bottom = new JPanel();
        JPanel panel_centre = panel;
       
        panel_top.setBackground(new Color(0x344765));
        panel_left.setBackground(new Color(0x344765));
        panel_right.setBackground(new Color(0x344765));
        panel_bottom.setBackground(new Color(0x344765));
        
        panel_top.setPreferredSize(new Dimension(100, 50));
        panel_left.setPreferredSize(new Dimension(100, 100));
        panel_right.setPreferredSize(new Dimension(100, 100));
        panel_bottom.setPreferredSize(new Dimension(100, 100));
        panel_centre.setPreferredSize(new Dimension(200, 200));
        
        frame.add(panel_top, BorderLayout.NORTH);
        frame.add(panel_left, BorderLayout.WEST);
        frame.add(panel_right, BorderLayout.EAST);
        frame.add(panel_bottom, BorderLayout.SOUTH);
        frame.add(panel_centre, BorderLayout.CENTER);
        
        
        //Buttons alarm
        JButton buttonAdd = new JButton("Add Alarm");
        panel_bottom.add(buttonAdd, BorderLayout.LINE_START);
        
        JButton buttonRemove = new JButton("Remove Alarm");
        panel_bottom.add(buttonAdd, BorderLayout.LINE_END);
        //frame.setContentPane(panel);
        
        //pane = frame.getContentPane();
        //pane.add(panel, BorderLayout.CENTER);
        //frame.setContentPane(panel);
        //frame.setContentPane(panel);
        /*
        //Buttons
        JButton button = new JButton("Button 1 (PAGE_START)");
        pane.add(button, BorderLayout.PAGE_START);
         
        button = new JButton("Button 3 (LINE_START)");
        pane.add(button, BorderLayout.LINE_START);
         
        button = new JButton("Long-Named Button 4 (PAGE_END)");
        pane.add(button, BorderLayout.PAGE_END);
         
        button = new JButton("5 (LINE_END)");
        pane.add(button, BorderLayout.LINE_END);
        */
        // End of borderlayout code
        frame.pack();
    }
    
    public void update(Observable o, Object arg) {
        panel.repaint();
    }
}
