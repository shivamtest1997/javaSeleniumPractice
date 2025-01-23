package java_Practice_Set.logicalPrograms.StringAndArray;

public class FindOutLargestWordInString {
    public static void main(String[] args) {
        String s = "Sky is blue";
        String s1 = "";
        String[] arr = s.split("\\s");
        for (String a : arr) {
            if (a.length() > s1.length()) {
                s1 = a;
            }
        }
        System.out.println(s1);
    }
}
