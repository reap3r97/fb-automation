package hamza;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators {
    public static void main(String[] args) {
        String error;

        System.setProperty("webdriver.chrome.driver",
                "C:/Users/Hamza/chromedriver/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https:/www.facebook.com/");

        // implicit wait - adding 3 sec timeout. Asking selenium to wait if something is
        // not showing up in the page
        // This implicit wait works for all steps and not just one
        // We need to time the wait accordingly with browser.close(), just so happens
        // that if it is not then still we get error
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        // Now finding element by it's id
        // .SendKeys() function will send some data as input
        driver.findElement(By.id("email")).sendKeys("abc");

        // Finding element by it's name and adding input
        driver.findElement(By.id("pass")).sendKeys("hello123");

        // Finding element by it's class and sending input through click() which will
        // click the button
        driver.findElement(By.name("login")).click();

        // // Using CSS selector to get text of the error message generated
        error = driver.findElement(By.cssSelector("div._9ay7")).getText();
        System.out.println(error);

        driver.close();
    }
}
