package ru.sberbank.jd.spring;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class A {
    private Logger log = LoggerFactory.getLogger(A.class);

//    @Autowired
//    @Qualifier(value = "beanName")
    private final B b;

    public void doA() {
        b.doB();
        log.info("doA() invoked");
    }

//    public A(@Qualifier(value = "beanName") B b) {
//        this.b = b;
//    }
}
