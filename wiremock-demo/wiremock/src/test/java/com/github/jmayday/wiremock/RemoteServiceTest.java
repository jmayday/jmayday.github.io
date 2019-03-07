package com.github.jmayday.wiremock;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


public class RemoteServiceTest {

  private RemoteService testedService;
  private WireMockServer wireMockServer;

  @BeforeEach
  void beforeEach() {

    wireMockServer = new WireMockServer(options()
        .dynamicPort()
        .notifier(new ConsoleNotifier(true))
    );
    wireMockServer.start();
    testedService = new RemoteService(getWebclient(wireMockServer.baseUrl()), "/api/resources/{resourceId}");
  }

  @AfterEach
  void afterAll() {
    if(wireMockServer.isRunning())
      wireMockServer.stop();
  }

  @Test
  void shouldGetSomething() {

    wireMockServer.stubFor(get("/api/resources/123")
        .willReturn(aResponse()
            .withHeader("Content-Type", "application/json")
            .withStatus(200)
            .withBody("{\"data\":\"Hello world!\"}")));

    Mono<RemoteServiceResponse> retrieve = testedService.retrieve("123");

    Optional<RemoteServiceResponse> actual = retrieve.blockOptional();

    Assertions.assertThat(actual).isPresent().hasValueSatisfying(c -> {
      Assertions.assertThat(c.data).isEqualTo("Hello world!");
    });
  }

  @Test
  void shouldRetrieveResource() {
    Mono<RemoteServiceResponse> retrieve = testedService.retrieve("1");

    Optional<RemoteServiceResponse> actual = retrieve.blockOptional();

    Assertions.assertThat(actual).isPresent().hasValueSatisfying(c -> {
      Assertions.assertThat(c.data).isEqualTo("this is my data for id 1");
    });
  }


  WebClient getWebclient(String baseUrl) {
    return WebClient.builder()
        .baseUrl(baseUrl)
        .build();
  }

}
