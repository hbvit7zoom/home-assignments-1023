package ru.sberbank.jd.unittesting;

public class ExampleUnitTesting {
}

class A {
    public String doAction(B b) {
        if (b == null) {
            throw new RuntimeException();
        }

        String result = b.doB("Hello!");

        return "A = " + result;
    }
}

class B {
    public String doB(String str) {
        return "B=" + str;
    }
}