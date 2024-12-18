package java_Practice_Set.logicalPrograms;

public class StringCountRemoveWhiteSpaces {
    public static void main(String[] args) {
        String s = "This is software testing";
        //Remove white spaces
        String s1 = s.replaceAll(" ", "");
        System.out.println(s1);

        //count white spaces
        char[] c = s.toCharArray();
        int count = 0;
        for (char c1 : c) {
            if (c1 == ' ') {
                count++;
            }
        }
        System.out.println("total white spaces count is " + count);
    }
}
