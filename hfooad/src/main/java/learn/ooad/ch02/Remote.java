package learn.ooad.ch02;

public class Remote {
    private DogDoor door;

    public Remote(DogDoor door) {
        this.door = door;
    }

    public void pressButton() {
        System.out.println("Pressing the remote control button...");
        if (door.isOpen()) {
            this.door.close();
        } else {
            this.door.open();
        }
    }
}
