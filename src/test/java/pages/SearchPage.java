package pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {
    private final SelenideElement cityName = $(By.tagName("h1"));
    private final SelenideElement starFilter = $(By.xpath("//div[@data-filters-item='class:class=5']"));
    private final ElementsCollection hotelRatingStar = $$(By.xpath("//div[@data-testid='rating-stars']"));
    private final SelenideElement hideMenuButton = $(By.xpath("//button[@aria-label='Скрыть меню входа в аккаунт.']"));
    private final SelenideElement showMapButton = $(By.xpath("//button[@data-map-trigger-button='1']"));


    public SearchPage checkCityName(String city){
        cityName.shouldHave(Condition.text(city));
        return this;
    }

    public SearchPage setStarFilter(){
        starFilter.scrollTo().click();
        return this;
    }

    public SearchPage checkHotelStar(){
        hotelRatingStar.stream().forEach(a->a.findAll(By.tagName("span")).shouldHave(CollectionCondition.size(5)));
        return this;

    }

//    public SearchPage hideMenu() {
//        if(hideMenuButton.is(Condition.visible)){
//            hideMenuButton.click();
//        }
//        return this;
//    }

    public SearchPage hideMenu() {
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

    public SearchPage showMap(){
        showMapButton.click();
        return this;
    }
}
