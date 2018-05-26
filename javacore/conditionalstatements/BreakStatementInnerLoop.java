package corejava.conditionalstatements;

/**
 * Created by Maor on 5/24/2018.
 */

public class BreakStatementInnerLoop {

    public static void main(String[] args) {

        for (int x=1; x<=4; x++)
        {
            for (int y=1; y<=4; y++){

                if (x==2 && y==2)
                {
                    System.out.println("Value of x is "+x+" and Value of y is "+y);
                    break;
                }

                System.out.print(x);
                System.out.println(y);

            }

        }

    }
}
