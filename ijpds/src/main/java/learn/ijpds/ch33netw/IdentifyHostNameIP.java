package learn.ijpds.ch33netw;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Demonstration of {@code InetAddress} usage to obtain the information
 * about the IP address and host name for the client.
 */
public class IdentifyHostNameIP {
    public static void main(String[] args) {
        for (String arg : args) {
            try {
                InetAddress address = InetAddress.getByName(arg);
                System.out.print("Host name: " + address.getHostName() + ", ");
                System.out.println("IP address: " + address.getHostAddress());
            } catch (UnknownHostException e) {
                System.err.println("Unknown host or IP address: " + arg);
            }
        }
    }
}
