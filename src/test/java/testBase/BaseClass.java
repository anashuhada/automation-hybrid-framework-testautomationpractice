package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public Logger logger;
    public Properties prop;

    @BeforeClass
    @Parameters({"os", "browser"})
    public void setup(@Optional("mac") String os, @Optional("chrome") String br) throws IOException {
        // apache log4j
        logger = LogManager.getLogger(this.getClass());

        // config.properties
        FileReader file = new FileReader("./src/test/resources/config.properties");
        prop = new Properties();
        prop.load(file);

        // remote environment
        if(prop.getProperty("execution_env").equalsIgnoreCase("remote")) {
            DesiredCapabilities dc = new DesiredCapabilities();

            // os
            if(os.equalsIgnoreCase("mac")) {
                dc.setPlatform(Platform.MAC);
            }
            else if(os.equalsIgnoreCase("windows")) {
                dc.setPlatform(Platform.WIN11);
            }
            else if(os.equalsIgnoreCase("linux")) {
                dc.setPlatform(Platform.LINUX);
            }
            else {
                System.out.println("No matching operating system found.");
                return;
            }

            // browser
            switch(br.toLowerCase()) {
                case "chrome" : dc.setBrowserName("chrome"); break;
                case "edge" : dc.setBrowserName("MicrosoftEdge"); break;
                case "firefox" : dc.setBrowserName("firefox"); break;
                default : System.out.println("No matching browser found."); return;
            }

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);

        }

        // local environment
        if(prop.getProperty("execution_env").equalsIgnoreCase("local")) {
            switch(br.toLowerCase()) {
                case "chrome" : ChromeOptions co = new ChromeOptions();
                    co.addExtensions(new File("/Volumes/KINGSTON/Software Testing/Automation Testing/uBlock-Origin-Chrome-Web-Store.crx"));
                    co.addArguments("--disable-popup-blocking");
                    co.addArguments("--disable-blink-features=AutomationControlled");
                    driver = new ChromeDriver(co);  break;
                case "edge" : driver = new EdgeDriver(); break;
                case "firefox" : driver = new FirefoxDriver(); break;
                default : System.out.println("No matching browser found."); return;
            }
        }

        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("webAppUrl"));
        driver.manage().window().maximize();
        System.out.println("Web app launched.");

    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        System.out.println("Web app closed.");
//        Thread.sleep(5000);
//        driver.quit();
    }

    public String randomString() {
        String generatedString = RandomStringUtils.randomAlphabetic(10);
        return generatedString;
    }

    public String randomNumeric() {
        String generatedNumber = RandomStringUtils.randomNumeric(10);
        return generatedNumber;
    }

    public String randomName() {
        String firstName = randomString();
        String lastName = randomString();
        return firstName + " " + lastName;
    }

    public String randomAddress() {
        String streetNumber = randomNumeric().substring(0, 4); // Shorten for a realistic street number
        String streetName = randomString();
        String city = randomString();
        String zipCode = randomNumeric().substring(0, 5); // Shorten for a realistic ZIP code
        return streetNumber + " " + streetName + " St, " + city + ", ZIP " + zipCode;
    }

    public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot ss = (TakesScreenshot) driver;
        File sourceFile = ss.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "/screenshots/" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        sourceFile.renameTo(targetFile);
        return targetFilePath;
    }

}
