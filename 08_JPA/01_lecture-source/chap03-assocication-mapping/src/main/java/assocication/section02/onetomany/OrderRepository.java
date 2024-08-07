package assocication.section02.onetomany;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager manager;

    public void save(Order order) {
        manager.persist(order);
    }
}
