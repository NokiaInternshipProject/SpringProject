package ali.firat.elvin.tr.portal.intern.core.framework.service;

import ali.firat.elvin.tr.portal.intern.core.dao.impl.HibernateDaoImpl;
import ali.firat.elvin.tr.portal.intern.core.exception.DaoException;
import ali.firat.elvin.tr.portal.intern.core.dao.HibernateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ocekmez on 1/27/2016.
 */
@org.springframework.stereotype.Service("hibernateService")
//@Scope("session")
public class HibernateServiceImpl<T, Id extends Serializable> implements HibernateService<T, Id> {
    private Class<T> persistentClass = null;

    // see: HibernateServiceImpl(Class<T> persistentClass, HibernateDao<T, Id> hibernateDao)
    @Autowired
    HibernateDaoImpl<T, Id> hibernateDao;

    public HibernateServiceImpl() {

    }

    public HibernateServiceImpl(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    /*
           GENERIC FUNCTIONS
    */

    @Override
    @Transactional
    public <M> List<M> findAll(Class<? extends M> persistentClass) throws DaoException {
        return hibernateDao.findAll(persistentClass);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Object object) throws DaoException {
        hibernateDao.saveOrUpdate((T) object);
    }

    @Override
    @Transactional
    public <M> List<M> findByColumnEquals(String column, Object value, Class<? extends M> persistentClass) throws DaoException {
        return hibernateDao.findByColumnEquals(column, value, persistentClass);
    }

    @Override
    @Transactional
    public <M> List<M> findByHql(String hql, Class<? extends M> persistentClass) throws DaoException {
        return hibernateDao.findByHql(hql, persistentClass);
    }

        /*
           GENERIC FUNCTIONS

    */


    private void checkPersistentClass() throws DaoException {
        if (persistentClass == null) {
            throw new DaoException("persistentClass is null here, please use other functions that gets the persistentClass as a parameter.\n" +
                    "Secondly you can extend hibnernateService by setting its persistentClass");
        }

        if(hibernateDao.getPersistentClass() != persistentClass){
            throw new DaoException("Set hibernateDao by:" + persistentClass);
        }
    }

    @Override
    @Transactional
    public T get(Id objectId) throws DaoException {
        checkPersistentClass();
        return (T) hibernateDao.get(objectId);
    }

    @Override
    @Transactional
    public void delete(Id objectId) throws DaoException {
        checkPersistentClass();
        hibernateDao.delete(objectId);
    }

    @Override
    @Transactional
    public Id save(T object) throws DaoException {
        return hibernateDao.save(object);
    }

    @Override
    @Transactional
    public void update(T object) throws DaoException {
        checkPersistentClass();
        hibernateDao.update(object);
    }

    @Override
    @Transactional
    public void deleteObject(T object) throws DaoException {
        checkPersistentClass();
        hibernateDao.deleteObject(object);
    }

    @Override
    @Transactional
    public List<T> findAll() throws DaoException {
        checkPersistentClass();
        return hibernateDao.findAll(persistentClass);
    }

    @Override
    @Transactional
    public List<T> findAll(String orderColumn, boolean asc) throws DaoException {
        checkPersistentClass();
        return hibernateDao.findAll(orderColumn, asc);
    }

    @Override
    @Transactional
    public List<T> findByColumnEquals(String column, Object value) throws DaoException {
        checkPersistentClass();
        return hibernateDao.findByColumnEquals(column, value);
    }

    @Override
    @Transactional
    public List<T> findByColumnEquals(HashMap<String, Object> criteriaMap) throws DaoException {
        checkPersistentClass();
        return hibernateDao.findByColumnEquals(criteriaMap);
    }

    @Override
    @Transactional
    public void merge(T object) throws DaoException {
        checkPersistentClass();
        hibernateDao.merge(object);
    }

    @Override
    @Transactional
    public Integer truncateTable() throws DaoException {
        checkPersistentClass();
        return hibernateDao.truncateTable();
    }

    @Override
    @Transactional
    public int deleteColumnEquals(String column, Object value) throws DaoException {
        checkPersistentClass();
        return hibernateDao.deleteColumnEquals(column, value);
    }

    @Override
    @Transactional
    public List<T> findByColumnEquals(HashMap<String, Object> criteriaMap, Class persistentClass) throws DaoException {
        checkPersistentClass();
        return hibernateDao.findByColumnEquals(criteriaMap, persistentClass);
    }

    @Override
    @Transactional
    public List<T> findByHql(String hql) throws DaoException {
        checkPersistentClass();
        return hibernateDao.findByHql(hql);
    }

    public void setHibernateDao(HibernateDaoImpl<T, Id> hibernateDao) {
        this.hibernateDao = hibernateDao;
    }
}
