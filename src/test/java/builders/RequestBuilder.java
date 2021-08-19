package builders;

import constants.EndPoints;
import domain.dto.RequestDto;
import io.restassured.http.Headers;
import org.springframework.util.MultiValueMap;

import java.util.function.BiFunction;
import java.util.function.Function;

public class RequestBuilder {

    public final Function<Headers, RequestDto> cryptoCurrencyMapBuilder = (headers) -> RequestDto
            .builder()
            .resource(EndPoints.CRYPTOCURRENCYMAPURL.get())
            .headers(headers)
            .build();

    public final BiFunction<MultiValueMap<String, String>, Headers, RequestDto> getCryptoCurrencyInfoBuilder = (queryParam, headers) -> RequestDto
            .builder()
            .resource(EndPoints.CRYPTOCURRENCYINFOURL.get())
            .headers(headers)
            .queryParams(queryParam)
            .build();

    public final BiFunction<MultiValueMap<String, String>, Headers, RequestDto> getPriceConversionBuilder = (queryParam, headers) -> RequestDto.builder()
            .resource(EndPoints.PRICECONVERSIONURL.get())
            .headers(headers)
            .queryParams(queryParam)
            .build();
}
