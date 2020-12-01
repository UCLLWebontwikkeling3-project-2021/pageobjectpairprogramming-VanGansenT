import org.openqa.selenium.WebDriver;

public abstract class Page {
    /**
     * Door Thomas Van Gansen En Lennert Nowak
     */
    WebDriver driver;
    String path = "localhost:8080/Contact_Tracing_App_war_exploded/";

    public WebDriver getDriver() {
        return driver;
    }

    public String getPath() {
        return path;
    }
    public Page(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle(){
        return driver.getTitle();
    }
}
