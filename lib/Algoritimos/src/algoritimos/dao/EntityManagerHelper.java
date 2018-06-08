/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritimos.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author Tiago D. Teixeira
 */
public class EntityManagerHelper {

    private final Map<String, ThreadLocal<EntityManager>> sessions = new HashMap<>();
    private static final Logger LOG = Logger.getLogger(EntityManagerHelper.class);

    public EntityManagerHelper() {
    }

    public void getOperation(OPERATION_TYPE operation_type, Object object, PERSISTENCE_UNIT persistence_unit) {
        EntityManager session = getSession(persistence_unit);
        try {
            switch (operation_type) {
                case SAVE:
                    LOG.info("Salvando registro no banco de dados");
                    session.getTransaction().begin();
                    session.persist(object);
                    session.getTransaction().commit();
                    JOptionPane.showMessageDialog(null, "Registro salvo com sucesso", "Registro Salvo", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case UPDATE:
                    LOG.info("Atualizando registro no banco de dados");
                    session.getTransaction().begin();
                    session.merge(object);
                    session.getTransaction().commit();
                    JOptionPane.showMessageDialog(null, "Registro alterado com sucesso", "Registro Alterado", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case DELETE:
                    LOG.info("Deletando registro no banco de dados");
                    session.getTransaction().begin();
                    session.remove(object);
                    session.getTransaction().commit();
                    JOptionPane.showMessageDialog(null, "Registro deletado com sucesso", "Registro Deletado", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            this.closeSession(persistence_unit);
            e.printStackTrace();
        } finally {
            this.closeSession(persistence_unit);
        }
    }

    private EntityManager getSession(PERSISTENCE_UNIT persistence_unit) {
        EntityManager session = null;
        if (sessions.isEmpty()) {
            sessions.put(persistence_unit.toString(), new ThreadLocal<>());
            session = sessions.get(persistence_unit.toString()).get();
            session = session == null ? EntityManagerFactoryService.getEntityManagerFactory(persistence_unit.toString()).createEntityManager() : session;
        }
        return session;
    }

    private void closeSession(PERSISTENCE_UNIT persistence_unit) {
        EntityManager session = null;
        if (!sessions.isEmpty()) {
            session = sessions.get(persistence_unit.toString()).get();
            LOG.info("Encerrando sessão do banco de dados");
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
            }
        }
        LOG.debug("Removendo Entity Manager desta sessão");
        sessions.remove(persistence_unit.toString());
    }

    public void closeAll() {
        LOG.info("Encerrando todas as sessões");
        sessions.clear();
    }

    public List<?> getObjectList(String strHQL, PERSISTENCE_UNIT persistence_unit) {
        EntityManager session = this.getSession(persistence_unit);
        session.getTransaction().begin();
        Query query = session.createQuery(strHQL);
        List<?> objects = query.getResultList();
        this.closeSession(persistence_unit);
        return objects;
    }

    public List<?> getObjectList(String strHQL, String strParam, Object valor, PERSISTENCE_UNIT persistence_unit) {
        EntityManager session = this.getSession(persistence_unit);
        session.getTransaction().begin();
        Query query = session.createQuery(strHQL);
        query.setParameter(strParam, valor);
        List<?> objects = query.getResultList();
        this.closeSession(persistence_unit);
        return objects;
    }

    public List<?> getObjectList(String strHQL, String strParam, Boolean valor, PERSISTENCE_UNIT persistence_unit) {
        EntityManager session = this.getSession(persistence_unit);
        session.getTransaction().begin();
        Query query = session.createQuery(strHQL);
        query.setParameter(strParam, valor);
        List<?> objects = query.getResultList();
        this.closeSession(persistence_unit);
        return objects;
    }

    public Object getObject(String strHQL, PERSISTENCE_UNIT persistence_unit) {
        Object temp;
        EntityManager session = this.getSession(persistence_unit);
        session.getTransaction().begin();
        Query query = session.createQuery(strHQL);
        List<?> objects = query.getResultList();
        this.closeSession(persistence_unit);
        temp = objects.get(0);
        return temp;
    }

    public Object getObject(String strHQL, String strParam, Object valor, PERSISTENCE_UNIT persistence_unit) {
        try {
            Object temp;
            EntityManager session = this.getSession(persistence_unit);
            session.getTransaction().begin();
            Query query = session.createQuery(strHQL);
            query.setParameter(strParam, valor);
            List<?> objects = query.getResultList();
            this.closeSession(persistence_unit);
            temp = objects.get(0);
            return temp;
        } catch(Exception ex){
            return null;
        }
    }

    public Object getObject(String strHQL, String[] strParam, String[] valor, PERSISTENCE_UNIT persistence_unit) {
        try {
            Object temp;
            EntityManager session = this.getSession(persistence_unit);
            session.getTransaction().begin();
            Query query = session.createQuery(strHQL);
            for (int i = 0; i < strParam.length; i++) {
                if (strParam[i] != null) {
                    query.setParameter(strParam[i], valor[i]);
                }
            }
            Object objects = query.getSingleResult();
            this.closeSession(persistence_unit);
            temp = objects;
            return temp;
        } catch (Exception ex) {
            return null;
        }
    }

    public static enum OPERATION_TYPE {
        SAVE, UPDATE, DELETE
    }

    public static enum PERSISTENCE_UNIT {
        ORACLE11G_PU, SERMED_PRONTUARIO_PU, SERMED_TISS_PU
    }
}
