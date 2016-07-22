package ali.firat.elvin.tr.portal.intern.core.dao.impl;

import ali.firat.elvin.tr.portal.intern.core.dao.HibernateDao;
import ali.firat.elvin.tr.portal.intern.core.exception.DaoException;
import org.slf4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: guvenck
 * Date: 6/24/14
 * Time: 9:11 AM
 * To change this template use File | Settings | File Templates.
 */

@Repository("hibernateDao")
public class HibernateDaoImpl <T, Id extends Serializable> implements HibernateDao<T, Id> {

    public HibernateDaoImpl(){
    }

    protected Class<T> persistentClass;

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(HibernateDaoImpl.class);

    public HibernateDaoImpl(Class<T> persistentClass) {
        //logger.debug("Object created. persistenClass parameter: " + persistentClass);
        this.persistentClass = persistentClass;
    }

    protected final Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public T get(Id objectId) throws DaoException {
        return (T) getCurrentSession().get(persistentClass, objectId);
    }


    @SuppressWarnings("unchecked")

    public void delete(Id objectId) throws DaoException {
        T obj = get(objectId);
        if(obj!=null)
            deleteObject(obj);
    }

    @SuppressWarnings("unchecked")
    public Id save(T object) throws DaoException {
        Id id = (Id) getCurrentSession().save(object);
        this.getCurrentSession().persist(object);
        return id;
    }

    public void saveOrUpdate(T object) throws DaoException {
        try {
            getCurrentSession().saveOrUpdate(object);
            this.getCurrentSession().flush();
        } catch (Exception e) {
            logger.error("",e);
            throw new DaoException("Can't save or update:" + object.getClass(),e);
        }
    }

    public void update(T object) throws DaoException {
        getCurrentSession().update(object);
    }

    public void merge(T object) throws DaoException {
        getCurrentSession().merge(object);
    }


    @SuppressWarnings("unchecked")
    public Integer truncateTable() throws DaoException {
        String query =  "delete from " + persistentClass.getName() + " o " ;
        return getCurrentSession().createQuery(query).executeUpdate();
    }

    public void deleteObject(T object) throws DaoException {
        getCurrentSession().delete(object);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() throws DaoException {
       return findAll(persistentClass);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll(final String orderColumn, boolean asc) throws DaoException {

        String query = "from " + persistentClass.getName() + " o " + " order by " + orderColumn;
        if(!asc)
            query = query + " desc";
        return getCurrentSession().createQuery(query).list();
    }

    @Override
    public <M>List<M> findAll(Class<? extends M> persistentClass) throws DaoException {
        String query = "from " + persistentClass.getName() + " o";
        return getCurrentSession().createQuery(query).list();
    }

    @SuppressWarnings("unchecked")

    public int deleteColumnEquals(String column, Object value) throws DaoException {
        String query = "delete from " + persistentClass.getName() + " o where " + column + " = " + "'" +  value + "'";
        return  getCurrentSession().createQuery(query).executeUpdate();

    }


    @SuppressWarnings("unchecked")

    public List<T> findByColumnEquals(String column, Object value) throws DaoException {
       return findByColumnEquals(column, value, persistentClass);
    }

    @Override
    public <M>List<M> findByColumnEquals(String column, Object value, Class<? extends M> persistentClass) throws DaoException {
        Criteria criteria = getCurrentSession().createCriteria(persistentClass);
        criteria.add(Property.forName(column).eq(value));
        return criteria.list();
    }

    @SuppressWarnings("unchecked")

    public List<T> findByColumnEquals(HashMap<String, Object> criteriaMap) throws DaoException {
        return findByColumnEquals(criteriaMap,persistentClass);
    }


    @SuppressWarnings("unchecked")

    public List<T> findByColumnEquals(HashMap<String, Object> criteriaMap, Class persistentClass) throws DaoException {
        Criteria criteria = getCurrentSession().createCriteria(persistentClass);
        Set<String> keys = criteriaMap.keySet();
        for (String key : keys) {
            criteria.add(Property.forName(key).eq(criteriaMap.get(key)));
        }
        return criteria.list();
    }

    @Override
    public List<T> findByHql(String hql) throws DaoException {
        return getCurrentSession().createQuery(hql).list();
    }

    @Override
    public<M> List findByHql(String hql, Class<M> persistentClass) throws DaoException {
        return getCurrentSession().createQuery(hql).list();
    }


    //Strongly recommend when doing batch inserts

    public void saveAll(Collection<T> entityList)  throws DaoException{

        if(entityList == null){
            return;
        }

        Session session = getCurrentSession();
        T object;
        int i=0;

        Iterator<T> entityListIterator = entityList.iterator() ;

        while(entityListIterator.hasNext()){
            object = entityListIterator.next();
            session.save(object);

            if ( (i + 1) % 20 == 0 ) { //20, same as the JDBC batch size
                //flush a batch of inserts and release memory:
                session.flush();
                session.clear();
            }
            i++;
        }
    }

    public List<T> findByColumnEquals(HashMap<String, Object> criteriaMap, Order order) throws DaoException {
        Criteria criteria = getCurrentSession().createCriteria(persistentClass);
        Set<String> keys = criteriaMap.keySet();
        for (String key : keys) {
            criteria.add(Property.forName(key).eq(criteriaMap.get(key)));
        }

        criteria.addOrder(order);
        return criteria.list();
    }

    public String getTableName() throws DaoException {
        Table tableAnnotation;
        try {
            tableAnnotation = persistentClass.getAnnotation(Table.class);
            return tableAnnotation.name();
        } catch (Exception e) {
            throw new DaoException("This class is not mapped in hibernate template " + persistentClass.getName());
        }
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }
}
