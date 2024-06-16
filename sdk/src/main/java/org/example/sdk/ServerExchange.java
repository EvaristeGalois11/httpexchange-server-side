package org.example.sdk;

import org.springframework.web.service.annotation.GetExchange;

public interface ServerExchange {
    @GetExchange("ping")
    String ping();
}
