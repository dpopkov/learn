package learn.hfdp.ch09iterator;

public class MenuTestDrive {
    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinnerMenu dinnerMenu = new DinnerMenu();
        Waitress waitress = new Waitress(System.out, pancakeHouseMenu, dinnerMenu);
        waitress.printMenu();
    }
}
