package learn.hfdp.ch09iterator;

import java.util.Scanner;

@SuppressWarnings("SpellCheckingInspection")
public class MenuTestDrive {
    public static void main(String[] args) {
        Menu allMenus = new Menu("ALL MENUS", "All menus combined");
        initMenus(allMenus);
        Waitress waitress = new Waitress(allMenus);
        System.out.print("Choose menu type:\na - All menus\nv - Vegetarian menu\n> ");
        String choice = new Scanner(System.in).nextLine();
        if ("a".equalsIgnoreCase(choice)) {
            waitress.printMenu();
        } else if ("v".equalsIgnoreCase(choice)) {
            waitress.printVegetarianMenu();
        } else {
            System.err.println("Invalid choice");
        }
    }

    private static void initMenus(Menu allMenus) {
        Menu pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        Menu dinerMenu = new Menu("DINER MENU", "Lunch");
        Menu cafeMenu = new Menu("CAFE MENU", "Dinner");
        Menu dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        pancakeHouseMenu.add(new MenuItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99));
        pancakeHouseMenu.add(new MenuItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99));
        pancakeHouseMenu.add(new MenuItem("Blueberry Pancakes", "Pancakes made with fresh blueberries", true, 3.49));
        pancakeHouseMenu.add(new MenuItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59));

        dinerMenu.add(new MenuItem("Vegetarian BLT", "Fake Bacon with lettuce & tomato on whole wheat", true, 2.99));
        dinerMenu.add(new MenuItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99));
        dinerMenu.add(new MenuItem("Soup of the day", "Soup of the day, with a side of potato salad", false, 3.29));
        dinerMenu.add(new MenuItem("Hotdog", "A hot dog, with saurkraft, relish, onions, topped with cheese", false, 3.05));

        cafeMenu.add(new MenuItem("Veggie Burger and Air Fries", "Veggie burger on a whole wheat bun, lettuce, tomato, and fries", true, 3.99));
        cafeMenu.add(new MenuItem("Soup of the day", "A cup of the soup of the day, with a side salad", false, 3.69));
        cafeMenu.add(new MenuItem("Burrito", "A large burrito, with whole pinto beans, salsa, guacamole", true, 4.29));
        cafeMenu.add(dessertMenu);
        dessertMenu.add(new MenuItem("Apple Pie", "Apple pie with a flakey crust, topped with vanilla icecream", true, 1.59));
    }
}
