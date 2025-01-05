package java_Practice_Set.logicalPrograms.StringAndArray;

public class StringReverse {
    public static void main(String[] args) {
        //approach 1
        String s = "software testing";
        for (int i = s.length() - 1; i >= 0; i--) {
            char s1 = s.charAt(i);
            System.out.print(s1);
        }
        System.out.println();
        //approach 2
        String s1="welcome";
        char[] c=s1.toCharArray();
        for (int i=c.length-1;i>=0;i--)
        {
            System.out.print(c[i]);
        }
        System.out.println();
        //approach 3
        String s2="Shivam";
        StringBuffer sb=new StringBuffer(s2);
        System.out.println(sb.reverse());


    }
}
