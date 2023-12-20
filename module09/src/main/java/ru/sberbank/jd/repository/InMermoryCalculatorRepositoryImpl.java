package ru.sberbank.jd.repository;

import ru.sberbank.jd.model.Operation;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InMermoryCalculatorRepositoryImpl implements CalculatorRepository {
    private Map<String, Operation> storage = new HashMap<>();

    @Override
    public Operation save(Operation op) {
        op.setId(UUID.randomUUID().toString());
        storage.put(op.getId(), op);
        return op;
    }
}
