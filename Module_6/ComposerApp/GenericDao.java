package ComposerApp;
import java.util.List;

public interface GenericDao<E, K> {

    List<Composer> findAll();
    E findBy(K key);
    void insert(E entity);
}
