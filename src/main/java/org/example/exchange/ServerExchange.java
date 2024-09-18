package org.example.exchange;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PutExchange;

public interface ServerExchange {
    @GetExchange("ping")
    String ping();

    @PutExchange("echo")
    String echo(@RequestParam String echo);
}
