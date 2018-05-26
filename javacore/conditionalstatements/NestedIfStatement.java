package corejava.conditionalstatements;

/**
 * Created by Maor on 5/23/2018.
 */

public class NestedIfStatement {

    public static void main(String[] args) {

        int num = 100;

        if (num <=100){
            System.out.println("Value of num is " +num);

            if (num >50){
                System.out.println("Value of num is "+num);
            }
        }
    }
}
