package Part2;

import java.util.Calendar;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyClock extends JLabel implements Runnable {
    
    public void run(){
        while (true){
            Calendar d = Calendar.getInstance();
            int sec = d.get(Calendar.SECOND);
            int min = d.get(Calendar.MINUTE);
            int hour = d.get(Calendar.HOUR_OF_DAY);
            
            setFont(new Font("Serif", Font.BOLD, 50));
            
            setText(addZero(hour) + " : " + addZero(min) + " : " + addZero(sec));
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyClock.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }
        

        
        
    }
    
    public String addZero(int num){
        String out;
        if (num < 10){
            out = "0" + num;
        }
        else{
            out = num+"";
        }
        return out;
    }
}
