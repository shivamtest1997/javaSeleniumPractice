package java_Practice_Set.logicalPrograms;

public class SumOfNumbersInString {
    public static void main(String[] args) {
        String s = "45shb5sghjsdh7dvb8";
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                String s1 = String.valueOf(c);
                sum = sum + Integer.parseInt(s1);
            }
        }
        System.out.println(sum);
    }
}
