package pages;

import data.DataConstsPaths;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CurrencyConverterPage extends BasePage {
    @FindBy(css = "input[name='give']")
    WebElement giveInput;
    @FindBy(css = "ul.converter-min_currency-list.rateC.typeC")
    WebElement giveCurrency;
    String givenCurrencyChoosePath = ".converter-min_currency-list.rateC.typeC li[data-type='"+ DataConstsPaths.GIVEN_CURRENCY+"']";
    WebElement giveCurrencyChoose;
    @FindBy(css = "input[name='take']")
    WebElement take;
    @FindBy(css = ".converter-min_currency-list.rateR.typeR")
    WebElement takeCurrency;
    String takenCurrencyChoosePath = ".converter-min_currency-list.rateR.typeR li[data-type='"+ DataConstsPaths.TAKEN_CURRENCY+"']";
    @FindBy(css = ".swal2-container.swal2-center.swal2-backdrop-show")
    WebElement takeCurrencyChoose;
    @FindBy(css = ".swal2-cancel")
    WebElement advertisementCloseBtn;

    public CurrencyConverterPage(WebDriver driver, String path) {
        super(driver, path);
    }

    public WebElement getGiveInput() {
        return giveInput;
    }

    public double getTakenCurrencyAmount() {
        double temp = Double.parseDouble(take.getAttribute("value"));
        return Double.parseDouble(new DecimalFormat("#.##",new DecimalFormatSymbols(Locale.ENGLISH)).format(temp));
    }

    public void chooseGivenCurrency() {
        giveCurrency.click();
        giveCurrencyChoose = driver.findElement(By.cssSelector(givenCurrencyChoosePath));
        giveCurrencyChoose.click();
    }

    public void chooseTakenCurrency() {
        takeCurrency.click();
        takeCurrencyChoose = driver.findElement(By.cssSelector(takenCurrencyChoosePath));
        takeCurrencyChoose.click();
    }

    public void closeAd(){
        waitGetElement(advertisementCloseBtn).click();
    }
}
