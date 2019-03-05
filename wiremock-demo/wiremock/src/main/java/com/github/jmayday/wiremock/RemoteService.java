package com.github.jmayday.wiremock;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static reactor.core.publisher.Mono.empty;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class RemoteService {

  private WebClient client;
  private String url;

  @Autowired
  RemoteService(WebClient client, @Value("${remote.url}") String url) {
    this.client = client;
    this.url = url;

  }

  public Mono<RemoteServiceResponse> retrieve(long id) {
    return client
        .get()
        .uri(url, Map.of("resourceId", id))
        .retrieve()
        .onStatus(NOT_FOUND::equals, clientResponse -> empty())
//        .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono
//            .error(new RemoteServerErrorException(
//                format("Cannot get currency. Service response: %s",
//                    clientResponse.statusCode().getReasonPhrase()),
//                ErrorCode.DOCUMENT_GLOBAL_SETTINGS_NOT_FOUND)))
        .bodyToMono(RemoteServiceResponse.class);
  }

}
