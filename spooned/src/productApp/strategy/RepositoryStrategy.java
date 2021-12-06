package productApp.strategy;
import java.util.List;
import productApp.entities.Entity;
public interface RepositoryStrategy<T extends Entity> {
    T add(T entity);

    List<T> list();

    T get(String id);

    T update(T entity);

    boolean remove(String id);
}