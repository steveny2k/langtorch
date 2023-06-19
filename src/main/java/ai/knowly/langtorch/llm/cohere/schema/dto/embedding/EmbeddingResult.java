package ai.knowly.langtorch.llm.cohere.schema.dto.embedding;

import ai.knowly.langtorch.llm.openai.schema.dto.Usage;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.Set;

/**
 * An object containing a response from the answer api
 *
 * <p>https://beta.openai.com/docs/api-reference/embeddings/create  //todo: use Cohere link
 */
@Data
public class EmbeddingResult {
  String id;

  Set<String> texts;

  /** A list of the calculated embedding */
//  @JsonProperty("embeddings")
  Set<Set<Float>> embeddings;
  private Meta meta;

  @Getter
  public static class ApiVersion {
    private String version;
    private Boolean is_deprecated;
    private Boolean is_experimental;
  }

  @Getter
  public static class Meta {
    @SerializedName("api_version")
    private ApiVersion apiVersion;
    private Set<String> warnings;
  }
}
