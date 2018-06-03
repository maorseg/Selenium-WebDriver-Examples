package corejava.oops.abstraction;

/**
 * Created by Maor on 5/26/2018.
 */

// Here class is abstract
public abstract class AbstractSuperClass {

    // data members cant be abstract
    public int a = 10;

    // myMethod() is an abstract method
    abstract void myMethod();

    // myMethod(int x) is not an abstract method. Its a concrete method
    void myMethod(int x){
        System.out.println("I am in Super class and I am not an abstract method. I am a concrete method");
    }
}