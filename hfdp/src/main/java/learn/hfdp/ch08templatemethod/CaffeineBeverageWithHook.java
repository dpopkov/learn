package learn.hfdp.ch08templatemethod;

import java.util.Scanner;

public abstract class CaffeineBeverageWithHook {

    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    public void boilWater() {
        System.out.println("Boiling water");
    }

    protected abstract void brew();

    public void pourInCup() {
        System.out.println("Pouring into cup");
    }

    protected abstract void addCondiments();

    protected boolean customerWantsCondiments() {
        return true;
    }

    protected final boolean getUserInput(String yesNoQuestion) {
        System.out.print(yesNoQuestion);
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        return !answer.isEmpty() && !"n".equalsIgnoreCase(answer);
    }
}
