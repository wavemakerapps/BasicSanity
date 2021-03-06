/*Copyright (c) 2018-2019 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.basicsanity.testingdb_sql;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * OneToManyChild generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`OneToMany Child`")
public class OneToManyChild implements Serializable {

    private Integer childPkColumn;
    private String stringColumn;
    private Integer parentPk;
    private OneToManyParent oneToManyParent;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`Child PK Column`", nullable = false, scale = 0, precision = 10)
    public Integer getChildPkColumn() {
        return this.childPkColumn;
    }

    public void setChildPkColumn(Integer childPkColumn) {
        this.childPkColumn = childPkColumn;
    }

    @Column(name = "`String Column`", nullable = true, length = 255)
    public String getStringColumn() {
        return this.stringColumn;
    }

    public void setStringColumn(String stringColumn) {
        this.stringColumn = stringColumn;
    }

    @Column(name = "`Parent PK`", nullable = true, scale = 0, precision = 10)
    public Integer getParentPk() {
        return this.parentPk;
    }

    public void setParentPk(Integer parentPk) {
        this.parentPk = parentPk;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`Parent PK`", referencedColumnName = "`PK Column`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_OneToMany_Parent_TO_OWQTuf`"))
    @Fetch(FetchMode.JOIN)
    public OneToManyParent getOneToManyParent() {
        return this.oneToManyParent;
    }

    public void setOneToManyParent(OneToManyParent oneToManyParent) {
        if(oneToManyParent != null) {
            this.parentPk = oneToManyParent.getPkColumn();
        }

        this.oneToManyParent = oneToManyParent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OneToManyChild)) return false;
        final OneToManyChild oneToManyChild = (OneToManyChild) o;
        return Objects.equals(getChildPkColumn(), oneToManyChild.getChildPkColumn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChildPkColumn());
    }
}