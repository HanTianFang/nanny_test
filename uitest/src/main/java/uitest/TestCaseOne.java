package uitest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deft on 2017/4/11.
 */
public class TestCaseOne {

    private static final String BASE_URL = "http://127.0.0.1:8080";

    private static void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void input(WebDriver driver) {

        driver.get(BASE_URL + "/newtest/");
        sleep(2);
        WebElement ele_first = driver.findElement(By.id("form-first-name"));
        ele_first.sendKeys("nie");
        WebElement element_last = driver.findElement(By.id("form-last-name"));
        element_last.sendKeys("deft");
        WebElement ele_form = driver.findElement(By.id("form-about-yourself"));
        ele_form.sendKeys("xixixi");
        WebElement ele_button1 = driver.findElement(By.cssSelector(".btn.btn-next"));
        ele_button1.click();

        sleep(2);
        String s = driver.getWindowHandle();
        WebDriver window = driver.switchTo().window(s);
        WebElement element_mail = window.findElement(By.id("form-email"));
        element_mail.sendKeys("505631529@qq.com");
        WebElement ele_password = window.findElement(By.id("form-password"));
        ele_password.sendKeys("nzsnzs");
        WebElement ele_repeat = window.findElement(By.id("form-repeat-password"));
        ele_repeat.sendKeys("111");
        List<WebElement> cheeses = new ArrayList<WebElement>();
        cheeses = window.findElements(By.cssSelector(".btn.btn-next"));
        WebElement ele_button2 = cheeses.get(1);
        ele_button2.click();

        sleep(2);
        String s2 = driver.getWindowHandle();
        WebDriver window2 = driver.switchTo().window(s2);
        WebElement element_facebook = window2.findElement(By.id("form-facebook"));
        element_facebook.sendKeys("505631529@qq.com");
        WebElement ele_twitter = window2.findElement(By.id("form-twitter"));
        ele_twitter.sendKeys("nzsnzs");
        WebElement ele_google = window2.findElement(By.id("form-google-plus"));
        ele_google.sendKeys("111");
        WebElement ele_button3 = window2.findElement(By.className("btn"));
        boolean a = ele_button3.isEnabled();
        ele_button3.submit();
        driver.close();

        //return  "yes";
    }
}
