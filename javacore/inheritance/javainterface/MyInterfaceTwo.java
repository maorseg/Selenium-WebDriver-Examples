package corejava.inheritance.javainterface;

/**
 * Created by Maor on 5/26/2018.
 */

public interface MyInterfaceTwo extends MyInterfaceOne{

    // Compiler treats it as public abstract void myMethodTwo();
    // Below method has no body
    public void myMethodTwo();
}