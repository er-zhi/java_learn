package java_learn;

public class Dog {
    protected String name;
    protected int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void speak() {
        System.out.println("Hi, my name is " + this.name + " and I am " + this.age + " years old.");
    }

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
