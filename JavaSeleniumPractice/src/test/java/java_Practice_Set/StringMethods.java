package java_Practice_Set;

/**
 * 1.String is non-primitive data type -memory size is not fixed
 * 2.String is used to store collection of characters
 * 3.String is inbuilt class in java present inside java.lang package
 * 4.String class is final by default and can't be inherited
 * 5.String objects are immutable in nature meaning once a String object is created,
 * its value cannot be changed. If you modify a String,a new String object is created to hold the modified value.
 * 6.we can create String object with two ways
 *      1.using new keyword ex String greeting = new String("Hello");
 *      2.using String literals ex String greeting = "Hello";
 * 7.when we create String using literals then object creation takes place in String constant pool area
 * duplicate objects are not allowed in string constant pool area if we create same String object with diff
 * variable then it will point to same object
 * 8.when we create String using new keyword then object creation takes place in non-constant pool area
 *
 */
public class StringMethods {
    public static void main(String[] args) {
        //Length: length() returns the number of characters in the string.
        String str = "Hello";
        int len = str.length(); // len will be 5

        //Concatenation: You can concatenate strings using + or concat() method.
        String str1 = "Hello";
        String str2 = " World";
        String result = str1 + str2;  // Concatenation using "+" Hello World
        String result2=str1.concat(str2); // Hello World

        //Substring: substring() extracts a portion of a string.
        String str3 = "Hello World";
        String sub = str3.substring(0, 5);  // "Hello"

        //Comparison: equals() compares two strings for equality,
        String str4 = "Hello";
        String str5 = "hello";
        boolean isEqual = str4.equals(str5); // false
        boolean isEqualIgnoreCase = str4.equalsIgnoreCase(str5); // true

        //Changing Case: toUpperCase() and toLowerCase() change the case of the string.
        String str6 = "Hello";
        String upperStr = str6.toUpperCase(); // "HELLO"

        //Trimming: trim() removes leading and trailing spaces from a string.
        String str7 = "  Hello World  ";
        String trimmedStr = str7.trim(); // "Hello World"

        //charAt(index): return character at index position
        String str8="Shivam";
        char c= str.charAt(4); // a

        // contains(String s) : returns true if portion is present in string
        String str9="Test Automation";
        boolean value=str9.contains("Auto"); // true

        //indexOfChar(char ch) :  return index of char in String
        String str10="Test";
        int index= str.indexOf('e'); //1

        // replace(old char,new char)
        String str11="Shivam is boy";
        String res=str11.replace('a', 't'); // Shivtm is boy

        // split() :  return array of String
        String str12="Shivam is boy";
        String[] arr=str12.split(" ");

        //toCharArray() : convert string to character array

    }
}
