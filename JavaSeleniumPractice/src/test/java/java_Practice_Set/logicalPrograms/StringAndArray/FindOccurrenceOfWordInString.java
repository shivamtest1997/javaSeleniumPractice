package java_Practice_Set.logicalPrograms.StringAndArray;

import java.util.HashMap;

public class FindOccurrenceOfWordInString {
    public static void main(String[] args) {
        String s = "Java is programming language Java is used for UI Automation Java is robust";

        String word = "java";
        int count = 0;
        String[] words = s.toLowerCase().split("\\s");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                count++;
            }
        }
        System.out.println("occurrence of " + word + " is " + count);

        // Find Each word occurrence
        HashMap<String, Integer> hm = new HashMap<>();
        String[] s2 = s.split("\\s");
        for (String w : s2) {
            if (hm.containsKey(w)) {
                hm.put(w, hm.get(w) + 1);
            } else {
                hm.put(w, 1);
            }
        }
        System.out.println(hm);
    }
}
