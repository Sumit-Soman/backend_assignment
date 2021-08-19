package domain.dto.cryptocurrency.map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataDto {
    private int id;
    private String name;
    private String symbol;
    private String slug;
    private int rank;
    private int is_active;
    private String first_historical_data;
    private String last_historical_data;
    @JsonIgnore
    private String platform;
}
