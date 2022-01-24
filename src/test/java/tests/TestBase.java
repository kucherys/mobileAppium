package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests {

    public static AppiumDriver driver;
    public static AppiumDriverLocalService service;

    public static AppiumDriverLocalService startServer() {
        boolean flag = checkIfServerIsRunning(4723);
        if (!flag) {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;
    }

    public static boolean checkIfServerIsRunning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public static void StartAndroidEmulator() throws IOException, InterruptedException {
        Runtime.getRuntime().exec(System.getProperty("user.dir") + "//src//main//resources//startEmulator.sh");
        Thread.sleep(6000);
    }

    public static void Android_setUpRyse(String appName) throws IOException, InterruptedException {
        File appDir = new File("src");
        File app = new File(appDir, appName);
        DesiredCapabilities cap = new DesiredCapabilities();
//        StartAndroidEmulator();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability("adbExecTimeout", 50000);
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void iOS_setUpRyse() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.2");
        capabilities.setCapability("deviceName", "iPhone 12");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("isHeadless", true);
        capabilities.setCapability("showXcodeLog", true);
        capabilities.setCapability("app",
                System.getProperty("user.dir") + "/apps/iOS/Digibank.app");
        capabilities.setCapability("wdaStartupRetries", "4");
        capabilities.setCapability("iosInstallPause", "8000");
        capabilities.setCapability("wdaStartupRetryInterval", "20000");
        System.out.println("BEFORE SIMULATOR STARTED");
        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
        System.out.println("AFTER SIMULATOR STARTED");
    }

    public static void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
