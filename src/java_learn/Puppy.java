package java_learn;

public class Puppy extends Dog {
    double weight;
    public Puppy(String name, int age, double weight) {
        super(name, age);
        this.weight = weight;
    }

    public void speak() {
        System.out.println("Hi, I'm puppy, my name is " + this.name + " and I am " + this.age + " years old.");
    }
}
