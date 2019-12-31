package java8;

public interface TestInterface {
    // abstract method
    public void square(int a);

    // default method
    default void show() {
        System.out.println("Default Method Executed");
    }
}
