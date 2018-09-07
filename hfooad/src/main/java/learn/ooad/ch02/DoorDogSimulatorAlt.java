package learn.ooad.ch02;

public class DoorDogSimulatorAlt {
    public static void main(String[] args) {
        DogDoor door = new DogDoor();
        Remote remote = new Remote(door);
        System.out.println("Fido starts barking...");
        System.out.println("...so Todd grabs the remote control.");
        remote.pressButton();
        System.out.println("\nFido has gone outside...");
        try {
            Thread.sleep(Remote.CLOSE_DELAY + 1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nFido's all done...");
        System.out.println("\n...but he's stuck outside");
        System.out.println("\nFido scratches at the door...");
        System.out.println("...so Gina grabs the remote control.");
        remote.pressButton();
        System.out.println("\nFido's back inside...");
    }
}
