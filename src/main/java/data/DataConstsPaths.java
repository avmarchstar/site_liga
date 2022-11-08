package data;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import pojo.CurrencyPojo;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

public class DataConstsPaths {
    //    --------Pathes--------
    public static final String CURRENCY_CONVERTER_PATH = "https://finance.liga.net/currency/converter";
    //    --------Constants--------
    public static final String GIVEN_CURRENCY = "USD";
    public static final String TAKEN_CURRENCY = "UAH";
    public static final Double CURRENCY_AMOUNT = 1000d;

    public static double getNbuCurrencyRateAmount() {
        List<CurrencyPojo> currencyList = RestAssured
                .given()
                .when().contentType(ContentType.JSON)
                .get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchangenew?json")
                .then().extract().body().jsonPath().getList("", CurrencyPojo.class);
        Predicate<CurrencyPojo> predicate = x -> (GIVEN_CURRENCY).equals(x.getCc());
        double rate = currencyList.stream()
                .filter(predicate)
                .map(CurrencyPojo::getRate).toList().get(0);
        return Double.parseDouble(
                new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH))
                        .format(rate*CURRENCY_AMOUNT));
    }
}

