package java_Practice_Set.logicalPrograms.StringAndArray;

public class FindDuplicateWordsInString {
    public static void main(String[] args) {
        String s = "big shivam is having big dreams and shivam is hard working";
        String[] words = s.toLowerCase().split("\\s");
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            count = 1;
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count++;
                    //to avoid printing visited words
                    break;
                }

            }
            if (count > 1) {
                System.out.println("duplicate words are: " + words[i]);
            }
        }
    }
}
