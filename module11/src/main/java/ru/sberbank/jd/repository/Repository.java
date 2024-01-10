package ru.sberbank.jd.repository;

import java.util.Optional;

public interface Repository<T, K> {
    T save(T t);

    Optional<T> findById(K k);
}
