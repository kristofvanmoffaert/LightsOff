/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package overruler;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.lang.Thread;

/**
 *
 * @author kvmoffae
 */
public class MainFrame {

    public static void main(String[] args) {
        new Thread(new Runnable() {

            public void run() {
        JFrame frame = new JFrame("PERPETUAL Override Module");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new gui();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
            }
    }).start();
                }
}
