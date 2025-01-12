package java_Practice_Set.OPPs;

/**
 * 1.Encapsulation :Encapsulation involves wrapping of data (variables) and methods
 * together into a single unit, or class.
 * In a Selenium framework, this can be applied in the following ways:
 *     Page Object Model (POM): The POM design pattern helps encapsulate the page-specific action methods
 *     (like clicking a button, filling a form, etc.) and elements (like buttons, text boxes)
 *     into a single class for each web page.
 */

/**
 * 2. Abstraction:
 * Abstraction hides the complex implementation details and only exposes necessary information.
 * In a Selenium framework, abstraction is implemented through:
 *      Abstract Test Classes: These classes can provide common setup and teardown functionality for test execution.
 *      Helper Methods: Reusable common methods, such as waiting for an element or handling browser initialization,
 *      are abstracted to simplify test case development.
 */

/**
 * 3. Inheritance:
 * Inheritance allows one class to inherit variables and methods from another.
 * In Selenium automation, this can be applied as:
 *  Test Case Inheritance: Common functionalities like setup and teardown are inherited by test classes.
 *  Reusable Components: You can create generic classes or utilities (e.g., logging, reporting)
 *  that are inherited by the actual test classes to reduce redundancy.
 */

/**
 * 4. Polymorphism:
 * Polymorphism allows one interface to be used for a general class of actions.
 * It helps in using the same method name but different behaviors depending on the object being used.
 * In Selenium, polymorphism can be seen in:
 *      WebDriver Interfaces: Selenium supports different browsers, and the same test scripts
 *      can be run on different browsers by creating different WebDriver objects, like ChromeDriver,
 *      FirefoxDriver, etc. The test case doesn't need to change, only the WebDriver implementation.
 * Overloading and Overriding: Overloading methods in helper classes (e.g., a method to click elements with or without waiting)
 * or overriding methods for specific WebDriver actions
 */

/**
 * 6. Interfaces:
 * Interfaces are used to define a contract that other classes must follow. In Selenium, you can use interfaces for:
 *  Common Actions: Define common actions (like Clickable, InputField, etc.)
 *  as interfaces to ensure different page objects implement these actions.
 */

public class UsageInFramework {


}
