/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author robocup
 */
public class generalSocket {

    protected Socket MyClient = null;
    protected DataOutputStream os = null;
    protected DataInputStream is = null;

    public generalSocket(String machine, int port) {
        try {
            MyClient = new Socket(machine, port);
            //MyClient.setSoTimeout(1000);
            os = new DataOutputStream(MyClient.getOutputStream());
            is = new DataInputStream(MyClient.getInputStream());
        }catch (SocketException ex) {
            System.err.println("Can not connect to " + machine);
            Logger.getLogger(generalSocket.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        } catch (IOException ex) {
            System.err.println("IOException while connecting to " + machine);
            Logger.getLogger(generalSocket.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        } 
    }

    public String sendMessage(String msg) {
        if (MyClient != null && os != null && is != null) {
            try {

                os.writeBytes(msg);
                String responseLine;
                responseLine = is.readLine();
                System.out.println("Server: " + responseLine);
                return responseLine;

            } catch (UnknownHostException e) {
                System.err.println("Trying to connect to unknown host: " + e);
            } catch (IOException e) {
                System.err.println("IOException:  " + e);
            }

        }
        return "error";
    }

    public void turnOn() {
        String response = sendMessage("pl a1 on\n");
    }

    public void turnOn(String device) {
        String response = sendMessage("pl " + device + "on\n");
    }

    public void turnOff() {
        String response = sendMessage("pl a1 off\n");
    }

    public void turnOff(String device) {
        String response = sendMessage("pl " + device + "off\n");
    }

    public void pressSwitch() {
        if (getstatus()) {
            turnOff();
        } else {
            turnOn();
        }
    }

    public void pressSwitch(String device) {
        if (getstatus()) {
            turnOff(device);
        } else {
            turnOn(device);
        }
    }

    public boolean getstatus() {
        String response = sendMessage("getstatus a1\n");
        return response.equals("on");
    }

    public boolean getstatus(String device) {
        String response = sendMessage("getstatus " + device + "\n");
        return response.equals("on");
    }

    public void close() {
        try {
            os.close();
            is.close();
            MyClient.close();
        } catch (IOException ex) {
            Logger.getLogger(generalSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

