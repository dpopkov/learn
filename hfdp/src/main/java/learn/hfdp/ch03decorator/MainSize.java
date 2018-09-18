package learn.hfdp.ch03decorator;

public class MainSize {
    public static void main(String[] args) {
        Beverage espresso = new Espresso();
        System.out.println(espresso);
        espresso = new SmallSize(espresso);
        System.out.println(espresso);

        Beverage darkRoast = new DarkRoast();
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Whip(darkRoast);
        System.out.println(darkRoast);
        darkRoast = new LargeSize(darkRoast);
        System.out.println(darkRoast);
    }
}
