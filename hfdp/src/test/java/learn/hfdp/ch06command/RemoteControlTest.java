package learn.hfdp.ch06command;

import learn.hfdp.ch06command.devices.CeilingFan;
import learn.hfdp.ch06command.devices.GarageDoor;
import learn.hfdp.ch06command.devices.Light;
import learn.hfdp.ch06command.devices.Stereo;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoteControlTest {

    @Test
    public void setCommand() {
        RemoteControl remote = new RemoteControl();
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        GarageDoor garageDoor = new GarageDoor("");
        Stereo stereo = new Stereo("Living Room");

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        CeilingFanLowCommand ceilingFanOn = new CeilingFanLowCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);
        GarageDoorCloseCommand garageDoorClose = new GarageDoorCloseCommand(garageDoor);

        StereoOnWithCdCommand stereoOnWithCd = new StereoOnWithCdCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);

        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remote.setCommand(1, kitchenLightOn, kitchenLightOff);
        remote.setCommand(2, ceilingFanOn, ceilingFanOff);
        remote.setCommand(3, stereoOnWithCd, stereoOff);
//        remote.setCommand(4, garageDoorOpen, garageDoorClose);

        System.out.println(remote);

        remote.onButtonPushed(0);
        assertTrue(livingRoomLight.isOn());
        remote.offButtonPushed(0);
        assertFalse(livingRoomLight.isOn());

        remote.onButtonPushed(1);
        assertTrue(kitchenLight.isOn());
        remote.offButtonPushed(1);
        assertFalse(kitchenLight.isOn());

        remote.onButtonPushed(2);
        assertEquals(1, ceilingFan.getSpeed());
        remote.offButtonPushed(2);
        assertEquals(0, ceilingFan.getSpeed());

        remote.onButtonPushed(3);
        assertTrue(stereo.isOn());
        remote.offButtonPushed(3);
        assertFalse(stereo.isOn());
    }

    @Test
    public void whenUndoThenLastActionReversed() {
        RemoteControl remote = new RemoteControl();
        Light livingRoomLight = new Light("Living Room");
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);

        remote.onButtonPushed(0);
        assertTrue(livingRoomLight.isOn());
        remote.undoButtonPushed();
        assertFalse(livingRoomLight.isOn());

        remote.onButtonPushed(0);
        remote.offButtonPushed(0);
        remote.undoButtonPushed();
        assertTrue(livingRoomLight.isOn());
    }

    @Test
    public void whenUndoThenLastStateRestored() {
        RemoteControl remote = new RemoteControl();
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        CeilingFanLowCommand ceilingLow = new CeilingFanLowCommand(ceilingFan);
        CeilingFanMediumCommand ceilingMedium = new CeilingFanMediumCommand(ceilingFan);
        CeilingFanOffCommand ceilingOff = new CeilingFanOffCommand(ceilingFan);
        remote.setCommand(0, ceilingLow, ceilingOff);
        remote.setCommand(1, ceilingMedium, ceilingOff);

        remote.onButtonPushed(0);
        assertEquals(CeilingFan.LOW, ceilingFan.getSpeed());
        remote.undoButtonPushed();
        assertEquals(CeilingFan.OFF, ceilingFan.getSpeed());
        remote.onButtonPushed(0);
        remote.onButtonPushed(1);
        assertEquals(CeilingFan.MEDIUM, ceilingFan.getSpeed());
        remote.undoButtonPushed();
        assertEquals(CeilingFan.LOW, ceilingFan.getSpeed());
    }
}
