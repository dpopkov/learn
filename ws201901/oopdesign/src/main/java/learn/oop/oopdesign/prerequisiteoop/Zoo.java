package learn.oop.oopdesign.prerequisiteoop;

public class Zoo {
	public static void main(String[] args) {
		Animal dog = new Animal(3, "M", 30);
		Bird eagle = new Bird(1, "F", 1);
		Fish hering = new Fish(1, "M", 2);
		dog.eat();
		eagle.fly();
		eagle.eat();
		hering.swim();
		hering.eat();
	}
}
