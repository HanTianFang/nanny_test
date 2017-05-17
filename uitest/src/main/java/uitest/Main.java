package uitest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import java.net.MalformedURLException;

public class Main {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        TestCaseOne test = new TestCaseOne();
        test.input(driver);
        //driver.close();
        //Thread.sleep(1000);
//        try {
//            driver.quit();
//        }catch(Exception e){
//            System.out.println("Driver error preventing from Quitting.");
//        }
    }
}
