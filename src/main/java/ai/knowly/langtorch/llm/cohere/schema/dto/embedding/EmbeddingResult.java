package ai.knowly.langtorch.llm.cohere.schema.dto.embedding;

import ai.knowly.langtorch.llm.openai.schema.dto.Usage;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * An object containing a response from the answer api
 *
 * <p>https://beta.openai.com/docs/api-reference/embeddings/create  //todo: use Cohere link
 */
@Data
public class EmbeddingResult {
  String id;

  List<String> texts;

  /** A list of the calculated embedding */
  @JsonProperty("embeddings")
  List<Embedding> embeddings;
}
