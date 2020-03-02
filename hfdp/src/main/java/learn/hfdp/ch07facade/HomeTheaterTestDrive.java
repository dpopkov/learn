package learn.hfdp.ch07facade;

import learn.hfdp.ch07facade.appliancies.*;

public class HomeTheaterTestDrive {
    public static void main(String[] args) {
        Amplifier amplifier = new Amplifier();
        Tuner tuner = new Tuner();
        DvdPlayer dvdPlayer = new DvdPlayer();
        CdPlayer cdPlayer = new CdPlayer();
        Projector projector = new Projector();
        TheaterLights lights = new TheaterLights();
        Screen screen = new Screen();
        PopcornPopper popper = new PopcornPopper();
        HomeTheaterFacade theater = new HomeTheaterFacade(amplifier, tuner, dvdPlayer, cdPlayer,
                projector, lights, screen, popper);
        theater.watchMovie("2001");
        theater.endMovie();
    }
}
