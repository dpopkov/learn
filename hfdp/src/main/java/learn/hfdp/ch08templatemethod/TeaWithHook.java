package learn.hfdp.ch08templatemethod;

public class TeaWithHook extends CaffeineBeverageWithHook {

    @Override
    public void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding Lemon");
    }

    @Override
    protected boolean customerWantsCondiments() {
        return getUserInput("would you like Lemon with your tea (y/n)? ");
    }
}
