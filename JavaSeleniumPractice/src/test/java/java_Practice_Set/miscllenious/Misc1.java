package java_Practice_Set.miscllenious;

import org.testng.annotations.Test;

public class Misc1 {

    /**
     *  what is output.
     */
    @Test
    public void m1()
    {
        String  value= " java";
        value +=" Quiz";
        value.trim();
        System.out.println(value.length());
        // Here output is 10 because trim() will remove trailing and leading spaces
        // but strings are immutable so answer is 10
        // value=value.trim()  then output is 8
    }

}
