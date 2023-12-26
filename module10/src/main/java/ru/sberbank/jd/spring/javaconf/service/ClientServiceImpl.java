package ru.sberbank.jd.spring.javaconf.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.spring.config.AppProperties;

@Slf4j
public class ClientServiceImpl implements ClientService {

    private final AppProperties appProperties;

    public ClientServiceImpl(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @Override
    public String getClient() {
        log.info("ClientServiceStubImpl");
        return null;
    }

    @Override
    public String createClient(String id, String name) {
        return null;
    }

    @PostConstruct
    public void post() {
        log.info("ClientServiceImpl");
    }
}
