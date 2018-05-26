package corejava.inheritance.polymorphism.methodoverriding.methodOverloading;

/**
 * Created by Maor on 5/26/2018.
 */

public class MethodOverloadingDiffSeqDataTypes {

    public void methodOne(int a, String b){
        System.out.println(b);
    }

    public void methodOne(String a, int b)
    {
        System.out.println(a);
    }

    public static void main(String[] args) {

        MethodOverloadingDiffSeqDataTypes obj = new MethodOverloadingDiffSeqDataTypes();

        obj.methodOne(1, "Int and String");
        obj.methodOne("String and Int", 2);

    }
}
