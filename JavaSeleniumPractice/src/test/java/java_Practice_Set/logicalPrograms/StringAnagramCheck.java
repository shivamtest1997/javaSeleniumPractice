package java_Practice_Set.logicalPrograms;
import java.util.Arrays;
public class StringAnagramCheck {
    /**
     * Anagram of string is nothing but string having same
     * characters and prepare word in reverse order
     */
    public static void main(String[] args) {
        String s1 = "grab";
        String s2 = "brag";
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        if (c1.length == c2.length) {
            Arrays.sort(c1);
            Arrays.sort(c2);
            if (Arrays.equals(c1, c2)) {
                System.out.println(s1 + " and " + s2 + " are anagram of String");
            } else {
                System.out.println(s1 + " and " + s2 + " are not anagram of String");
            }

        }
    }
}
