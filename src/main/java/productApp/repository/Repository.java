package productApp.repository;

import productApp.entities.Entity;
import productApp.strategy.RepositoryStrategy;

import java.util.List;

public abstract class Repository<T extends Entity> {

    private RepositoryStrategy<T> strategy;

    public void init(RepositoryStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public T add(T entity) {
        return strategy.add(entity);
    }

    public List<T> list() {
        return strategy.list();
    }

    public T get(String id) {
        return strategy.get(id);
    }

    public T update(T entity) {
        return strategy.update(entity);
    }

    public boolean remove(String id) {
        return strategy.remove(id);
    }

}
