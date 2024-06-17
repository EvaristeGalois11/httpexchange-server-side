package org.example.client;

import org.example.sdk.ServerExchange;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    private final ServerExchange serverExchange;

    public ClientController(ServerExchange serverExchange) {
        this.serverExchange = serverExchange;
    }

    @GetMapping("ping")
    public String ping() {
        return serverExchange.ping();
    }

    @GetMapping("echo")
    public String echo() {
        return serverExchange.echo("Hello World!");
    }
}
