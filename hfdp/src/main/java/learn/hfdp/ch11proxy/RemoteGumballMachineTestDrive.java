package learn.hfdp.ch11proxy;

import learn.hfdp.ch10state.GumballMachine;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteGumballMachineTestDrive {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }
        int count = Integer.parseInt(args[1]);
        GumballMachine machine = new GumballMachine(args[0], count);
        machine.insertQuarter();
        machine.turnCrank();

        try {
            Remote stub = UnicastRemoteObject.exportObject(machine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("GumballMachine", stub);
            System.out.println("GumballMachine ready");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
