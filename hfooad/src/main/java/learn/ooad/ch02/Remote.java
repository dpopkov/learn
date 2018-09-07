package learn.ooad.ch02;

import java.util.Timer;
import java.util.TimerTask;

public class Remote {
    public static final int CLOSE_DELAY = 5_000;

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

            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    door.close();
                    timer.cancel();
                }
            }, CLOSE_DELAY);
        }
    }
}
