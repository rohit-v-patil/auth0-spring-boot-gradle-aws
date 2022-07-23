package com.app.testProject.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Slf4j
public class LoggingInterceptor implements ClientHttpRequestInterceptor {

  @Override
  public ClientHttpResponse intercept(HttpRequest request, byte[] body,
                                      ClientHttpRequestExecution execution) throws IOException {
    logRequest(request, body);
    ClientHttpResponse response = execution.execute(request, body);
    logResponse(response);
    return response;
  }

  private static void logRequest(HttpRequest request, byte[] body) throws IOException {
    if (log.isDebugEnabled()) {
      log.debug("URI         : {}", request.getURI());
      log.debug("Method      : {}", request.getMethod());
      log.debug("Headers     : {}", request.getHeaders());
      log.debug("Request Body: {}", new String(body, StandardCharsets.UTF_8));
    }
  }

  private static void logResponse(ClientHttpResponse response) throws IOException {
    if (log.isDebugEnabled()) {
      log.debug("Status Code  : {}", response.getStatusCode());
      log.debug("Status Text  : {}", response.getStatusText());
      log.debug("Headers      : {}", response.getHeaders());
      log.debug("Response Body: {}", StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
    }
  }
}
