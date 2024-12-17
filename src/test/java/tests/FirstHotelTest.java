package tests;

import com.aventstack.extentreports.ExtentTest;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.HomePage;
import pages.HotelPage;
import pages.MapPage;
import pages.SearchPage;
import utils.ExtentReportsManager;

import java.util.ArrayList;

public class FirstHotelTest {
    private ExtentTest test;

    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    MapPage mapPage = new MapPage();
    HotelPage hotelPage = new HotelPage();

    private final String city = "Анталья";
    @BeforeClass
    public static void setUp() {
        ExtentReportsManager.initReport();
    }

    @Test
    public void testFirstHotel() {
        ExtentReportsManager.initReport2();
        test = ExtentReportsManager.createTest("FirstHotelTest");
        ArrayList<String> infoMap = new ArrayList<String>();
        ArrayList<String> infoHotel = new ArrayList<String>();
        homePage.openHomePage().acceptCookies().hideMenu().chooseCity(city).chooseData().searchHotels();
        searchPage.checkCityName(city).hideMenu().showMap().hideMenu();
        mapPage.hideMenu().saveInfo(infoMap).openHotel();
        hotelPage.compareInfo(infoHotel,infoMap);
        ExtentReportsManager.flushReport();
    }
}
