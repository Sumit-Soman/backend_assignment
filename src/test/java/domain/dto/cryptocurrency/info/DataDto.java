package domain.dto.cryptocurrency.info;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class DataDto {
    private float id;
    private String name;
    private String symbol;
    private String category;
    private String description;
    private String slug;
    private String logo;
    private String subreddit;
    private String notice;
    private List<String> tags = new ArrayList<>();
    @JsonProperty("tag-names")
    private List<String> tagNames = new ArrayList<>();
    @JsonProperty("tag-groups")
    private List<String> tagGroups = new ArrayList<>();
    private UrlsDto urls;
    private String platform = null;
    private String date_added;
    private String twitter_username;
    private float is_hidden;
}
