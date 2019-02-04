package learn.oop.oopdesign.prerequisiteoop;

public class Animal {
	int age;
	String gender;
	int weight;
	
	public Animal(int age, String gender, int weight) {
		super();
		this.age = age;
		this.gender = gender;
		this.weight = weight;
	}
	
	public void eat() {
		System.out.println("eating...");
	}
	
	public void sleep() {
		System.out.println("sleeping...");
	}

	@Override
	public String toString() {
		return "Animal [age=" + age + ", gender=" + gender + ", weight=" + weight + "]";
	}
}
