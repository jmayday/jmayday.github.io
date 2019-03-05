package com.github.jmayday.wiremock;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.google.common.collect.ImmutableMap;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


public class RemoteServiceTest {

  private RemoteService testedService;
  private static WireMockServer wireMockServer;

  RemoteServiceTest() {

    wireMockServer = new WireMockServer(options()
        .port(8099)
        .notifier(new ConsoleNotifier(true))
    );
    wireMockServer.start();

    testedService = new RemoteService(getWebclient(), "/api/resources/{resourceId}");

  }

  @BeforeEach
  void beforeEach() {
  }

  @AfterAll
  static void afterAll() {
    wireMockServer.stop();
  }

  @Test
  void shouldRetrieveResource() {
    Mono<RemoteServiceResponse> retrieve = testedService.retrieve(1);

    Optional<RemoteServiceResponse> actual = retrieve.blockOptional();

    Assertions.assertThat(actual).isPresent().hasValueSatisfying(c -> {
      Assertions.assertThat(c.data).isEqualTo("this is my data for id 1");
    });
  }


  WebClient getWebclient() {
    return WebClient.builder()
        .baseUrl("http://localhost:8099")
        .build();
  }

}
