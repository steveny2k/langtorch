package ai.knowly.langtorch.llm.cohere.schema.dto.embedding;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * Represents an embedding returned by the embedding api
 *
 * <p>https://beta.openai.com/docs/api-reference/classifications/create //TODO: use cohere link
 */
@Data
public class Embedding {
  /** The embedding vector */
  Set<Float> values;
}
