package java_Practice_Set.logicalPrograms;

public class StringVowelsAndConsonantsCount {
    public static void main(String[] args) {
        String s = "Java Selenium Learning";
        int vowels = 0;
        int consonants = 0;
        char[] c = s.toCharArray();

        for (char c1 : c) {
            if (c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }
        System.out.println("Total number of vowels are " + vowels);
        System.out.println("Total number of consonants are " + consonants);
    }
}
