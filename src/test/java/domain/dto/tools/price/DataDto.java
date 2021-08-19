package domain.dto.tools.price;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataDto {
    private int id;
    private String name;
    private String symbol;
    private String amount;
    private String last_updated;
    private Map<String, Quote> quote = new LinkedHashMap<>();
}
