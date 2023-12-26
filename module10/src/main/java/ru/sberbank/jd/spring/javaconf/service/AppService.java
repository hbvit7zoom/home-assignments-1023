package ru.sberbank.jd.spring.javaconf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.spring.config.AppProperties;

@Service
@RequiredArgsConstructor
public class AppService {

    private final AppProperties appProperties;

    private final ClientService clientService;

    public void doSmth() {
        clientService.getClient();
    }
}
