package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
    private static final EntityManagerFactory FACTORY = Persistence
            .createEntityManagerFactory("forum");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();

    }
}
