/*
 * Copyright (C) 2014 Victz
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.victz.lib.dao;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Victz.com
 * @param <T>
 */
public interface AbstractDao<T> {

    EntityManager getEntityManager();

    void persist(T entity);

    void remove(T entity);

    T merge(T entity);

    T getReference(String id);

    T find(String id);

    T find(String id, boolean refresh);

    List<T> getList(String qlString, Object[] params);

    List<T> getList(String qlString, Object[] params, int[] range);

    long getCount(String qlString, Object[] params);

    int excuteUpdate(String qlString, Object[] params);

}
