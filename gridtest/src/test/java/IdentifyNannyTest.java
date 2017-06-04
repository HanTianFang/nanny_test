import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deft on 2017/5/13.
 */
public class IdentifyNannyTest {
    private static final String BASE_URL = "http://nanny.com:8080/nanny/";
    private static List<WebDriver> drivers = new ArrayList<WebDriver>();

    @BeforeClass
    public static void openPage() throws MalformedURLException {
        DesiredCapabilities ieDesiredcap1 = DesiredCapabilities.firefox();
        WebDriver driver1 = new RemoteWebDriver(new URL("http://nanny.com:4444/wd/hub"), ieDesiredcap1);
        DesiredCapabilities ieDesiredcap2 = DesiredCapabilities.chrome();
        WebDriver driver2 = new RemoteWebDriver(new URL("http://nanny.com:4444/wd/hub"), ieDesiredcap2);
        DesiredCapabilities ieDesiredcap3 = DesiredCapabilities.internetExplorer();
        WebDriver driver3 = new RemoteWebDriver(new URL("http://nanny.com:4444/wd/hub"), ieDesiredcap3);
        drivers.add(driver1);
        drivers.add(driver2);
        drivers.add(driver3);
    }
    @Test
    public void loginSuccess() throws InterruptedException {
        int i = 1;
        for (WebDriver driver:drivers             ) {
            driver.get(BASE_URL + "/ToFindNanny.jsp");
            WebElement register = driver.findElement(By.cssSelector(".glyphicon.glyphicon-user"));
            register.click();
            Thread.sleep(3000);
            WebElement email = driver.findElement(By.className("swal2-input"));
            email.sendKeys(System.currentTimeMillis() + "@qq.com");
            WebElement button1 = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
            button1.click();
            Thread.sleep(3000);
            WebElement password = driver.findElement(By.className("swal2-input"));
            password.sendKeys("1");
            WebElement  button2 = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
            button2.click();
            Thread.sleep(3000);
            WebElement repeatPassword = driver.findElement(By.className("swal2-input"));
            repeatPassword.sendKeys("1");
            WebElement button3 = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
            button3.click();
            Thread.sleep(1000);
            WebElement button = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
            button.click();
            WebElement userEmail = driver.findElement(By.id("userEmail"));
            userEmail.click();
            Thread.sleep(3000);
            WebElement username = driver.findElement(By.id("username"));
            username.sendKeys("聪明蛋");
            WebElement IDnumber = driver.findElement(By.id("IDnumber"));
            IDnumber.sendKeys("123112221111111111");
            WebElement phone = driver.findElement(By.id("phone"));
            phone.sendKeys("13111111111");
            WebElement appellation = driver.findElement(By.id("appellation"));
            Select selection = new Select(appellation);
            selection.selectByIndex(1);
            WebElement city = driver.findElement(By.id("city"));
            city.sendKeys("仙女星");
            WebElement residence = driver.findElement(By.id("residence"));
            residence.sendKeys("仙女屋");
            WebElement loginButton = driver.findElement(By.id("basicsubmit"));
            loginButton.click();
            Thread.sleep(1000);
            WebElement menuButton = driver.findElement(By.id("mm-menu-toggle"));
            menuButton.click();
            Thread.sleep(6000);
            WebElement nannyButton = driver.findElement(By.cssSelector(".md.md-favorite"));
            nannyButton.click();
            Thread.sleep(6000);
            WebElement toIdentifyButton = driver.findElement(By.id("identNanny"));
            toIdentifyButton.click();
            Thread.sleep(3000);
            WebElement city2 = driver.findElement(By.id("city2"));
            city2.click();
            WebElement isLive = driver.findElement(By.id("isLive1"));
            isLive.click();
            Thread.sleep(3000);
            WebElement workCondition = driver.findElement(By.id("workCondition"));
            Select selection1 = new Select(workCondition);
            selection1.selectByIndex(1);
            WebElement nannyEducation = driver.findElement(By.id("nannyEducation"));
            Select selection2 = new Select(nannyEducation);
            selection2.selectByIndex(1);
            WebElement nannySalary = driver.findElement(By.id("nannySalary"));
            nannySalary.sendKeys("1000");
            WebElement nannyRestTime = driver.findElement(By.id("nannyRestTime"));
            nannyRestTime.sendKeys("10");
            WebElement nation = driver.findElement(By.id("nation"));
            nation.sendKeys("仙女族");
            WebElement faith = driver.findElement(By.id("faith"));
            Select selection3 = new Select(faith);
            selection3.selectByIndex(1);
            WebElement maritalStatus = driver.findElement(By.id("maritalStatus"));
            Select selection4 = new Select(maritalStatus);
            selection4.selectByIndex(1);
            WebElement isChildLocal = driver.findElement(By.id("isChildLocal"));
            Select selection5 = new Select(isChildLocal);
            selection5.selectByIndex(1);
            WebElement isParentLocal = driver.findElement(By.id("isParentLocal"));
            Select selection6 = new Select(isParentLocal);
            selection6.selectByIndex(1);
            WebElement introduce = driver.findElement(By.id("introduce"));
            introduce.sendKeys("仙女就是我哈哈哈哈哈");
            WebElement remark = driver.findElement(By.id("remark"));
            remark.sendKeys("我就住在仙女屋来玩啊哈哈哈");
            WebElement identifyButton = driver.findElement(By.id("nannysubmit"));
            identifyButton.click();
            Thread.sleep(1000);
            Assert.assertEquals("成功",  driver.switchTo().alert().getText());
        }


    }
    @After
    public void closePage(){
        for (WebDriver driver:drivers) {
            driver.quit();
        }
    }
}
