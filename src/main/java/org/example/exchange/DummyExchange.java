package org.example.exchange;

import org.example.dto.AbstractPing;
import org.example.dto.PingDto;
import org.springframework.web.service.annotation.GetExchange;

public interface DummyExchange {
  @GetExchange("ping")
  String ping();

  @GetExchange("ping-dto")
  PingDto pingDto();

  @GetExchange("ping-dto-param")
  PingDto pingDtoParam(PingDto pingDto);

  @GetExchange("ping-dto-interface")
  AbstractPing pingDtoInterface();
}
