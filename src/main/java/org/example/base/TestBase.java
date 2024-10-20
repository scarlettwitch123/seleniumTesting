package org.example.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected String baseUrl;
    protected String username;
    protected String password;
    protected String incorrectUsername;
    protected String incorrectPassword;
    protected String updateName;


    @BeforeClass
    public void setup() {

        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }

            properties.load(input);
            baseUrl = properties.getProperty("base.url");
            username = properties.getProperty("login.username");
            password = properties.getProperty("login.password");
            incorrectUsername = properties.getProperty("incorrect.user");
            incorrectPassword = properties.getProperty("incorrect.password");
            updateName = properties.getProperty("updated.name");

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Harkendata\\IdeaProjects\\seleniumTesting\\src\\main\\resources\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(baseUrl);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
