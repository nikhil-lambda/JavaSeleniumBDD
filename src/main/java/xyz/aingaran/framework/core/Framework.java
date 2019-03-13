package xyz.aingaran.framework.core;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


/**
 * Core class that manages Driver.
 * All functions inside this will and should be static.
 */
public class Framework {

    private static final Logger logger = Logger.getLogger(Framework.class);

    private static WebDriver webDriver = null;

    private Framework() {
        // Private constructor to hide the default implicit constructor.
        // This class should not be used as an instance.
    }

    public static void init() throws Exception {

        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("platform", "WIN10");
        capability.setCapability("browserName", "chrome");
        capability.setCapability("version", "71.0");
        capability.setCapability("network", true);
        capability.setCapability("exception", true);
        capability.setCapability("visual", true);
        capability.setCapability("console", true);
        capability.setCapability("video", true);
        capability.setCapability("idleTimeout", 40);


        webDriver = new RemoteWebDriver(new URL("http://{username}:{token}@hub.lambdatest.com/wd/hub"), capability);
        webDriver.manage().window().maximize();
    }

    public static WebDriver getWebDriver()  {
        if (null == webDriver)  {
            try{
                init();
                return webDriver;
            }catch (Exception ex){
                logger.error("Driver not initilzed", ex);
            }
            return webDriver;
        } else  {
            return webDriver;
        }
    }

    public static byte[] takeScreenShot(String scenario, String testCase) {
        File shot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(shot, new File("src/test/resources/screenshot/" + LocalDate.now()
                    + File.separator + scenario + File.separator + testCase + ".jpeg"));
        } catch (IOException ioException)   {
            logger.error("Cannot save screenshot", ioException);
        }
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public static void destroy()    {
        if(null != webDriver)   {
            webDriver.close();
            webDriver.quit();
            webDriver = null;
        }
    }
}
