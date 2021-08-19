package utils;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HeaderUtils {

    protected List<Header> defaultHeaders = new ArrayList<>();
    protected Headers headers = null;

    public void setDefaultHeaders() {
        defaultHeaders.clear();
        defaultHeaders.add(new Header("X-CMC_PRO_API_KEY", "0f5ac2c0-10dd-4f6e-8d93-1cce3f477557"));
        defaultHeaders.add(new Header("Accept", "application/json"));
        headers = new Headers(defaultHeaders);
    }

    public Headers getHeader() {
        setDefaultHeaders();
        return headers;
    }
}
