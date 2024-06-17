package org.example.server;

import org.example.sdk.ServerExchange;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ServerController implements ServerExchange {
    @Override
    public String ping() {
        return "ping";
    }

    @Override
    public String echo(String echo) {
        return echo + "@" + UUID.randomUUID();
    }
}
