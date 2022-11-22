package Part4;

import Part3.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyClock extends JLabel implements Runnable, MouseListener{
    private JButton bn1;
    
    public MyClock(){
        
        this.addMouseListener(this);
        
        
    }
    
    boolean stop = false;
    
    public void run(){
        int sec = 0;
        int min = 0;
        int hour = 0;
        
        while (true){
            if (stop == false){
                sec += 1;
            }
            if (sec == 60){
                min += 1;
                sec = 0 ;
            }
            if (min == 60){
                hour += 1;
                min = 0;
            }
            
           
            setFont(new Font("Serif", Font.BOLD, 50));
            
            setText(addZero(hour) + " : " + addZero(min) + " : " + addZero(sec));
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyClock.class.getName()).log(Level.SEVERE, null, ex);
            }
            
//            this.addActionListener(this);
            
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

    
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource().equals(pn1)){
//            stop = true;
//        }
//    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == this){
            if (stop == true){
                stop = false;
            }
            else{
                stop = true;
            }
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
