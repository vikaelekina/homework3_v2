package tests;


import com.codeborne.selenide.Selenide;
import org.junit.*;
import com.aventstack.extentreports.ExtentTest;
import utils.ExtentReportsManager;


public class BaseTest {
//    @Before
//    public void setUp() {
//        ExtentReportsManager.initReport();
//    }

    @After
    public void turnDown() {
        Selenide.closeWebDriver();
    }
}
