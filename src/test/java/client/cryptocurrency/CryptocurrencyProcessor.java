package client.cryptocurrency;

import domain.dto.RequestDto;
import io.restassured.response.Response;
import utils.RestUtil;

import java.util.function.Function;

public class CryptocurrencyProcessor {

    public Function<RequestDto, Response> getMapCall = RestUtil::get;

    public Function<RequestDto, Response> getInfoCall = RestUtil::get;
}
