package ru.sberbank.jd.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import ru.sberbank.jd.spring.javaconf.service.AppService;
import ru.sberbank.jd.spring.javaconf.service.ClientService;
import ru.sberbank.jd.spring.javaconf.service.ClientServiceImpl;
import ru.sberbank.jd.spring.javaconf.service.ClientServiceStubImpl;

@Configuration
@EnableConfigurationProperties(value = AppProperties.class)
public class AppConfig {

    @Value("${app.client-service.url}")
    private String value;

    @Bean
    @Profile("!dev")
//    @Primary
    public ClientService clientServiceImpl(AppProperties appProperties) {
        return new ClientServiceImpl(appProperties);
    }

    @Bean
    @Profile("dev")
    public ClientService clientServiceStubImpl() {
        return new ClientServiceStubImpl();
    }

//    @Bean
//    public AppService appService(ClientService clientService) {
//        return new AppService(clientService);
//    }
}
