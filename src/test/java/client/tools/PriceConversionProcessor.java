package client.tools;

import domain.dto.RequestDto;
import io.restassured.response.Response;
import utils.RestUtil;

public class PriceConversionProcessor {

    public Response getPriceConversionCall(RequestDto requestBuilder) {
        return RestUtil.get(requestBuilder);
    }
}
