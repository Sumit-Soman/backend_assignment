package domain.dto;

import io.restassured.http.Headers;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.MultiValueMap;

@Data
@Builder
public class RequestDto {
    private String                        resource;
    private MultiValueMap<String, String> queryParams;
    private Headers headers;
}
