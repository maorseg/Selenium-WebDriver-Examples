package corejava.conditionalstatements;

/**
 * Created by Maor on 5/20/2018.
 The finally block follows a try block or a catch block.
 A finally block of code always executed, irrespective of
 occurrence of an Exception.
 Using a finally block allows you to run any cleanup-type statements
 that you want to execute,
 no matter what happens in the protected code.
 */

public class FinallyBlock {

    public static void main(String[] args)
    {
        int a[]= new int[2];
        System.out.println("test");

        try
        {
            // the above statement will throw ArrayIndexOutOfBoundException
            System.out.println("Access invalid element" + a[3]);

        }finally
        {
            System.out.println("finally is always executed.");
        }
    }
}
