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

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.ws.rs.FormParam;

/**
 * @author Victz.com
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", length = 32)
    protected String id;
    @FormParam("name")
    @Column(name = "NAME", length = 100)
    protected String name;
    @Column(name = "MARK")
    protected Integer mark;
    @Column(name = "REMARK", length = 500)
    protected String remark;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createDate;
    @Column(name = "CREATE_BY", length = 32)
    protected String createBy;
    @Column(name = "UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updateDate;
    @Column(name = "UPDATE_BY", length = 32)
    protected String updateBy;
    @Column(name = "VALID")
    protected Boolean valid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractEntity other = (AbstractEntity) obj;
        return (this.id == null ? other.id == null : this.id.equals(other.id)) || (this.id != null && this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public static final Comparator<AbstractEntity> SORT_BY_CREATE_DATE = (AbstractEntity o1, AbstractEntity o2) -> {
        if (o1.getCreateDate() == null) {
            return -1;
        } else if (o2.getCreateDate() == null) {
            return 1;
        } else {
            return o2.getCreateDate().compareTo(o1.getCreateDate());
        }
    };
    public static final Comparator<AbstractEntity> SORT_BY_NAME = (AbstractEntity o1, AbstractEntity o2) -> {
        if (o1.getName() == null) {
            return -1;
        } else if (o2.getName() == null) {
            return 1;
        } else {
            return o1.getName().compareTo(o2.getName());
        }
    };
}
