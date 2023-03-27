package yang;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class Begin extends JFrame implements MouseListener{
    JLabel start;//?????????
    public Begin(){
        start=new JLabel(new ImageIcon("images/???.jpg"));
        start.setBounds(100,500,170,75);
        start.addMouseListener(this);
        this.add(start);
        JLabel panel=new JLabel();
        JLabel background = new JLabel(new ImageIcon("images/????1.jpg"));
        background.setLocation(0, 0);
        background.setSize(390, 650);
        panel.add(background);
        this.add(panel);
        this.setTitle("???????");
        this.setSize(400,680);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Begin();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //?????
        if(e.getSource().equals(start)) {
            //????????????
            new Yang().setVisible(true);
            // ?????????
            dispose();
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
