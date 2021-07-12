package com.usa.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
          private Driver() {
        } // singleton class

        static WebDriver driver;

        public static WebDriver getDriver() {
            if (driver == null) {
                String tarayici = ConfigurationReader.getProperty("browser"); // chrome
                switch (tarayici) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    case "ie":
                        WebDriverManager.iedriver().setup();
                        driver = new InternetExplorerDriver();
                        break;
                    case "safari":
                        WebDriverManager.getInstance(SafariDriver.class).setup();
                        driver = new SafariDriver();
                        break;
                    case "opera":
                        WebDriverManager.operadriver().setup();
                        driver = new OperaDriver();
                        break;
                }
            }
            return driver;
        }

        public static void closeDriver() {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }
    }


