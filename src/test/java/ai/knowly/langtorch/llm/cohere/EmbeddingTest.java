package ai.knowly.langtorch.llm.cohere;

import ai.knowly.langtorch.llm.cohere.schema.dto.embedding.Embedding;
import ai.knowly.langtorch.llm.cohere.schema.dto.embedding.EmbeddingRequest;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

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
            .texts(Collections.singletonList("hello"))
            .truncate("END")
            .build();

    List<Embedding> embeddings = service.createEmbeddings(embeddingRequest).getEmbeddings();

    assertFalse(embeddings.isEmpty());
    assertFalse(embeddings.get(0).getValues().get(0).isNaN());
  }
}
