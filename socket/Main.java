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
public class Main {

    static int portNumber = 1099;
    static String machine = "134.184.26.150";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            generalSocket mySocket;
                mySocket = new generalSocket(machine, portNumber);

                System.out.println(mySocket.getstatus());
                //Thread.sleep(4000);
                /*
                 * mySocket.turnOn(); Thread.sleep(4000); mySocket.turnOff();
                 * Thread.sleep(4000); mySocket.pressSwitch();
                 * Thread.sleep(4000);
                 */
                //mySocket.pressSwitch();
                mySocket.close();
    }
}
