package constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EndPointsEnums {
    V1("/v1/"),
    MAP("cryptocurrency/map"),
    PRICECONVERSIONS("tools/price-conversion"),
    INFO("cryptocurrency/info");

    private final String value;
}
