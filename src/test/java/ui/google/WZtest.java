package ui.google;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class WZtest {

    @Test
    public void test1() {
        Configuration.timeout = 30000;
        Configuration.browser = "firefox";
        Configuration.baseUrl = "https://wizzair.com/";

        open("/");
        $("#search-departure-station").setValue("Vienna");
        $x("//mark[contains(text(),'Vienna')]").click();
        $("#search-arrival-station").setValue("Kyiv - Zhulyany");
        $x("//mark[contains(text(),'Kyiv - Zhulyany')]").click();

        $("#search-departure-date").click();
        $x("//button[@data-pika-year='2021'][@data-pika-month='1'][@data-pika-day='12']").click();
        $x("//button[@data-pika-year='2021'][@data-pika-month='1'][@data-pika-day='19']").click();
        $x("//button[@data-test='calendar-shrinkable-ok-button']").click();

        $("#search-passenger").click();
        $(".stepper__button.stepper__button--add").click();
        $x("//button[@data-test='flight-search-hide-panel']").click();

        $x("//span[contains(text(),'Search')]").click();

        switchTo().window(1);
//        switchTo().window("\n1\tOfficial Wizz Air website | Book direct for the best prices ");

        $$x("//div[@class='flight-select__fare-selector transition-fade-in transition-zoom-in transition-fade-in-enter transition-zoom-in-enter']").shouldHaveSize(2);
        //        $x("//time[@class='flight-select__flight-info__day']").shouldHave(Condition.text("8 Jun 2020"));
        $$x("//time[@class='flight-select__flight-info__day']").get(0).shouldHave(Condition.text(" Fri, 12 Feb 2021 "));
        //        $x("//time[@class='flight-select__flight-info__day'][2]").shouldHave(Condition.text("11 Jun 2020"));
        $$x("//time[@class='flight-select__flight-info__day']").get(1).shouldHave(Condition.text(" Fri, 19 Feb 2021 "));
    }
}
