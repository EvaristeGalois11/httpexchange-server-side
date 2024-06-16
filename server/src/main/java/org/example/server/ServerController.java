package org.example.server;

import org.example.sdk.ServerExchange;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController implements ServerExchange {
    @Override
    public String ping() {
        return "ping";
    }
}
