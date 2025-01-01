package java_Practice_Set;

import java.io.*;
import java.util.Scanner;
/**
 * Exception:An unexpected or unplanned event that disturb the normal flow of execution of program.
 * <p>
 * Throwable(c) -->1.Exception ----1.Checked Exception(Compiler Exception) --exceptions identified by java compiler
 * -I/O Exception
 * -SQL Exception
 * -ClassNotFoundException...etc
 * 2.Unchecked Exception(RuntimeException)--exceptions which are not identified by java compiler
 * -ArithmeticException
 * -NullPointerException
 * -NumberFormatException
 * -ArrayIndexOutOfBoundException
 * -StringIndexOutOfBoundException ...etc
 * <p>
 * 2.Error---1.Assertion Error
 * 2.StackOverflow Error
 * 3.VirtualMachineError
 * Exception Handling: process of handling unexpected event in such a way that program will execute normally
 **/

/**
 * Checked Exception --handled by -->try-catch-finally block and throws keyword
 * --occurred due to user inputs
 * Unchecked Exception--handled by -->try-catch-finally block
 */
class UncheckedException {
    /**
     * Note:1
     * user can enter any unknown inputs so that we need to handle that line in try-catch  block
     * inside try block we will write risky code which may throw exception
     * inside catch block we will handle exception
     */
    public void m1() {
        System.out.println("program is started...!");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int num = sc.nextInt();
        try {
            System.out.println(100 / num);
            // here user can enter any valid or invalid(0) num so that this line will cause exception.
        } catch (ArithmeticException e) {
            System.out.println("Exception Handled....!");
        }
        System.out.println("program completed.......!");
    }

    /**
     * Note 2:
     * we can have one try and multiple catch blocks immediate after try block
     * and Last if we don't know type of exception we can write Exception in catch block
     */
    public void m2() {
        System.out.println("program is started...!");
        String s = null;
        try {
            System.out.println(s.length()); // this line will throw exception
        } catch (ArithmeticException e) {
            System.out.println("exception handled....." + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("exception handled....." + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("exception handled....." + e.getMessage());
        } catch (Exception e) {
            System.out.println("exception handled....." + e.getMessage());
        }
    }

    /**
     * Note 3
     * No matter what finally block will always execute
     * purpose of having finally block is to close secured access like in try block we will open DB connection
     * and catch block we will handle that exception and in finally block we will close connection
     * It is useful for cleanup activity
     * <p>
     * Exception occurred & catch block handled -->finally block execute
     * Exception occurred & catch block not handled -->finally block will execute
     * Exception not occurred --->finally block will execute
     */
    public void m3() {

        //we can write one try block without catch block ,we need to write finally block after try block
        int[] numbers = {1, 2, 3};
        // This will throw ArrayIndexOutOfBoundsException because index 5 doesn't exist
        try {
            System.out.println(numbers[5]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("exception handled......");
        }
        //we can't write any code after finally block
    }

    public void m4() {
        String s = "sghhgg";
        // This will throw ArrayIndexOutOfBoundsException because index 5 doesn't exist
        try {
            System.out.println(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            System.out.println("exception handled ....." + e.getMessage());
        } finally {
            System.out.println("finally block will always execute.....");
        }
    }

    public static void main(String[] args) {
        UncheckedException ux = new UncheckedException();
        ux.m1();
        ux.m2();
        ux.m3();
        ux.m4();
    }
}

class CheckedException {
    /**
     * we can handle checked exception by two ways
     * 1.try-catch block
     * 2.using throws keyword
     * he throws keyword doesn't throw exceptions
     * but informs the caller of the method that it needs to handle or declare the exception.
     */
    public void m5() throws FileNotFoundException {
        //here path may be invalid hence compiler will throw checked exception
        // can be handled by trows keyword
        // we need to write throws 'Exception Type' in method declaration
        FileInputStream file = new FileInputStream("C://invalidPath/");

        //this line will also throw an checked exception
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        CheckedException cx = new CheckedException();
        cx.m5();
    }
}

class ThrowVsThrows {

    /**
     * throw:
     * throw is used to explicitly throw an exception in your code.
     * When throw is encountered, the execution of the current method is stopped,
     * and the exception is propagated to the calling method.
     * <p>
     * throws:
     * throws is used in the method signature to declare that a method may throw an exception during its execution.
     * It is followed by a list of exception types that the method might throw (checked exceptions).
     * The throws keyword doesn't throw exceptions but informs the caller of the method that it needs to handle or declare the exception.
     */
    // throw example
    public static void checkAge(int age) {
        if (age < 18) {
            // Throwing an exception explicitly when age is less than 18
            throw new IllegalArgumentException("Age must be 18 or older.");
        }
        System.out.println("Age is valid.");
    }

    public static void main(String[] args) {
        try {
            checkAge(15);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    //throws example
    public static void readFile(String fileName) throws IOException {
        FileReader file = new FileReader(fileName);
        BufferedReader fileInput = new BufferedReader(file);
        throw new IOException("File not found.");  // Simulating an exception

    }
}
