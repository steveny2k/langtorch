package ai.knowly.langtorch.llm.cohere.schema.dto.embedding;

import lombok.*;

import java.util.List;

/**
 * Creates an embedding vector representing the input text.
 *
 * <p>https://beta.openai.com/docs/api-reference/embeddings/create  //todo: use cohere link
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmbeddingRequest {
  /**
   * Input text to get embedding for, encoded as a string or array of tokens. To get embedding for
   * multiple inputs in a single request, pass an array of strings or array of token arrays. Each
   * input must not exceed 2048 tokens in length.
   *
   * <p>Unless you are embedding code, we suggest replacing newlines (\n) in your input with a
   * single space, as we have observed inferior results when newlines are present.
   */
  @NonNull List<String> texts;

  /** The name of the model to use. Required if using the new v1/embedding endpoint. */
  String model;

  /**
   * One of NONE|START|END to specify how the API will handle inputs longer than the maximum token length.
   * Default is NONE.
   */
  String truncate;
}
