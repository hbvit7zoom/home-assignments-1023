package ru.sberbank.jd.repository;

import ru.sberbank.jd.model.Operation;

public interface CalculatorRepository {
    public Operation save(Operation op);
}
