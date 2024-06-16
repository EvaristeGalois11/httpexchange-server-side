package org.example.client;

import org.example.sdk.ServerExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    public ServerExchange serverExchange(@Value("${server.url}") String serverUrl, RestClient.Builder clientBuilder) {
        return HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(clientBuilder.baseUrl(serverUrl).build()))
                .build()
                .createClient(ServerExchange.class);
    }
}
