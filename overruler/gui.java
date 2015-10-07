/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package overruler;


import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.plaf.metal.MetalComboBoxUI;
//import javax.swing.plaf.metal.MetalComboBoxUI;
import socket.generalSocket;

/**
 *
 * @author kvmoffae
 */
public class gui extends javax.swing.JPanel {
    private ImageIcon[] images;
    private String[] userStrings = {"None", "abdel", "ann", "bernard", "cosmin", "david", "davids", "jonatan", "kevin", "kristof", "maarten", "matteo", "mike", "pasquale", "peter", "saba", "stijn", "tim", "yailen", "ym"};
    private String[] labels = {"Don't let this happen again", "I am not pleased", "Neutral", "I don't mind", "Saving energy is my only concern"};
    private JComboBox users;
    private generalSocket socket;
    private String machine = "134.184.26.153";
    private int port=1099;
    /**
     * Creates new form gui
     */
    public gui() {
        super(new BorderLayout());
        initComponents();
        
        
        // Load user list and images
        images = new ImageIcon[userStrings.length];
        Integer[] intArray = new Integer[userStrings.length];
        for (int i = 0; i < userStrings.length; i++) {
            intArray[i] = new Integer(i);
            images[i] = createImageIcon("images/" + userStrings[i] + ".png");
            if (images[i] != null) {
                images[i].setDescription(userStrings[i]);
            }
        }
        users = new JComboBox(intArray);
        Color bg = (Color) UIManager.get("ComboBox.background");
        Color fg = (Color) UIManager.get("ComboBox.foreground");
        UIManager.put("ComboBox.selectionBackground", bg);
        UIManager.put("ComboBox.selectionForeground", fg);
        users.setUI(new MetalComboBoxUI());
        //ComboBoxRenderer renderer = new ComboBoxRenderer();
        ComboBoxRenderer renderer= new ComboBoxRenderer(userStrings, images);
        renderer.setPreferredSize(new Dimension(650, 150));
        users.setRenderer(renderer);
        users.setSize(renderer.getPreferredSize());
        users.setMaximumRowCount(4);
        users.setBounds(150, 250, 650, 200);
        add(users);
        //setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
  
        
        // Set the user satisfaction labels
        jSlider1.setPaintTicks(true);
        Hashtable labelTable = new Hashtable();
        for (int i=0; i < labels.length; i++) {
            labelTable.put( new Integer( i ), new JLabel(labels[i]) );
        }

        jSlider1.setLabelTable( labelTable );

        jSlider1.setPaintLabels(true);
        
        socket = new generalSocket(machine, 1099);

        
        statusThread thread = new statusThread(socket, jLabel4);
        Thread theThread = new Thread(thread);
        theThread.start();
    }
    
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = gui.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
                return null;
        }
    }
    
    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy ");
        Date date = new Date();
        return dateFormat.format(date);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Manual override"));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Device's status:");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel2.setText("Who are you?");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel3.setText("How annoyed where you that the device is offline?");

        jSlider1.setMajorTickSpacing(1);
        jSlider1.setMaximum(4);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setValue(2);

        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jButton1.setText("Power on!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/overruler/images/off.png"))); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel2)
                                    .add(jLabel1))
                                .add(0, 695, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(6, 6, 6)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jSlider1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel3)
                                        .add(0, 282, Short.MAX_VALUE))
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .add(layout.createSequentialGroup()
                        .add(408, 408, 408)
                        .add(jLabel4)
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(24, 24, 24)
                .add(jLabel4)
                .add(22, 22, 22)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 266, Short.MAX_VALUE)
                .add(jLabel3)
                .add(18, 18, 18)
                .add(jSlider1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(92, 92, 92)
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        boolean status = socket.getstatus();
        if (users.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "No user selected" , "Status message", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
        
            if (status) {
                JOptionPane.showMessageDialog(null, "The device is already powered on" , "Status message", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                socket.turnOn();
                Icon theIcon = new ImageIcon(gui.class.getResource("images/on.png"));
                jLabel4.setIcon(theIcon);
                System.out.println("Manual override by " + userStrings[users.getSelectedIndex()] + " at " + getDateTime() + ", feeling: " + labels[jSlider1.getValue()]);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
}