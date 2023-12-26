package ru.sberbank.jd.spring.javaconf.service;

public interface ClientService {

    String getClient();
    String createClient(String id, String name);
}
