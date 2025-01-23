package java_Practice_Set.logicalPrograms.StringAndArray;

public class StringInputOutput_1 {
    public static void main(String[] args) {
        String s = "aabbccdd";
        //output s=a2b2c2d2

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            //count consecutive occurrence of char
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            //append char and count
            sb.append(s.charAt(i)).append(count);
        }
        System.out.println(sb);
    }
}
