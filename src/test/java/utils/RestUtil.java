package utils;

import domain.dto.RequestDto;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import org.springframework.util.LinkedMultiValueMap;

import java.util.Optional;

import static io.restassured.RestAssured.given;

public class RestUtil {

    private static final EncoderConfig encoderconfig = new EncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false);
    private static final RestAssuredConfig restAssuredConfig = RestAssured.config().encoderConfig(encoderconfig);

    public static Response get(RequestDto requestBuilder) {
        return given()
                .config(restAssuredConfig)
                .relaxedHTTPSValidation()
                .headers(requestBuilder.getHeaders())
                .queryParams(Optional.ofNullable(requestBuilder.getQueryParams())
                            .orElse(new LinkedMultiValueMap<>()))
                .log()
                .all()
                .get(requestBuilder.getResource());
    }
}
