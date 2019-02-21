package learn.core2.ch04netw.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Demonstrates the InetAddress.
 * Supply a host name as command-line argument,
 * or run without arguments to see the address of the local host.
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        if (args.length > 0) {
            String host = args[0];
            InetAddress[] addresses = InetAddress.getAllByName(host);
            for (InetAddress a : addresses) {
                System.out.println(a);
            }
        } else {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local host address: " + localHost);
        }
    }
}
