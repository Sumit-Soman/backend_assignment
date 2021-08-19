package domain.dto.cryptocurrency.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlsDto {
    List<String> website = new ArrayList<>();
    List<String> twitter = new ArrayList<>();
    List<String> message_board = new ArrayList<>();
    List<String> chat = new ArrayList<>();
    List<String> explorer = new ArrayList<>();
    List<String> reddit = new ArrayList<>();
    List<String> technical_doc = new ArrayList<>();
    List<String> source_code = new ArrayList<>();
    List<String> announcement = new ArrayList<>();
}
