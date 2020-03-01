package learn.hfdp.ch06command;

import learn.hfdp.ch06command.devices.Hottub;
import learn.hfdp.ch06command.devices.Light;
import learn.hfdp.ch06command.devices.Stereo;
import learn.hfdp.ch06command.devices.TV;
import org.junit.Test;

import static org.junit.Assert.*;

public class MacroCommandTest {

    @Test
    public void testExecute() {
        Light light = new Light("Living Room");
        TV tv = new TV("Living Room");
        Stereo stereo = new Stereo("Living Room");
        Hottub hottub = new Hottub();

        LightOnCommand lightOn = new LightOnCommand(light);
        StereoOnWithCdCommand stereoOn = new StereoOnWithCdCommand(stereo);
        TvOnCommand tvOn = new TvOnCommand(tv);
        HottubOnCommand hottubOn = new HottubOnCommand(hottub);

        LightOffCommand lightOff = new LightOffCommand(light);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);
        TvOffCommand tvOff = new TvOffCommand(tv);
        HottubOffCommand hottubOff = new HottubOffCommand(hottub);

        MacroCommand partyOn = new MacroCommand(new Command[] {
                lightOn, stereoOn, tvOn, hottubOn
        });
        MacroCommand partyOff = new MacroCommand(new Command[] {
                hottubOff, tvOff, stereoOff, lightOff
        });
        RemoteControl remote = new RemoteControl();
        remote.setCommand(0, partyOn, partyOff);
        remote.onButtonPushed(0);
        assertTrue(light.isOn());
        assertTrue(tv.isOn());
        assertTrue(stereo.isOn());
        assertTrue(hottub.jestAreOn());

        remote.offButtonPushed(0);
        assertFalse(light.isOn());
        assertFalse(tv.isOn());
        assertFalse(stereo.isOn());
        assertFalse(hottub.jestAreOn());
    }
}
