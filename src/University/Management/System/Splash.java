package University.Management.System;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Thread t;

    public Splash() {
        ImageIcon uni1 = new ImageIcon(ClassLoader.getSystemResource("Public/Uni.png"));
        Image uni2 = uni1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon uni3 = new ImageIcon(uni2);
        JLabel img = new JLabel(uni3);
        add(img);

        t = new Thread(this);
        t.start();
        setUndecorated(true);
        setVisible(true);

        int x = 1;
        for (int i = 2; i <= 600; i += 4, x += 1) {
            setLocation(600 - ((i + x) / 2), 350 - (i / 2));
            setSize(i + 2* x, (i + x) / 2);

            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public void run(){
        try{
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Splash();
    }
}
