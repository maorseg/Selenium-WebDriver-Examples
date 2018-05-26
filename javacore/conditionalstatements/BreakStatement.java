package corejava.conditionalstatements;

/**
 * Created by Maor on 5/24/2018.
 */

public class BreakStatement {

        public static void main(String[] args) {

            for (int i=1; i<=10; i++)
            {
                if (i==4)
                {
                    break;
                }

                System.out.println("Value of i is "+i);

            }

        }
}
