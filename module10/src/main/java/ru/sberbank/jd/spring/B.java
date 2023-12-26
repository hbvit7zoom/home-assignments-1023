package ru.sberbank.jd.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class B {
    private String valueB;

    public String getValueB() {
        return valueB;
    }

    public void setValueB(String valueB) {
        this.valueB = valueB;
    }

    public void doB() {
        log.info("doB() invoked, valueB = {}", valueB);
    }
}
