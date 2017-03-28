import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Travel-user on 3/27/2017.
 */
public class AdminPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {

        ChromeDriverManager.getInstance().setup();

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void MyTest() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.manage().timeouts().implicitlyWait (10, TimeUnit.SECONDS);

        String[] xpathArray = new String[17];
        xpathArray[0] = ".//*[@id='app-']/a/span[2]";
        xpathArray[1] = ".//*[@id='doc-logotype']/a/span";
        xpathArray[2] = "//*[@id=\"doc-catalog\"]/a/span";
        xpathArray[2] = "//*[@id=\"doc-product_groups\"]/a/span";


        for (int i = 0; i < xpathArray.length; i++) {
            if(xpathArray[i].contains("//*[@id")){
                driver.findElement(By.xpath(xpathArray[i])).click();
                
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }else if(){

            }

        }

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
