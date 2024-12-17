package tests;

import com.aventstack.extentreports.ExtentTest;
import com.codeborne.selenide.Condition;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.HomePage;
import pages.HotelPage;
import pages.MapPage;
import pages.SearchPage;
import utils.ExtentReportsManager;

import java.util.ArrayList;

public class TestBooking extends BaseTest {
    private ExtentTest test;

    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();

    private final String city = "Анталья";

    @BeforeClass
    public static void setUp() {
        ExtentReportsManager.initReport();
    }

    @Test
    public void testRating() {
        ExtentReportsManager.initReport();
        test = ExtentReportsManager.createTest("TestBooking");
        homePage.openHomePage().acceptCookies().hideMenu().chooseCity(city).searchHotels();
        searchPage.checkCityName(city).hideMenu().setStarFilter().hideMenu().checkHotelStar();
        ExtentReportsManager.flushReport();
    }


}
