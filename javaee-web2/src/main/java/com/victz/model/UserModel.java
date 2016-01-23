package com.victz.model;

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


import com.victz.lib.dao.UserDao;
import com.victz.lib.entity.User;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Victz.com
 */
@Named
@RequestScoped
public class UserModel {
    
    @EJB
    private UserDao userDao;
    
    private User user;
    
    public UserModel() {
    }
    
    public List<User> getUsers() {
        return userDao.getList("select o from User o order by o.updateDate", null);
    }
    
    public void save() {
        if (user.getId() == null) {
            user.setId(UUID.randomUUID().toString().replace("-", ""));
            user.setMark(User.MARK_NEW);
            user.setRemark("Hi, I'm in Victz!");
            user.setCreateBy(user.getId());
            user.setCreateDate(new Date());
            user.setUpdateBy(user.getId());
            user.setUpdateDate(new Date());
            user.setValid(Boolean.TRUE);
            userDao.persist(user);
        } else {
            user.setUpdateBy(user.getId());
            user.setUpdateDate(new Date());
            userDao.merge(user);
        }
    }
    
    public void delete(String id) {
        if (id != null && !id.isEmpty()) {
            userDao.remove(userDao.getReference(id));
        }
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
}
