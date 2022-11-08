import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CurrencyConverterPage;
import static data.DataConstsPaths.*;

public class CurrencyConverterTest extends BaseTest {

    @Test
    public void exchangeCurrencyRateTest() {
        CurrencyConverterPage currencyConverterPage = new CurrencyConverterPage(driver, CURRENCY_CONVERTER_PATH);
        currencyConverterPage.closeAd();
        currencyConverterPage.getGiveInput().clear();
        currencyConverterPage.getGiveInput().sendKeys(CURRENCY_AMOUNT+"");
        currencyConverterPage.chooseGivenCurrency();
        currencyConverterPage.chooseTakenCurrency();
        Assert.assertTrue(getNbuCurrencyRateAmount()==currencyConverterPage.getTakenCurrencyAmount());
    }
}
