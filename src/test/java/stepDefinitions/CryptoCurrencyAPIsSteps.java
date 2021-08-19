package stepDefinitions;

import domain.dto.cryptocurrency.info.CryptoCurrencyInfoResDTO;
import domain.dto.cryptocurrency.map.CryptoCurrencyMapRespDto;
import domain.dto.cryptocurrency.map.DataDto;
import domain.dto.tools.price.CryptoCurrencyPriceConversionResDto;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logger.Log;
import org.apache.http.HttpStatus;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CryptoCurrencyAPIsSteps extends BaseSteps {

    @When("I retrieve cryptocurrencies")
    public void iRetrieveCryptocurrencies() {
        whenIRetrieveCurrencyMap();
    }

    @When("I retrieve Ethereum info")
    public void iRetrieveEthereumInfo() {
        MultiValueMap<String, String> queryParam = new LinkedMultiValueMap<>();
        queryParam.set("symbol","ETH" );

        whenIRetrieveCurrencyInfoFor(queryParam);
    }

    @When("I retrieve currency info for first {int} Ids")
    public void iRetrieveCurrencyInfoForFirstIds(int limit) {
        MultiValueMap<String, String> queryParam = new LinkedMultiValueMap<>();
        queryParam.set("id", IntStream.range(1, limit + 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(",")));

        whenIRetrieveCurrencyInfoFor(queryParam);
    }

    @Then("I convert {string} amount to Bolivian Boliviano {string} for below currencies")
    public void iConvertAmountToBolivianBolivianoForBelowCurrencies(String amount, String convertToSymbol, DataTable dataTable) {
        final Map<Integer, Float> currencyPrice =  new HashMap<>();
        MultiValueMap<String, String> queryParam = generateDefaultQuery(amount, convertToSymbol);

        List<String> currencies = dataTable.asList(String.class);

        currenciesIds = getCurrencyIds(currencies);

        // call price conversion service with different currency ids and storing it in hashmap
        currenciesIds.forEach(currency -> {
            // update current ID
            queryParam.set("id", Integer.toString(currency));

            // call price-conversion api passing the query params
            whenICallPriceConversionWith(queryParam);

            // asserting the conversion price quote object is present
            Assert.assertNotNull(cryptoCurrencyPriceConversion
                    .getData().getQuote()
                    .get(convertToSymbol));
            // storing the price for the conversion in hashmap with currency id and price
            currencyPrice.put(currency, fetchPrice(convertToSymbol));
        });

        Log.info("Currency Price conversion output : "+ currencyPrice);
    }

    private List<Integer> getCurrencyIds(List<String> currencies) {
        return cryptoCurrencyMapRespDto
                .getData()
                .stream()
                .filter(dataDto -> currencies.stream()
                        .anyMatch(s -> s.equals(dataDto.getSymbol())))
                .map(DataDto::getId)
                .collect(Collectors.toList());
    }
    private void whenIRetrieveCurrencyMap() {
        response = cryptocurrencyProcessor.getMapCall
                .apply(requestBuilder.cryptoCurrencyMapBuilder
                        .apply(headerUtils.getHeader()));

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        cryptoCurrencyMapRespDto = response.getBody().as(CryptoCurrencyMapRespDto.class);
    }

    private void whenIRetrieveCurrencyInfoFor(MultiValueMap<String, String> queryParam) {
        response = cryptocurrencyProcessor.getInfoCall.apply(requestBuilder
                        .getCryptoCurrencyInfoBuilder
                        .apply(queryParam, headerUtils.getHeader()));

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        cryptoCurrencyInfoResDTO = response.getBody().as(CryptoCurrencyInfoResDTO.class);
    }

    @Then("I see logo url for {string} as")
    public void iSeeLogoUrlAs(String currency, DataTable dataTable) {
        List<String> logoUrl = dataTable.asList(String.class);

        Assert.assertEquals(logoUrl.get(0), cryptoCurrencyInfoResDTO.getData()
                .get(currency)
                .getLogo());
    }

    @And("I see Technical doc url for {string} as")
    public void iSeeTechnicalDocUrlForAs(String currency, DataTable dataTable) {
        List<String> technicalDocUrl = dataTable.asList(String.class);

        Assert.assertTrue(cryptoCurrencyInfoResDTO.getData()
                .get(currency)
                .getUrls()
                .getTechnical_doc()
                .stream()
                .anyMatch(s -> s.contains(technicalDocUrl.get(0))));
    }

    @And("I see the currency symbol as {string}")
    public void iSeeTheCurrencySymbolAs(String currencySymbol) {
        Assert.assertEquals(currencySymbol, cryptoCurrencyInfoResDTO
                .getData()
                .get(currencySymbol)
                .getSymbol());
    }

    @And("I see the data for {string} as {string}")
    public void iSeeTheDataForAs(String currency, String dateAdded) {
        Assert.assertEquals(dateAdded, cryptoCurrencyInfoResDTO
                .getData()
                .get(currency)
                .getDate_added());
    }

    @And("I see {string} tag available for {string}")
    public void iSeeTagAvailableFor(String tag, String currency) {
        Assert.assertTrue(cryptoCurrencyInfoResDTO
                .getData()
                .get(currency)
                .getTags().stream().anyMatch(s -> s.contains(tag)));
    }

    @Then("I see {string} tag available for all {int} currencies")
    public void iSeeTagAvailableForAllCurrencies(String tag, int limit) {
        IntStream.range(1, limit + 1)
                .forEach(value -> Assert.assertTrue(cryptoCurrencyInfoResDTO
                            .getData()
                            .get(String.valueOf(value))
                            .getTags()
                            .stream().anyMatch(s -> s.contains(tag)))
                );

    }

    @And("I see the correct ID's retrieved for first {int} currencies")
    public void iSeeTheCorrectIDSRetrievedForFirstCurrencies(int limit) {
        IntStream.range(1, limit + 1)
            .forEach(value -> Assert.assertEquals(cryptoCurrencyInfoResDTO
                    .getData()
                    .get(String.valueOf(value))
                    .getId(), value)
            );
    }

    public void whenICallPriceConversionWith(MultiValueMap<String, String> queryParam) {
        response = priceConversionProcessor
                .getPriceConversionCall(requestBuilder
                        .getPriceConversionBuilder
                        .apply(queryParam, headerUtils.getHeader()));

        // verify the service response status as OK
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        // deserialize the response to CryptoCurrencyPriceConversion DTO
        cryptoCurrencyPriceConversion = response.getBody().as(CryptoCurrencyPriceConversionResDto.class);
    }

    public Float fetchPrice(String convertToSymbol) {
        return Float.parseFloat(cryptoCurrencyPriceConversion
                .getData().getQuote()
                .get(convertToSymbol)
                .getPrice());
    }

    public MultiValueMap<String, String> generateDefaultQuery(String amount, String convertToSymbol) {
        MultiValueMap<String, String> queryParam = new LinkedMultiValueMap<>();

        queryParam.add("amount", amount);
        queryParam.add("id", "");
        queryParam.add("convert", convertToSymbol);
        return queryParam;
    }
}