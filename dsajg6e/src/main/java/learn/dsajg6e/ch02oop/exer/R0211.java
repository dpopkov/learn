package learn.dsajg6e.ch02oop.exer;

@SuppressWarnings({"CastCanBeRemovedNarrowingVariableType", "RedundantCast"})
public class R0211 {
    public static void main(String[] args) {
        Region east = new State();
        State md = new Maryland();
        Object obj = new Place();
        Place usa = new Region();
        md.printMe();
        east.printMe();
        ((Place) obj).printMe();
        obj = md;
        ((Maryland) obj).printMe();
        obj = usa;
        ((Place) obj).printMe();
        usa = md;
        ((Place) usa).printMe();
    }

    private static class Maryland extends State {
        public void printMe() {
            System.out.println("Read it.");
        }
    }

    private static class State extends Region {
        public void printMe() {
            System.out.println("Ship it.");
        }
    }

    private static class Region extends Place {
        public void printMe() {
            System.out.println("Box it.");
        }
    }

    private static class Place {
        public void printMe() {
            System.out.println("Buy it.");
        }
    }
}
