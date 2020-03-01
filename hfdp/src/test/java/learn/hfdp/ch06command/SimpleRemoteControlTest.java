package learn.hfdp.ch06command;

import learn.hfdp.ch06command.devices.GarageDoor;
import learn.hfdp.ch06command.devices.Light;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleRemoteControlTest {

    @Test
    public void whenButtonPressedThenCommandExecuted() {
        SimpleRemoteControl remote = new SimpleRemoteControl();

        Light light = new Light("");
        LightOnCommand lightOn = new LightOnCommand(light);
        remote.setCommand(lightOn);
        remote.buttonPressed();
        assertTrue(light.isOn());

        GarageDoor garage = new GarageDoor("");
        GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garage);
        remote.setCommand(garageOpen);
        remote.buttonPressed();
        assertTrue(garage.isUp());
    }
}
