package java_Practice_Set.basics;

public class DataTypes {
    /**
     * Data types specify the different sizes and values that can be stored in the variable.
     * There are two types of data types in Java:
     *      Primitive data types: The primitive data types include boolean, char, byte, short, int, long, float and double.
     *      Non-primitive data types: The non-primitive data types include Classes, Interfaces, and Arrays.
     */

    /**
     * Java Primitive Data Types
     * In Java language, primitive data types are the building blocks of data manipulation.
     * These are the most basic data types available in Java language.
     *
     * Java is a statically-typed programming language. It means, all variables must be declared before its use.
     * That is why we need to declare variable's type and name.
     */

    /**
     *
     * Java Primitive data types:
     *
     *     boolean
     *     byte
     *     char
     *     short
     *     int
     *     long
     *     float
     *     double
     */

    //In Java, the boolean data type represents a single bit of information with two possible states: true or false
    //One key feature of the boolean data type is its use in controlling program flow. It is commonly employed in conditional statements
    // such as if, while, and for loops to determine the execution path based on the evaluation of a boolean expression
    Boolean a = false;
    Boolean b = true;

    //The byte data type in Java is a primitive data type that represents an 8-bit signed two's complement integer.
    // It has a range of values from -128 to 127
    //One common use of the byte data type is in reading and writing binary data, such as files or network streams

    byte p = 10;
    byte q = -20;

    //The short data type in Java is a primitive data type that represents a 16-bit or 2byte signed two's complement integer.
    // It has a range of values from -32,768 to 32,767.

    short s = 10000;
    short r = -5000;

    //The int data type in Java is a primitive data type that represents a 32-bit or 4 byte signed two's complement integer.
    // It has a range of values from -2,147,483,648 to 2,147,483,647. The int data type is one of the most commonly used data types
    // in Java and is typically used to store whole numbers without decimal points. Its default value is 0.
    int aa = 100000;
    int bb = -200000;

    //he long data type in Java is a primitive data type that represents a 64-bit or 8 byte signed two's complement integer.
    // It has a wider range of values than int
    // Its default value is 0.0F
    long y = 100000L;
    long t = -200000L;

    //The float data type in Java is a primitive data type that represents single-precision 32-bit 4 byte floating-point numbers.
    // It can represent a wide range of decimal values, but it is not suitable for precise values such as currency
    float f1 = 234.5f;

    //The double data type in Java is a primitive data type that represents double-precision 64-bit 8byte floating-point numbers.
    // Its default value is 0.0d. It provides a wider range of values and greater precision compared to the float data type,
    // making it suitable for applications where accurate representation of decimal values is required.
    double d1 = 12.3;

    //The char data type in Java is a primitive data type that represents a single 16-bit 2 byte Unicode character

    char letterA = 'A';

    //Non-Primitive Data Types in Java
    //In Java, non-primitive data types, also known as reference data types, are used to store complex objects rather than simple values.
    // Unlike primitive data types that store the actual values, reference data types store references or memory addresses that point to the
    // location of the object in memory.This distinction is important because it affects how these data types are stored, passed, and manipulated in Java programs.


}
