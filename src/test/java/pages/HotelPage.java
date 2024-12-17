package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public class HotelPage {
//    private final SelenideElement name = $x("//div[@data-capla-component-boundary='b-property-web-property-page/PropertyHeaderName']/h2");

   private final SelenideElement name = $x("//div[@class='hp__hotel-title pp-header']//h2");
//    private final SelenideElement name = $(By.className("d2fee87262 pp-header__title"));
    private final ElementsCollection stars = $$(By.xpath("//span[@data-testid='rating-stars']/span"));
    private final SelenideElement averageRating = $(By.xpath("//div[@data-testid='review-score-right-component']/div"));
    private final SelenideElement countOfReview = $(By.xpath("//div[@data-testid='review-score-right-component']/div[2]/div[2]"));
    private final SelenideElement cost = $(By.xpath("//span[@class='prco-valign-middle-helper']"));

    public HotelPage compareInfo(ArrayList<String> info, ArrayList<String> info2){
        switchTo().window(1);
        info.add(name.getText());
        info.add(String.valueOf(stars.size()));
        String rating = averageRating.getText();
        info.add(rating.substring(rating.length()-3));
        info.add(countOfReview.getText());
        info.add(cost.getText());
        System.out.println(info);
        assert info.equals(info2);
        return this;
    }

}
