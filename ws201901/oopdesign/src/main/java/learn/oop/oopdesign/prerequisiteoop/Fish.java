package learn.oop.oopdesign.prerequisiteoop;

public class Fish extends Animal {

	public Fish(int age, String gender, int weight) {
		super(age, gender, weight);
	}

	public void swim() {
		System.out.println("swimming...");
	}
}
