/*Copyright (c) 2018-2019 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.basicsanity.testingdb_sql;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * OnlyVirtualTable generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`Only Virtual Table`")
@IdClass(OnlyVirtualTableId.class)
public class OnlyVirtualTable implements Serializable {

    private String id;
    private String name;
    private String description;

    @Id
    @Column(name = "`Id`", nullable = true, length = 255)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    @Column(name = "`Name`", nullable = true, length = 255)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "`Description`", nullable = true, length = 255)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OnlyVirtualTable)) return false;
        final OnlyVirtualTable onlyVirtualTable = (OnlyVirtualTable) o;
        return Objects.equals(getId(), onlyVirtualTable.getId()) &&
                Objects.equals(getName(), onlyVirtualTable.getName()) &&
                Objects.equals(getDescription(), onlyVirtualTable.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getName(),
                getDescription());
    }
}