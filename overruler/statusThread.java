/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package overruler;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import socket.generalSocket;

/**
 *
 * @author kvmoffae
 */
public class statusThread implements Runnable{

    private boolean status = false;
    private JLabel label;
    private generalSocket socket;
    
    
    
    public statusThread(generalSocket socket, JLabel label) {
        this.socket = socket;
        this.label = label;
    }
    
    public boolean getStatus() {
        return status;
    }

    @Override
    public void run() {
        while (true) {
            try {
                status = socket.getstatus();
                //System.out.println("status = " + status);
                if (status) {
                    Icon theIcon = new ImageIcon(gui.class.getResource("images/on.png"));
                    label.setIcon(theIcon);
                }
                else {
                    Icon theIcon = new ImageIcon(gui.class.getResource("images/off.png"));
                    label.setIcon(theIcon);
                }
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(statusThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
