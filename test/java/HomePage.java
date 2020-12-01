import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page{

    /**
     * Door Thomas Van Gansen En Lennert Nowak
     */

    @FindBy(id="welcome")
    WebElement paragraaf;

    @FindBy(id="logout")
    WebElement button;

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get(path+"Controller?command=Login");
    }

    public boolean isLoggedIn(){
        String tekst = paragraaf.getText();
        return tekst.contains("welcome");
    }

    public String getTekst(){
        return paragraaf.getText();
    }

    public void logOut(){
        button.click();
    }

}

