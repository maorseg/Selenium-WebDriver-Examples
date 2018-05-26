package corejava.conditionalstatements;

/**
 * Created by Maor on 5/23/2018.
 */

public class SwitchCaseProgram {

    public static void main(String[] args) {
		/*The java switch statement is fall-through.
		It means it executes all statement after first match if break
		statement is not used with switch cases.*/
        int num = 200;
        switch(num){

            case 100:
                System.out.println("Value of Case 1 is "+num);
            case 200:
                System.out.println("Value of Case 2 is "+num);
            default:
                System.out.println("Value of default is "+num);

        }

    }
}
