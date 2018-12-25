package learn.hfdp.ch04factory.franchising;

import learn.hfdp.ch04factory.Pizza;
import learn.hfdp.ch04factory.franchising.chicago.ChicagoPizzaStore;
import learn.hfdp.ch04factory.franchising.ny.NYPizzaStore;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName());
        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName());
    }
}
