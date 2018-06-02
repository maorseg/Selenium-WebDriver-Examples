package corejava.accessmodifiers;

/**
 * Created by Maor on 5/25/2018.
 */
public class PublicClassSeven {

    public static void main(String args[]){
        // Created an object of ClassSix
        PublicClassSix obj = new PublicClassSix();
        // Trying to access the public method of PublicClassSix

        obj.myMethod(10);

        // We tried the same example with Default and we faced an error. Hope you remember
    }
}
