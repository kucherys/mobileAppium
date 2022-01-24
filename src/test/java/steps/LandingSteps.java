package steps;

import PageObjects.o1.LandingPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import tests.TestBase;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LandingSteps extends TestBase {

    LandingPage landingPage;

    @Given("Appium server with {string} real application is running")
    public void setUpRyse(String appType) throws IOException, InterruptedException {
        System.out.println(appType + " TESTS RUNNING IN CUCUMBER");
//        startServer();
        if (appType.equals("Android")) {
            Android_setUpRyse("digibank-0.0.133-googleDebug.apk");
        } else if (appType.equals("iOS")) {
            iOS_setUpRyse();
        }
        System.out.println(appType + " EMULATOR STARTED");
    }

    @When("I verify landing page is loaded")
    public void verifyLandingPageLoaded() {
        landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isLoaded());
    }

    @Then("I verify elements on landing page")
    public void verifyElementsLandingDataPage(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            landingPage.verifyLogInButton(row.get("logInButton"));
            landingPage.verifyWelcomeLabel(row.get("logoLabel"));
            landingPage.verifySignUpButton(row.get("signUpButton"));
        }
    }

    @When("I print login button name")
    public void printButtonName() {
        landingPage = new LandingPage(driver);
        System.out.println("BUTTON NAME IS : " + landingPage.getLogInButtonName());

    }

    @When("I print SignIn button name")
    public void printSignInButtonName() {
        landingPage = new LandingPage(driver);
        System.out.println("BUTTON NAME IS : " + landingPage.getSignInButtonName());

    }

    @Then("I confirm tests completed with result {string}")
    public void confitmTests(String result) {
        System.out.println("CUCUMBER TESTS PASSED WITH RESULT: " + result);

    }

    @Then("Test completed successfully")
    public void taskAddedSuccessfully() {
        driver.hideKeyboard();
        tearDown();
    }

    @After
    public void stopAppiumServer() {
        System.out.println("Stop appium server form INITIAL STEPS CLASS");
//        service.stop();
    }
}
