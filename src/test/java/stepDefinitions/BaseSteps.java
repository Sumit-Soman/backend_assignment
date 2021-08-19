package stepDefinitions;

import builders.RequestBuilder;
import client.cryptocurrency.CryptocurrencyProcessor;
import client.tools.PriceConversionProcessor;
import domain.dto.cryptocurrency.info.CryptoCurrencyInfoResDTO;
import domain.dto.cryptocurrency.map.CryptoCurrencyMapRespDto;
import domain.dto.tools.price.CryptoCurrencyPriceConversionResDto;
import io.restassured.response.Response;
import utils.HeaderUtils;

import java.util.List;

public class BaseSteps {

    protected CryptocurrencyProcessor cryptocurrencyProcessor = new CryptocurrencyProcessor();
    protected PriceConversionProcessor priceConversionProcessor =  new PriceConversionProcessor();
    protected RequestBuilder requestBuilder = new RequestBuilder();
    protected HeaderUtils headerUtils = new HeaderUtils();

    Response response;
    protected CryptoCurrencyMapRespDto cryptoCurrencyMapRespDto;
    protected CryptoCurrencyInfoResDTO cryptoCurrencyInfoResDTO;
    protected CryptoCurrencyPriceConversionResDto cryptoCurrencyPriceConversion;
    protected List<Integer> currenciesIds;
}
