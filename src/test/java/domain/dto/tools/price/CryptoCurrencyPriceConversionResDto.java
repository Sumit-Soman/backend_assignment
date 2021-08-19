package domain.dto.tools.price;

import domain.dto.cryptocurrency.map.StatusDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CryptoCurrencyPriceConversionResDto {
    private StatusDto status;
    private DataDto data;
}
