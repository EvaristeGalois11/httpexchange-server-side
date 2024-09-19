package org.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import org.example.dto.AbstractPing;
import org.example.dto.PingDto;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class AbstractPingMessageConverter implements HttpMessageConverter<AbstractPing> {
  private final ObjectMapper mapper = new ObjectMapper();

  @Override
  public boolean canRead(Class<?> clazz, MediaType mediaType) {
    return clazz.isAssignableFrom(AbstractPing.class);
  }

  @Override
  public boolean canWrite(Class<?> clazz, MediaType mediaType) {
    return false;
  }

  @Override
  public List<MediaType> getSupportedMediaTypes() {
    return List.of(MediaType.APPLICATION_JSON);
  }

  @Override
  public AbstractPing read(Class<? extends AbstractPing> clazz, HttpInputMessage inputMessage)
      throws IOException, HttpMessageNotReadableException {
    return mapper.readValue(inputMessage.getBody(), PingDto.class);
  }

  @Override
  public void write(
      AbstractPing abstractPing, MediaType contentType, HttpOutputMessage outputMessage)
      throws IOException, HttpMessageNotWritableException {}
}
