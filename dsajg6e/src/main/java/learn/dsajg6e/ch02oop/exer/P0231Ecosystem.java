package learn.dsajg6e.ch02oop.exer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

/**
 * P-2.31
 * Simulation of an ecosystem containing two types of creatures,
 * bears and fish. The ecosystem consists of a river, which is modeled as a relatively
 * large array. Each cell of the array should contain an Animal object, which can
 * be a Bear object, a Fish object, or null. In each time step, based on a random
 * process, each animal either attempts to move into an adjacent array cell or stay
 * where it is. If two animals of the same type are about to collide in the same
 * cell, then they stay where they are, but they create a new instance of that type
 * of animal, which is placed in a random empty cell in the array.
 * If a bear and a fish collide, however, then the fish dies.
 */
public class P0231Ecosystem {
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int side = 8;
        int numBears = 3;
        int numFishes = 7;
        if (args.length == 3) {
            try {
                side = Integer.parseInt(args[0]);
                numBears = Integer.parseInt(args[1]);
                numFishes = Integer.parseInt(args[2]);
            } catch (NumberFormatException nfe) {
                System.err.printf("Error in arguments: '%s' or '%s' or '%s'%n", args[0], args[1], args[2]);
                System.exit(-1);
            }
        }
        P0231Ecosystem es = new P0231Ecosystem(side, Bear.make(numBears), Fish.make(numFishes));
        es.start();
    }

    private final Animal[] river;
    /** Side of a square representing the river. */
    private final int side;

    /** Number of animals living in the ecosystem. */
    private int numAnimals;

    public P0231Ecosystem(int side, List<Animal> bears, List<Animal> fishes) {
        this.side = side;
        river = new Animal[side * side];
        allocate(fishes);
        allocate(bears);
    }

    public void start() {
        while (!getInput().equals("exit")) {
            step();
            System.out.println(this);
        }
    }

    private void step() {
        for (int i = 0; i < river.length; i++) {
            if (river[i] != null) {
                randomMove(i);
            }
        }
    }

    private void randomMove(int i) {
        int x0 = i % side;
        int y0 = i / side;
        int x1 = x0;
        int y1 = y0;
        int dir = random.nextInt(4);
        switch (dir) {
            case 0:
                if (x0 > 0) {
                    x1--;
                }
                break;
            case 1:
                if (y0 > 0) {
                    y1--;
                }
                break;
            case 2:
                if (x0 < side - 1) {
                    x1++;
                }
                break;
            case 4:
                if (y0 < side - 1) {
                    y1++;
                }
                break;
        }
        Animal animal = get(x0, y0);
        if (isFree(x1, y1)) {
            move(x0, y0, x1, y1, animal);
        } else {
            liveOrDie(animal, x0, y0, x1, y1);
        }
    }

    private void liveOrDie(Animal animal, int x0, int y0, int x1, int y1) {
        Animal other = get(x1, y1);
        if (animal instanceof Bear) {
            if (other instanceof Bear) {
                tryToStartNewLife(Bear::new);
            } else if (other instanceof Fish) {
                endLife(x1, y1);
                move(x0, y0, x1, y1, animal);
            }
        } else if (animal instanceof Fish) {
            if (other instanceof Bear) {
                endLife(x0, y0);
            } else if (other instanceof Fish) {
                tryToStartNewLife(Fish::new);
            }
        }
    }

    private void tryToStartNewLife(Supplier<Animal> constructor) {
        if (numAnimals == river.length) {
            System.out.println("Cannot start a new life because the ecosystem is full!");
        } else {
            Animal animal = constructor.get();
            allocate(List.of(animal));
            System.out.printf("A new %s is born!%n", animal.getClass().getSimpleName());
        }
    }

    private void endLife(int x, int y) {
        Animal animal = get(x, y);
        if (animal != null) {
            set(new Location(x, y), null);
            numAnimals--;
            System.out.printf("A %s just died%n", animal.getClass().getSimpleName());
        } else {
            throw new IllegalArgumentException(String.format("Location (%d,%d) is empty", x, y));
        }
    }

    private void move(int x0, int y0, int x1, int y1, Animal animal) {
        set(new Location(x0, y0), null);
        set(new Location(x1, y1), animal);
    }

    private void allocate(List<Animal> animals) {
        for (Animal a : animals) {
            Location loc = findFreeLocation();
            if (loc != null) {
                set(loc, a);
                numAnimals++;
            } else {
                throw new IllegalStateException("This ecosystem is full, it cannot allocate more animals");
            }
        }
    }

    private Location findFreeLocation() {
        if (numAnimals == river.length) {
            return null;
        }
        boolean found = false;
        Location loc = null;
        while (!found) {
            int x = random.nextInt(side);
            int y = random.nextInt(side);
            if (isFree(x, y)) {
                loc = new Location(x, y);
                found = true;
            }
        }
        return loc;
    }

    private void set(Location loc, Animal a) {
        river[loc.y * side + loc.x] = a;
    }

    private Animal get(int x, int y) {
        return river[y * side + x];
    }

    private boolean isFree(int x, int y) {
        return river[y * side + x] == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        horizontal(sb);
        for (int row = 0; row < side; row++) {
            sb.append('|');
            for (int col = 0; col < side; col++) {
                sb.append(' ');
                Animal a = get(col, row);
                if (a != null) {
                    sb.append(a.toString());
                } else {
                    sb.append(' ');
                }
            }
            sb.append('|');
            sb.append(System.lineSeparator());
        }
        horizontal(sb);
        return sb.toString();
    }

    private void horizontal(StringBuilder sb) {
        sb.append("-".repeat(2 * side + 2));
        sb.append(System.lineSeparator());
    }

    private static String getInput() {
        System.out.print("> ");
        return scanner.nextLine();
    }

    private static abstract class Animal {
        public static List<Animal> make(int number, Supplier<Animal> constructor) {
            ArrayList<Animal> list = new ArrayList<>(number);
            for (int i = 0; i < number; i++) {
                list.add(constructor.get());
            }
            return list;
        }
    }

    private static class Bear extends Animal {
        @Override
        public String toString() {
            return "B";
        }

        public static List<Animal> make(int number) {
            return Animal.make(number, Bear::new);
        }
    }

    private static class Fish extends Animal {
        @Override
        public String toString() {
            return "~";
        }

        public static List<Animal> make(int number) {
            return Animal.make(number, Fish::new);
        }
    }

    private static class Location {
        final int x;
        final int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
