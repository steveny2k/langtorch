package ai.knowly.langtorch.llm.cohere;

import ai.knowly.langtorch.llm.cohere.schema.CohereGenerateRequest;
import ai.knowly.langtorch.llm.cohere.schema.CohereGenerateResponse;
import ai.knowly.langtorch.llm.cohere.schema.dto.embedding.EmbeddingRequest;
import ai.knowly.langtorch.llm.cohere.schema.dto.embedding.EmbeddingResult;
import com.google.common.util.concurrent.ListenableFuture;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CohereAIApi {
  @POST("/v1/generate")
  ListenableFuture<CohereGenerateResponse> generate(@Body CohereGenerateRequest request);

  @POST("/v1/embed")
  ListenableFuture<EmbeddingResult> createEmbeddings(@Body EmbeddingRequest request);
}
