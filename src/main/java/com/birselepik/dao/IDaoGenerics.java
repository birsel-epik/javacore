package com.birselepik.dao;

import java.util.List;
import java.util.Optional;

/*
Boş olabilir (Optional.empty())
Bir değer içerebilir (Optional.of(T value))
*/

/*
Java 8, bazı hazır fonksiyonel arayüzler de sunar:

Predicate → boolean test(T t)  → Koşul kontrolleri için.
Function<T, R> → R apply(T t)  → Bir değeri dönüştürmek için.
Consumer → void accept(T t)    → Parametre alır, bir işlem yapar ama geriye değer döndürmez.
Supplier → T get()             → Parametre almaz, bir değer üretir.
 */

/**
 * 📌 Generic DAO Arayüzü
 * CRUD işlemleri için temel arayüzdür.
 */
public interface IDaoGenerics<T> {
    Optional<T> create(T entity);
    List<T> list();
    Optional<T> findByName(String name);
    Optional<T> findById(int id);
    Optional<T> update(int id, T entity);
    Optional<T> delete(int id);
    void choose();
}