package learn.oop.oopdesign.prerequisiteoop;

public class Bird extends Animal {
	
	public Bird(int age, String gender, int weight) {
		super(age, gender, weight);
	}

	public void fly() {
		System.out.println("flying...");
	}
}
