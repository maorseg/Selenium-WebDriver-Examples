package corejava.conditionalstatements;

/**
 * Created by Maor on 5/23/2018.
 */

    public class SwitchCaseProgramWithBreak {

        public static void main(String[] args) {

            int num=200;
            switch(num){

                case 100:
                    System.out.println("Value of Case 1 is "+num);
                    break;
                case 200:
                    System.out.println("Value of Case 2 is "+num);
                    break;
                // In this only case 2 will be executed and rest of the cases will be ignored.
                default:
                    System.out.println("Value of default is "+num);

            }

        }
}
