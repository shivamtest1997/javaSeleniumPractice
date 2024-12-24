package selenium_practice_set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.Set;

public class OptionsClassUsage {

    /**
     * With options class we can control browser settings
     * Execute below test in headless
     * ChromeOptions -->Control settings of browser
     * Headless Testing is possible
     */
    @Test
    public void headlessBrowser()
    {
        EdgeOptions options=new EdgeOptions();
        options.addArguments("--headless=new"); // this argument sets  headless browser

        WebDriver driver=new EdgeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
        Set<String> windowIds = driver.getWindowHandles();
        // Set Collection doesn't follow index so it doesn't contains get method to extract values

        //Approach 2 -->When having multiple window ids more than 2
        for(String id:windowIds)
        {
            String title=driver.switchTo().window(id).getTitle();
            if (title.contains("Human Resources"))
            {
                System.out.println(driver.getCurrentUrl());
                driver.close();
            }
        }
    }

    /**
     * Handle SSL(Secure socket layer) certificate using Options class.
     */
    @Test
    public void sslHandling()
    {
        EdgeOptions options=new EdgeOptions();
        options.setAcceptInsecureCerts(true); // this argument is used to handle ssl certificate

        WebDriver driver=new EdgeDriver(options);
        driver.get("https://expired.badssl.com/");  // it will give privacy error if ssl is not handled

    }
    /**
     * remove automated message chrome is being controlled by automated software.
     */
    @Test
    public void disableAutomatedMessageOnScreen()
    {
        EdgeOptions options=new EdgeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        WebDriver driver=new EdgeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void incognitoMode()
    {
        EdgeOptions options=new EdgeOptions();
        options.addArguments("--incognito");
        WebDriver driver=new EdgeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // to maximized window
        options.addArguments("start-maximized");

        /**
         * Block dialog windows:
         * By default, ChromeDriver configures Chrome to allow pop-up windows.
         * If you want to block pop-ups, and restore the normal Chrome behavior when it isn't controlled by ChromeDriver,
         * do the following:
         *
         *  ChromeOptions options = new ChromeOptions();
         *  options.setExperimentalOption("excludeSwitches",
         *      Arrays.asList("disable-popup-blocking"));
         */
    }
    @Test
    public void enableExtensions()
    {
        /**
         * Steps to follow :
         * 1.Add CRX Extractor/Downloader to chrome browser -->to download extension crx file
         * 2.Add any extension like selectors hub to chrome browser
         * 3.Capture crx file for selectors hub  extension by clicking on plugin
         * 4.pass crx file path in automation script in ChromeOptions
         *
         * options.addExtensions(new File("/path/to/extension.crx"));
         */
        EdgeOptions options=new EdgeOptions();
        options.addExtensions(new File("D:\\Check-My-Links.crx"));
        WebDriver driver=new EdgeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    /**
     *  Reference :https://developer.chrome.com/docs/chromedriver/capabilities
     *  Use a custom profile
     *  By default, ChromeDriver creates a new temporary profile for each session.
     *  You may want to set special preferences or just use a custom profile altogether, also called the user data directory.
     *
     *  If using the temporary profile, you can use the chrome.prefs capability to specify preferences to apply after Chrome starts.
     *  For custom profiles, you can use the user-data-dir Chrome command-line switch to tell Chrome which profile to use:
     *  example :
     *  ChromeOptions options = new ChromeOptions();
     *  options.addArguments("user-data-dir=/path/to/your/custom/profile");
     *
     *  If the path doesn't exist, Chrome creates a new profile in the specified location.
     *  You can then modify the profile settings, and ChromeDriver can use the profile in the future.
     *  Open chrome://version in the browser to see what profile Chrome is using.Profile Path
     */

    /**
     * Set download directory:
     *
     * Chrome disallows using certain directories for download.
     * In particular, you cannot use the desktop folder as the download directory.
     * ChromeDriver does not automatically wait for download to complete.
     * If you call driver.quit() too soon, Chrome might terminate before the download has finished.
     *
     * For best results, use full paths, as relative paths don't always work.
     * On Windows, use \` as path separators./` isn't reliable on Windows.
     *
     * ChromeOptions options = new ChromeOptions();
     * Map<String, Object> prefs = new HashMap<String, Object>();
     * prefs.put("download.default_directory", "/directory/path");
     * options.setExperimentalOption("prefs", prefs);
     */
}
