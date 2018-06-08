/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritimos.dao;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;

/**
 *
 * @author joaosavio
 *
 */
public class EntityManagerFactoryService {

    private static final Logger LOG = Logger.getLogger(EntityManagerFactoryService.class);
    private static final Map<String, EntityManagerFactory> factories = new HashMap<String, EntityManagerFactory>();

    /**
     * This method returns an entity manager factory for a target persistence
     * unit
     *
     * @param persistenceUnitName
     * @return an entity manager factory for a target persistence unit
     */
    public static EntityManagerFactory getEntityManagerFactory(String persistenceUnitName) {
        if (factories.containsKey(persistenceUnitName)) {
            return factories.get(persistenceUnitName);
        }
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);

        factories.put(persistenceUnitName, emf);
        return emf;
    }

    /**
     * Close entity manager factories. Use this method when application life
     * cycle ends
     */
    public static void closeFactories() {
        LOG.info("Closing entity manager factories");
        factories.values().stream().forEach(fc -> {
            fc.close();
        });
        factories.clear();
    }
    
    public static Connection getConnection(EntityManagerHelper.PERSISTENCE_UNIT persistence_unit){
        EntityManager emh = getEntityManagerFactory(persistence_unit.toString()).createEntityManager();
        Connection conn = (Connection) emh.getDelegate();
        emh.close();
        closeFactories();
        return conn;
    }
}
