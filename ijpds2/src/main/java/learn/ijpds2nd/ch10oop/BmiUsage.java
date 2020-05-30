package learn.ijpds2nd.ch10oop;

public class BmiUsage {
    public static void main(String[] args) {
        Bmi bmi1 = new Bmi(new Person("Kim Yang", 18), 145, 70);
        System.out.println("The BMI for " + bmi1.getPerson() + " is " + bmi1.getBmi() + " " + bmi1.getStatus());
        Bmi bmi2 = new Bmi(new Person("Susan King", 26), 215, 70);
        System.out.println("The BMI for " + bmi2.getPerson() + " is " + bmi2.getBmi() + " " + bmi2.getStatus());
    }
}
