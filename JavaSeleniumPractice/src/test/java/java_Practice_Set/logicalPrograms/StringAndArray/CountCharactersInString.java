package java_Practice_Set.logicalPrograms.StringAndArray;

public class CountCharactersInString {
    public static void main(String[] args) {
        String s = "I am shivam komawar";
        int count = 0;
        char[] c = s.toCharArray();
        for (char c1 : c) {
            if (Character.isAlphabetic(c1)) {
                count++;
            }
        }
        System.out.println("character count in String is " + count);
    }
}
