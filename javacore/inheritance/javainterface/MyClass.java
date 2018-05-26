package corejava.inheritance.javainterface;

/**
 * Created by Maor on 5/26/2018.
 */

public class MyClass implements MyInterface{


    public static void main(String [] args){
        MyInterface obj = new MyClass();
        obj.myMethodOne();
    }

    // Try to comment the below method myMethodOne and see.
    // You will face a compilation error.
    // As per the rule, this class must implement the abstract method of interface

    @Override
    public void myMethodOne() {

        System.out.println("Implementation of myMethodOne");

    }
}