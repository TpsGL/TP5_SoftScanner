package productApp.strategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import productApp.entities.Entity;
public class InMemoryStrategy<T extends Entity> implements RepositoryStrategy<T> {
    private final Map<String, T> storage = new ConcurrentHashMap<String, T>();

    @Override
    public T add(T entity) {
        String id = UUID.randomUUID().toString();
        entity.setId(id);
        storage.put(id, entity);
        return storage.get(id);
    }

    @Override
    public List<T> list() {
        return new ArrayList<T>(storage.values());
    }

    @Override
    public T get(String id) {
        return storage.get(id);
    }

    @Override
    public T update(T entity) {
        return storage.put(entity.getId(), entity);
    }

    @Override
    public boolean remove(String id) {
        return storage.remove(id) != null;
    }
}