/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritimos.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Tiago D. Teixeira
 */
public class JPAHelper {

    private final SessionFactory factory = HibernateUtil.getSessionFactory();
    public final int INSERT = 0;
    public final int UPDATE = 1;
    public final int DELETE = 2;
    public final int SAVEORUPDATE = 3;
    private Session session;

    public JPAHelper() {
        super();
    }

    public void getOperation(int operation, Object object) {
        session = factory.openSession();
        session.beginTransaction();
        try {
            switch (operation) {
                case 0: //INSERT
                    try {
                        session.save(object);
                        session.getTransaction().commit();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Este registro já existe no banco de dados, tente novamente", "Registro Duplicado", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 1: //UPDATE
                    session.update(object);
                    session.getTransaction().commit();
                    break;
                case 2: //DELETE
                    session.delete(object);
                    session.getTransaction().commit();
                    break;
                case 3: //SAVE OR UPDATE
                    session.saveOrUpdate(object);
                    session.getTransaction().commit();
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public void closeSession() {
        this.session.close();
    }

    public void executeHql(String strHQL){
        session = factory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(strHQL);
        query.executeUpdate();
        session.close();
    }
    
    public Long getMaxResults(String strHQL, List<String> strParam, List<Object> valor) {
        session = factory.openSession();
        session.beginTransaction();
        strHQL = "select count(*) " + strHQL;
        Query query = session.createQuery(strHQL);
        for (int i = 0; i < strParam.size(); i++) {
            if (strParam.get(i) != null) {
                query.setParameter(strParam.get(i), valor.get(i));
            }
        }
        return Long.parseLong(query.getSingleResult().toString());
    }

    public Long getMaxResults(String strHQL, String strParam, Object valor) {
        session = factory.openSession();
        session.beginTransaction();
        strHQL = "select count(*) " + strHQL;
        Query query = session.createQuery(strHQL);
        query.setParameter(strParam, valor);
        return Long.parseLong(query.getSingleResult().toString());
    }

    public List<?> getObjectListMaxResults(String strHQL, List<String> strParam, List<Object> valor, int maxResults) {
        session = factory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(strHQL);
        query.setMaxResults(maxResults);
        for (int i = 0; i < strParam.size(); i++) {
            if (strParam.get(i) != null) {
                query.setParameter(strParam.get(i), valor.get(i));
            }
        }
        List<?> objects = new ArrayList();
        objects.clear();
        objects.addAll(query.getResultList());
        session.close();
        if (!objects.isEmpty()) {
            return objects;
        } else {
            return null;
        }
    }

    public List<?> getObjectList(String strHQL) {
        session = factory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(strHQL);
        List<?> objects = new ArrayList();
        objects.clear();
        objects.addAll(query.getResultList());
        session.close();
        if (!objects.isEmpty()) {
            return objects;
        } else {
            return null;
        }
    }

    public List<?> getObjectList(String strHQL, int maxResults) {
        session = factory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(strHQL);
        query.setMaxResults(maxResults);
        List<?> objects = new ArrayList();
        objects.clear();
        objects.addAll(query.getResultList());
        session.close();
        if (!objects.isEmpty()) {
            return objects;
        } else {
            return null;
        }
    }

    public List<?> getObjectList(String strHQL, String strParam, Object valor) {
        session = factory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(strHQL);
        query.setParameter(strParam, valor);
        List<?> objects = new ArrayList();
        objects.clear();
        objects.addAll(query.getResultList());
        session.close();
        if (!objects.isEmpty()) {
            return objects;
        } else {
            return null;
        }
    }

    public List<?> getObjectList(String strHQL, String strParam, Boolean valor) {
        session = factory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(strHQL);
        query.setParameter(strParam, valor);
        List<?> objects = new ArrayList();
        objects.clear();
        objects.addAll(query.getResultList());
        session.close();
        if (!objects.isEmpty()) {
            return objects;
        } else {
            return null;
        }
    }

    public List<?> getObjectList(String strHQL, String[] strParam, Object[] valor) {
        return this.getObjectList(strHQL, Arrays.asList(strParam), Arrays.asList(valor));
    }

    public List<?> getObjectList(String strHQL, List<String> strParam, List<Object> valor) {
        session = factory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(strHQL);
        for (int i = 0; i < strParam.size(); i++) {
            if (strParam.get(i) != null) {
                query.setParameter(strParam.get(i), valor.get(i));
            }
        }
        List<?> objects = new ArrayList();
        objects.clear();
        objects.addAll(query.getResultList());
        session.close();
        if (!objects.isEmpty()) {
            return objects;
        } else {
            return null;
        }
    }

    public Object getObject(String strHQL) {
        session = factory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(strHQL);
        List<?> objects = new ArrayList();
        objects.clear();
        objects.addAll(query.getResultList());
        session.close();
        if (!objects.isEmpty()) {
            return objects.get(0);
        } else {
            return null;
        }
    }

    public Object getObject(String strHQL, String strParam, Object valor) {
        session = factory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(strHQL);
        query.setParameter(strParam, valor);
        List<Object> objects = new ArrayList();
        objects.clear();
        objects.addAll(query.getResultList());
        session.close();
        if (!objects.isEmpty()) {
            return objects.get(0);
        } else {
            return null;
        }
    }

    public Object getObject(String strHQL, String[] strParam, Object[] valor) {
        session = factory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(strHQL);
        for (int i = 0; i < strParam.length; i++) {
            if (strParam[i] != null) {
                query.setParameter(strParam[i], valor[i]);
            }
        }
        List<Object> objects = new ArrayList();
        objects.clear();
        objects.addAll(query.getResultList());
        session.close();
        if (!objects.isEmpty()) {
            return objects.get(0);
        } else {
            return null;
        }
    }

    /**
     * Este método retorna uma instância de Connection a partir da instância de
     * Session do Hibernate.
     *
     * @return Instância de Connection
     */
    public Connection getConnection() {
        return HibernateUtil.getConnection();
    }

}
