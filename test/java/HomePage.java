import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page{

    @FindBy(id="welcome")
    WebElement paragraaf;

    @FindBy(id="logout")
    WebElement button;

    @FindBy(id="login")
    WebElement loginbutton;

    @FindBy(id="userid")
    WebElement userid;

    @FindBy(id="password")
    WebElement password;

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get(path+"Controller?command=Login");
    }

    public boolean isLoggedIn(){
        String tekst = paragraaf.getText();
        return tekst.contains("hallo");
    }

    public void logIn(String userId, String pass){
        userid.clear();
        userid.sendKeys(userId);
        password.clear();
        password.sendKeys(pass);
        loginbutton.click();
    }

    public String getTekst(){
        return paragraaf.getText();
    }

    public void logOut(){
        button.click();
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

    public void goToOtherPage(){
        driver.get(path+"Controller?command=Overview");
    }

    public void goBackToHome(){
        driver.get(path+"Controller?command=Login");
    }
}


