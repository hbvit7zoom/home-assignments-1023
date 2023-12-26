package ru.sberbank.jd;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.sberbank.jd.spring.A;

@SpringBootApplication
@RequiredArgsConstructor
public class App {
    private final A a;
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

    @PostConstruct
    public void start() {
        a.doA();
    }
}
