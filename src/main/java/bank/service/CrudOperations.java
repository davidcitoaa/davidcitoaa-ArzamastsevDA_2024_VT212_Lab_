package bank.service;

public interface CrudOperations<T> {
    void create(T entity);
    T read(String id);
    void update(T entity);
    void delete(String id);
}