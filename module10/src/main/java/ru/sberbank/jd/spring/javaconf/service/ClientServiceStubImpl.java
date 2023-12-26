package ru.sberbank.jd.spring.javaconf.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientServiceStubImpl implements ClientService {
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
        log.info("ClientServiceStubImpl");
    }
}
