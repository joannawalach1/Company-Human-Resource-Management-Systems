package pl.great.waw.company3.repository;

public interface CrudRepository<E> {

    E get(String id);

    E create(E entity);

    E update(E entity);

    boolean delete(String id);
}
