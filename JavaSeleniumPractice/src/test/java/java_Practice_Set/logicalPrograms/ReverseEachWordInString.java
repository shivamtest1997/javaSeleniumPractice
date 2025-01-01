package java_Practice_Set.logicalPrograms;

public class ReverseEachWordInString {
    public static void main(String[] args) {
        String s = "Hello world in java programming";
        String[] words = s.split("\\s");
        String newSentence = "";
        for (String word : words) {
            newSentence += reverseString(word) + " ";
        }
        System.out.println(newSentence);
    }

    public static String reverseString(String word) {
        String reverse = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reverse += word.charAt(i);
        }
        return reverse;
    }
}
