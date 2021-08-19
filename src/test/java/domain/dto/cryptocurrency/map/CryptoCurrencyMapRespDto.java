package domain.dto.cryptocurrency.map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CryptoCurrencyMapRespDto {

    private StatusDto status;
    private List<DataDto> data;
}
