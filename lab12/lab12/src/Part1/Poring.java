import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Poring extends JFrame implements Runnable,MouseListener{
    private JFrame window;
    private JTextField number;
    private JLabel poringLabel;
    public Poring(int numberOfPoring){
        window = new JFrame();
        number = new JTextField(numberOfPoring+"");
        poringLabel = new JLabel(new ImageIcon("Poring.jpg"));
        
        number.setEditable(false);
        number.setBorder(null);
        number.setFont(new Font("Tahoma",Font.BOLD, 14));
        
        window.setLayout(new FlowLayout());
        window.add(poringLabel);    window.add(number);

        poringLabel.addMouseListener(this);
        
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        window.setSize(170,135);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation((int)(Math.random()*(dimension.getWidth()-window.getWidth())), (int)(Math.random()*(dimension.getHeight()-window.getHeight())));
        window.setResizable(false);
        window.setVisible(true);
    }

    public void run(){
        try{
            while(true){
                Thread.sleep(30);
                if(Math.random()<=0.5){
                    if(Math.random()<=0.5){
                        window.setLocation(window.getX()+2, window.getY()+2);
                    }else{
                      window.setLocation(window.getX()-2, window.getY()-2);  
                    }
                }else{
                    if(Math.random()<=0.5){
                        window.setLocation(window.getX()+2, window.getY()-2);
                    }else{
                      window.setLocation(window.getX()-2, window.getY()+2);  
                    }
                }
            }
        }catch(Exception e){
            System.out.print(e);
        }
        
    }
    
    public synchronized void mouseClicked(MouseEvent ev){}
    public void mouseEntered(MouseEvent ev){}
    public void mouseExited(MouseEvent ev){}
    public void mousePressed(MouseEvent ev){window.dispose();}
    public void mouseReleased(MouseEvent ev){}
}

--------------

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PoringConstructor implements ActionListener{
    int numberOfPoring = 0;
    private JButton addButton;
    private JFrame window;
    private Poring poring;
    public PoringConstructor(){
        addButton = new JButton("Add");
        window = new JFrame();
        
        addButton.addActionListener(this);
        
        window.setLayout(new FlowLayout());
        window.add(addButton);
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(170, 75);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource().equals(addButton)){
            numberOfPoring++;
            Poring poring = new Poring(numberOfPoring);
            Thread thread = new Thread(poring);
            thread.start();
        }
    }
}
