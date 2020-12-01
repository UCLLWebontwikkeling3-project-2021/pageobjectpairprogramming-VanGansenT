import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Story4Test {
    /**
     * Door Thomas Van Gansen En Lennert Nowak
     */

    private WebDriver driver;
    private String path = "http://localhost:8080/Contact_Tracing_App_war_exploded/Controller";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\thoma\\Documents\\Web3\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(path + "?command=Login");
        submitLoginForm("t","t");
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test
    public void test_user_logs_out(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        assertTrue(homePage.isLoggedIn());
        homePage.logOut();
        assertFalse(homePage.isLoggedIn());
    }

    @Test
    public void test_user_refreshes_page_stays_logged_in_is_able_to_logout(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        assertTrue(homePage.isLoggedIn());
        homePage.refreshPage();
        assertTrue(homePage.isLoggedIn());
        homePage.logOut();
        assertFalse(homePage.isLoggedIn());
    }

    @Test
    public void test_user_goes_to_different_page_stays_logged_in_is_able_to_logout(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        assertTrue(homePage.isLoggedIn());
        homePage.goToOtherPage();
        homePage.goBackToHome();
        assertTrue(homePage.isLoggedIn());
        homePage.logOut();
        assertFalse(homePage.isLoggedIn());
    }



    private void submitLoginForm(String userid, String password){
        fillOutField("userid", userid);
        fillOutField("password", password);

        WebElement button = driver.findElement(By.id("login"));
        button.click();
    }

    private void fillOutField(String name, String value) {
        WebElement field = driver.findElement(By.id(name));
        field.sendKeys(value);
    }
}

