package org.example.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.exchange.DummyExchange;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientTest {
  @Autowired private DummyExchange dummyExchange;

  @Test
  void ping() {
    var ping = dummyExchange.ping();
    assertThat(ping).isEqualTo("ping");
  }
}
