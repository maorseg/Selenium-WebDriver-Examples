package corejava.conditionalstatements;

/**
 * Created by Maor on 5/23/2018.
 */
public class EnhancedForLoop {

    public static void main(String[] args) {

        int numbers[] = {1,2,3,4,5,6,7,8,9,10};

        //for (dataType iteratorVariable : IterableObject){
        for (int count : numbers){
            System.out.println("Count is : " +count);
        }

    }
}
