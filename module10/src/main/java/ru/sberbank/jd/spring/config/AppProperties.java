package ru.sberbank.jd.spring.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class AppProperties {
    private String value;
    private ClientServiceProperties clientService;

    @Getter
    @Setter
    static public class ClientServiceProperties {
        private String url;
        private String stubMode;
    }
}
