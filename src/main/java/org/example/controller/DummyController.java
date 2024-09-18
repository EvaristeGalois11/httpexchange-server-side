package org.example.controller;

import org.example.exchange.DummyExchange;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DummyController implements DummyExchange {
    @Override
    public String ping() {
        return "ping";
    }

    @Override
    public String echo(String echo) {
        return echo + "@" + UUID.randomUUID();
    }
}
