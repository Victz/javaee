/*
 * The MIT License
 *
 * Copyright 2016 Victz.com.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.victz.dao.impl;

import com.victz.lib.dao.AbstractDao;
import com.victz.lib.entity.AbstractEntity;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.CacheRetrieveMode;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.eclipse.persistence.config.QueryHints;

/**
 * @author Victz.com
 * @param <T>
 *
 */
public abstract class AbstractDaoImpl<T extends AbstractEntity> implements AbstractDao<T> {

    protected final Class<T> entityClass;

    @Inject
    private EntityManager em;

    protected AbstractDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void persist(T entity) {
        getEntityManager().joinTransaction();
        getEntityManager().persist(entity);
    }

    @Override
    public void remove(T entity) {
        getEntityManager().joinTransaction();
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    @Override
    public T merge(T entity) {
        getEntityManager().joinTransaction();
        return getEntityManager().merge(entity);
    }

    @Override
    public T getReference(String id) {
        return getEntityManager().getReference(this.entityClass, id);
    }

    @Override
    public T find(String id) {
        return find(id, false);
    }

    @Override
    public T find(String id, boolean refresh) {
        if (refresh) {
            getEntityManager().setProperty(QueryHints.CACHE_RETRIEVE_MODE, CacheRetrieveMode.BYPASS);
            getEntityManager().setProperty(QueryHints.CACHE_STORE_MODE, CacheStoreMode.REFRESH);
        }
        return getEntityManager().find(this.entityClass, id);
    }

    @Override
    public List<T> getList(String qlString, Object[] params) {
        return getList(qlString, params, null);
    }

    @Override
    public List<T> getList(String qlString, Object[] params, int[] range) {
        Query query = getEntityManager().createQuery(qlString);
        setParams(query, params);
        if (range != null && range.length == 2) {
            query.setFirstResult(range[0]).setMaxResults(range[1]);
        }
        return query.getResultList();
    }

    @Override
    public long getCount(String qlString, Object[] params) {
        Query query = getEntityManager().createQuery(qlString);
        setParams(query, params);
        return (Long) query.getSingleResult();
    }

    @Override
    public int excuteUpdate(String qlString, Object[] params) {
        Query query = getEntityManager().createQuery(qlString);
        if (null != params) {
            setParams(query, params);
        }
        return query.executeUpdate();
    }

    protected void setParams(Query query, Object[] params) {
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i + 1, params[i]);
            }
        }
    }

}
