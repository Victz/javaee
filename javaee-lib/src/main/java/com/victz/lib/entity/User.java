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
package com.victz.lib.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;

/**
 * @author Victz.com
 *
 */
@Entity
@Table(name = "CORE_USER", schema = "test")
public class User extends AbstractEntity {

    @FormParam("password")
    @Column(name = "PASSWORD", length = 50)
    private String password;
    @FormParam("mail")
    @Column(name = "MAIL", length = 50)
    private String mail;
    @FormParam("userName")
    @Column(name = "USER_NAME", length = 50)
    private String userName;
    @FormParam("number")
    @Column(name = "NUMBER", length = 50)
    private String number;
    @Column(name = "TOKEN", length = 700)
    private String token;
    @Column(name = "PHOTO", length = 50)
    private String photo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(schema = "test", name = "CORE_USER_ROLE", inverseJoinColumns
            = @JoinColumn(name = "ROLE_ID"), joinColumns
            = @JoinColumn(name = "USER_ID"))
    private Set<Role> roles;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public static final int MARK_NEW = 0;
    public static final int MARK_VERIFIED = 1;

}
