package corejava.oops.polymorphism;

/**
 * Created by Maor on 5/25/2018.
 */

public class MethodOverridingChildClass extends MethodOverridingParentClass {

        public void myMethod(){
            System.out.println("I am a method from Child Class");
        }

        public static void main(String [] args){

            MethodOverridingParentClass obj = new MethodOverridingChildClass();
            // It calls the child class method myMethod()
            obj.myMethod();

        }
}
