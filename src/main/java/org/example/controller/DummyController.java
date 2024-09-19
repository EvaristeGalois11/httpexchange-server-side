package org.example.controller;


import org.example.dto.AbstractPing;
import org.example.dto.PingDto;
import org.example.exchange.DummyExchange;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController implements DummyExchange {
  @Override
  public String ping() {
    return "ping";
  }

  @Override
  public PingDto pingDto() {
    return new PingDto("ping", 0);
  }

  @Override
  public PingDto pingDtoParam(PingDto pingDto) {
    return new PingDto(pingDto.value(), pingDto.num());
  }

  @Override
  public AbstractPing pingDtoInterface() {
    return new PingDto("ping", 0);
  }
}
