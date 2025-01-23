package java_Practice_Set.logicalPrograms.StringAndArray;

public class PrintEachLetterTwiceInString {
    public static void main(String[] args) {
        String s="Hello";
        StringBuffer sb=new StringBuffer();

        for (int i=0;i<s.length();i++)
        {
            sb.append(s.charAt(i)).append(s.charAt(i));
        }
        System.out.println(sb);

    }
}
