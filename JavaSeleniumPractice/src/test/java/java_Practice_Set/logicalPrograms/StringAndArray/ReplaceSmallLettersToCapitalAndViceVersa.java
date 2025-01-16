package java_Practice_Set.logicalPrograms.StringAndArray;

public class ReplaceSmallLettersToCapitalAndViceVersa {
    public static void main(String[] args) {
        String s = "SHivaM RajEEv Komawar512";

        StringBuffer sb = new StringBuffer();

        //convert String to array
        char[] c = s.toCharArray();

        for (char c1 : c) {
            if (Character.isLowerCase(c1)) {
                sb.append(Character.toUpperCase(c1));
            } else if (Character.isUpperCase(c1)) {
                sb.append(Character.toLowerCase(c1));

            } else {
                sb.append(c1);
            }
        }
        System.out.println("original String " + s);
        System.out.println("after modification " + sb);


    }
}
