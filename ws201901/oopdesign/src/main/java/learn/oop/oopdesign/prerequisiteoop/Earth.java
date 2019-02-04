package learn.oop.oopdesign.prerequisiteoop;

public class Earth {
	public static void main(String[] args) {
		Human tom = new Human("Tom", 5, 72, "brown");
		tom.speak();
		Human joe = new Human("Joe", 36, 68, "green");
		joe.speak();
	}
}
