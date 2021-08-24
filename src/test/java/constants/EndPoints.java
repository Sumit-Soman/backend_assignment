package constants;

import java.util.Optional;
import java.util.function.Supplier;

public class EndPoints {

    private static final String baseUrl = Optional
            .ofNullable(System.getProperty("baseUrl"))
            .orElse("https://pro-api.coinmarketcap.com");

    private static final Supplier<String> BASEURL = () ->  baseUrl + EndPointsEnums.V1.getValue();

    public static final Supplier<String> CRYPTOCURRENCYMAPURL = () -> BASEURL.get() + EndPointsEnums.MAP.getValue();

    public static final Supplier<String> PRICECONVERSIONURL = () -> BASEURL.get() + EndPointsEnums.PRICECONVERSIONS.getValue();

    public static final Supplier<String> CRYPTOCURRENCYINFOURL = () -> BASEURL.get() + EndPointsEnums.INFO.getValue();
}
