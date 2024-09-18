package org.example.config;

import org.example.exchange.DummyExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ClientConfig {
  private static final Logger logger = LoggerFactory.getLogger(ClientConfig.class);

  @Bean
  public DummyExchange dummyExchange(
      ServletWebServerApplicationContext context, RestClient.Builder builder) {
    var port = context.getWebServer().getPort();
    logger.info("Port: {}", port);
    return HttpServiceProxyFactory.builderFor(
            RestClientAdapter.create(builder.baseUrl("http://localhost:" + port).build()))
        .build()
        .createClient(DummyExchange.class);
  }
}
