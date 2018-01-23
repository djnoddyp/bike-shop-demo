package pnodder.services;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import pnodder.model.Bike;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class BikeService {

//    @PersistenceContext(unitName = "bikeshop")
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public void save(Bike bike) {
        setup();
        entityManager.getTransaction().begin();
        entityManager.persist(bike);
        entityManager.getTransaction().commit();
        List<Bike> bikes = entityManager.createQuery("from Bike", Bike.class).getResultList();
        for (Bike b : bikes) {
            System.out.println("Bike: " + b.getMake() + " " + b.getModel());
        }
        //entityManager.getTransaction().commit();
        entityManager.close();
    }

    private void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("bikeshop");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void findAll() {
        //String sql = "SELECT * FROM bike;";
        setup();
        entityManager.getTransaction().begin();
        List<Bike> bikes = entityManager.createQuery("from Bike", Bike.class).getResultList();
        for (Bike b : bikes) {
            System.out.println("Bike: " + b.getMake() + " " + b.getModel());
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
