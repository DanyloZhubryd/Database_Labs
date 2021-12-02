package ua.lviv.iot.model.dal.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.lviv.iot.model.dal.util.HibernateUtil;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;



public class GeneralDAO<Entity> implements AbstractDAO<Entity>{
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private final Class<Entity> entityClass;

    public GeneralDAO(Class<Entity> entityClass){
        this.entityClass = entityClass;
    }

    @Override
    public Entity get(Integer id) throws SQLException{
        Entity searched = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            searched = session.get(entityClass, id);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error getting row! " + e);
            e.printStackTrace();
        }
        return searched;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Entity> getAll() throws SQLException {
        List<Entity> entityList = new LinkedList<>();
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            entityList = session.createQuery("from " + entityClass.getSimpleName()).getResultList();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error getting table! " + e);
            e.printStackTrace();
        }
        return entityList;
    }

    @Override
    public boolean create(Entity entity) throws SQLException {
        try(Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error creating row! " + e);
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean delete(Integer id) throws SQLException {
        try(Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Entity entity = session.get(entityClass, (Serializable) id);
            if (entity != null) {
                session.delete(entity);
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error deleting row! " + e);
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(Integer id, Entity entity) throws SQLException {
        try(Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error updating row! " + e);
            e.printStackTrace();
        }
        return false;
    }
}
