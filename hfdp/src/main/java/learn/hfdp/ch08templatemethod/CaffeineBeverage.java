package learn.hfdp.ch08templatemethod;

public abstract class CaffeineBeverage {

    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    public void boilWater() {
        System.out.println("Boiling water");
    }

    protected abstract void brew();

    public void pourInCup() {
        System.out.println("Pouring into cup");
    }

    protected abstract void addCondiments();
}
