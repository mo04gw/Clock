package clock;

import java.awt.event.*;
import javax.swing.Timer;

public class Controller {
    
    ActionListener listener;
    Timer timer;
    
    Model model;
    View view;
    
    public Controller(Model m, View v) {
        model = m;
        view = v;
        
        listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.update();
            }
        };
        
        //Changed to 1000 ms. Reference: " Java Timer Thread Operation, question asked by 'jashdf' " , Stack Overflow, 29-10-2019, [online] Accessed: 15/08/2022
        timer = new Timer(1000, listener);
        timer.start();
    }
}