package java_Practice_Set.logicalPrograms;

public class RemoveDuplicateCharacterFromString {
    public static void main(String[] args) {
        String s = "shsiiivhhaam";
        String duplicate = "";
        String newString = "";

        for (int i = 0; i < s.length(); i++) {
            boolean flag = false;
            for (int j = i + 1; j < s.length(); j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    flag = true;
                    duplicate += s.charAt(i);
                }

            }
            if (flag == false) {
                newString += s.charAt(i);
            }
        }
        System.out.println("duplicate characters: " + duplicate);
        System.out.println("String without duplicate char :" + newString);

    }
}
