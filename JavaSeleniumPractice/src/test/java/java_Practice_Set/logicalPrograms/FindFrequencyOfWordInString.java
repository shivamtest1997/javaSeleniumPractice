package java_Practice_Set.logicalPrograms;

import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class FindFrequencyOfWordInString {
    public static void main(String[] args) {

        String s = "Java is good language and java is simple language";
        //convert sting to lower case and split into words
        String[] words = s.toLowerCase().split("\\s");
        //create hashmap to store occurrence of each word
        HashMap<String, Integer> map = new HashMap<>();
        //logic: if word is already present in the map the increment its count else add word with count1
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

    }
}
