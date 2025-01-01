package java_Practice_Set.logicalPrograms;

public class RemoveSpecialCharactersFromString {
    public static void main(String[] args) {
        String s = "$%^ShIV*&AM";
        String s1 = "";
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||
                    (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                s1 += s.charAt(i);
            }
        }
        System.out.println(s1.toLowerCase());
    }
}
