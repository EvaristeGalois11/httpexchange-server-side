package org.example.config;

import org.example.dto.PingDto;
import org.springframework.core.MethodParameter;
import org.springframework.web.service.invoker.HttpRequestValues;
import org.springframework.web.service.invoker.HttpServiceArgumentResolver;

public class PingDtoArgumentResolver implements HttpServiceArgumentResolver {
  @Override
  public boolean resolve(
      Object argument, MethodParameter parameter, HttpRequestValues.Builder requestValues) {
    if (argument instanceof PingDto pingDto) {
      requestValues.addRequestParameter("value", pingDto.value());
      requestValues.addRequestParameter("num", String.valueOf(pingDto.num()));
      return true;
    } else {
      return false;
    }
  }
}
