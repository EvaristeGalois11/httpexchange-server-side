package org.example.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.dto.PingDto;
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

  @Test
  void pingDto() {
    var ping = dummyExchange.pingDto();
    assertThat(ping.value()).isEqualTo("ping");
    assertThat(ping.num()).isZero();
  }

  @Test
  void pingDtoParam() {
    var ping = dummyExchange.pingDtoParam(new PingDto("pong", 1));
    assertThat(ping.value()).isEqualTo("pong");
    assertThat(ping.num()).isOne();
  }

  @Test
  void pingDtoInterface() {
    var ping = dummyExchange.pingDtoInterface();
    assertThat(ping.value()).isEqualTo("ping");
    assertThat(ping.num()).isZero();
  }
}
