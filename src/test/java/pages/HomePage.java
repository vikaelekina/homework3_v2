package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage {
    private final SelenideElement cityField = $(By.name("ss"));
    private final SelenideElement findButton = $(By.xpath("//button[@type='submit']"));
    private final SelenideElement dataButton = $(By.xpath("//div[@data-testid='searchbox-dates-container']"));
    private final ElementsCollection dateStart = $$(By.xpath("//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody/tr/td"));
    private final ElementsCollection dateEnd = $$(By.xpath("//div[@data-testid='searchbox-datepicker-calendar']/div/div[2]/table/tbody/tr/td"));
    private final SelenideElement hideMenuButton = $(By.xpath("//button[@aria-label='Скрыть меню входа в аккаунт.']"));

    private final SelenideElement firstInDropDown = $(By.id("autocomplete-result-0"));
    private final SelenideElement acceptCookiesButton = $(By.id("onetrust-reject-all-handler"));

    public HomePage openHomePage() {
        Selenide.open("https://www.booking.com/");
        return this;
    }

    public HomePage chooseCity(String city) {
        cityField.sendKeys(city);
        $(firstInDropDown).shouldHave(Condition.text(city));
        return this;
    }

    public HomePage acceptCookies() {
        acceptCookiesButton.shouldBe(Condition.visible).click();
        return this;
    }

    public HomePage chooseData() {
        dataButton.click();
        dateStart.get(ThreadLocalRandom.current().nextInt(0, dateStart.size())).click();
        dateEnd.get(ThreadLocalRandom.current().nextInt(0, dateEnd.size())).click();
        return this;
    }

    public HomePage searchHotels() {
        findButton.click();
        return this;
    }

    public HomePage hideMenu() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(hideMenuButton.is(Condition.visible)){
            hideMenuButton.click();
        }
        return this;
    }


}
