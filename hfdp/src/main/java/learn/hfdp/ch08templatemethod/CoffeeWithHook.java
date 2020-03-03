package learn.hfdp.ch08templatemethod;

public class CoffeeWithHook extends CaffeineBeverageWithHook {

    @Override
    public void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

    @Override
    protected boolean customerWantsCondiments() {
        return getUserInput("Would you like milk and sugar with your coffee (y/n)? ");
    }
}
