package ai.knowly.langtorch.llm.cohere;

import ai.knowly.langtorch.llm.cohere.schema.dto.embedding.Embedding;
import ai.knowly.langtorch.llm.cohere.schema.dto.embedding.EmbeddingRequest;
import ai.knowly.langtorch.llm.cohere.schema.dto.embedding.EmbeddingResult;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnabledIf("ai.knowly.langtorch.util.TestingSettingUtils#enableCohereLLMServiceLiveTrafficTest")
class EmbeddingTest {
  @Inject private CohereAIService service;

  @BeforeEach
  void setUp() {
    Guice.createInjector(BoundFieldModule.of(this), new CohereServiceConfigTestingModule())
        .injectMembers(this);
  }

  @Test
  void createEmbeddings() {
    EmbeddingRequest embeddingRequest = EmbeddingRequest.builder()
//            .model("embed-english-v2.0")
            .texts(new HashSet<>(Arrays.asList("hello", "goodbye")))
            .truncate("END")
            .build();

//    List<Embedding> embeddings = service.createEmbeddings(embeddingRequest).getEmbeddings();

    EmbeddingResult embeddingResult = service.createEmbeddings(embeddingRequest);

    assertNotNull(embeddingResult);
    assertFalse(embeddingResult.getEmbeddings().isEmpty());
//    assertFalse(embeddingResult.getEmbeddings().getValues().get(0).isNaN());
  }
}
