/*Copyright (c) 2018-2019 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.basicsanity.testingdb_sql.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.basicsanity.testingdb_sql.Table48;
import com.basicsanity.testingdb_sql.Table50Id;


/**
 * ServiceImpl object for domain model class Table48.
 *
 * @see Table48
 */
@Service("TestingDB_SQL.Table48Service")
@Validated
public class Table48ServiceImpl implements Table48Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table48ServiceImpl.class);


    @Autowired
    @Qualifier("TestingDB_SQL.Table48Dao")
    private WMGenericDao<Table48, Table50Id> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table48, Table50Id> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public Table48 create(Table48 table48) {
        LOGGER.debug("Creating a new Table48 with information: {}", table48);

        Table48 table48Created = this.wmGenericDao.create(table48);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(table48Created);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Table48 getById(Table50Id table48Id) {
        LOGGER.debug("Finding Table48 by id: {}", table48Id);
        return this.wmGenericDao.findById(table48Id);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Table48 findById(Table50Id table48Id) {
        LOGGER.debug("Finding Table48 by id: {}", table48Id);
        try {
            return this.wmGenericDao.findById(table48Id);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Table48 found with id: {}", table48Id, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public List<Table48> findByMultipleIds(List<Table50Id> table48Ids, boolean orderedReturn) {
        LOGGER.debug("Finding Table48s by ids: {}", table48Ids);

        return this.wmGenericDao.findByMultipleIds(table48Ids, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TestingDB_SQLTransactionManager")
    @Override
    public Table48 update(Table48 table48) {
        LOGGER.debug("Updating Table48 with information: {}", table48);

        this.wmGenericDao.update(table48);
        this.wmGenericDao.refresh(table48);

        return table48;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public Table48 delete(Table50Id table48Id) {
        LOGGER.debug("Deleting Table48 with id: {}", table48Id);
        Table48 deleted = this.wmGenericDao.findById(table48Id);
        if (deleted == null) {
            LOGGER.debug("No Table48 found with id: {}", table48Id);
            throw new EntityNotFoundException(String.valueOf(table48Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public void delete(Table48 table48) {
        LOGGER.debug("Deleting Table48 with {}", table48);
        this.wmGenericDao.delete(table48);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<Table48> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table48s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<Table48> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table48s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table Table48 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table Table48 to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}