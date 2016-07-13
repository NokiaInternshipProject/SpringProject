package ali.firat.elvin.tr.portal.intern.core.framework.service;


import ali.firat.elvin.tr.portal.intern.core.exception.DaoException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ocekmez on 1/27/2016.
 */
public interface HibernateService<T, Id extends Serializable> extends Service {
   /* public T get(Id objectId) throws DaoException;

    public void delete(Id objectId) throws DaoException;

    public Id save(T object) throws DaoException;

    public void saveOrUpdate(T object) throws Exception;

    public void update(T object) throws DaoException;

    public void deleteObject(T object) throws DaoException;*/


    public T get(Id objectId) throws DaoException;

    public void delete(Id objectId) throws DaoException;

    public Id save(T object) throws DaoException;

    public void update(T object) throws DaoException;

    public void deleteObject(T object) throws DaoException;

    public List<T> findAll() throws DaoException;

    public List<T> findAll(final String orderColumn, boolean asc) throws DaoException;

    public List<T> findByColumnEquals(final String column, Object value) throws DaoException;


    public List<T> findByColumnEquals(HashMap<String, Object> criteriaMap) throws DaoException;

    public void merge(T object) throws DaoException;

    public Integer truncateTable() throws DaoException;

    public int deleteColumnEquals(String column, Object value) throws DaoException;

    public List<T> findByColumnEquals(HashMap<String, Object> criteriaMap, Class persistentClass) throws DaoException;

    public List<T> findByHql(String hql) throws DaoException;


    public <M>List<M> findAll(Class<? extends M> persistentClass) throws DaoException;
    public void saveOrUpdate(Object object) throws DaoException;
    public <M>List<M> findByColumnEquals(final String column, Object value, Class<? extends M>  persistentClass) throws DaoException;
    public <M>List<M> findByHql(String hql, Class<? extends M> persistentClass) throws DaoException;
   // public List findByColumnEquals(HashMap<String, Object> criteriaMap) throws DaoException;
    //public List findByColumnEquals(HashMap<String, Object> criteriaMap, Class persistentClass) throws DaoException;

}
