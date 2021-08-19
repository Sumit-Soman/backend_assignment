package domain.dto.cryptocurrency.info;

import domain.dto.cryptocurrency.map.StatusDto;
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
public class CryptoCurrencyInfoResDTO {
    private StatusDto status;
    private Map<String, DataDto> data = new LinkedHashMap<>();
}
