package java_Practice_Set.logicalPrograms;

public class StringReverse {
    public static void main(String[] args) {
        String s = "software testing";
        for (int i = s.length() - 1; i >= 0; i--) {
            char s1 = s.charAt(i);
            System.out.print(s1);
        }
    }
}
