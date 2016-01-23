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

import com.victz.lib.dao.UserDao;
import com.victz.lib.entity.User;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Victz.com
 */
@Singleton
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User getByMail(String mail) {
        Object[] params = {mail};
        List<User> list = getList("select o from User o where o.mail = ?1 and o.valid = true", params);
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public User getByUserName(String userName) {
        Object[] params = {userName};
        List<User> list = getList("select o from User o where o.userName = ?1 and o.valid = true", params);
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public User getByNumber(String number) {
        Object[] params = {number};
        List<User> list = getList("select o from User o where o.number = ?1 and o.valid = true", params);
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public User signin(String input) {
        Object[] params = {input, input, input};
        List<User> list = getList("select o from User o where o.valid = true and (o.mail = ?1 or o.userName = ?2 or o.number = ?3)", params);
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }
}
