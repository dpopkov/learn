/* 2-11. An example of declaring static member classes. */
package learn.jlf2e.ch02inner;

public class ComputerAccessory {
    public static class Monitor {
        private final int size;

        public Monitor(int size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return "Monitor - Size: " + this.size + " inch";
        }
    }

    public static class Keyboard {
        private final int keys;

        public Keyboard(int keys) {
            this.keys = keys;
        }

        @Override
        public String toString() {
            return "Keyboard - Keys: " + this.keys;
        }
    }
}
