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

import com.basicsanity.testingdb_sql.Table50;
import com.basicsanity.testingdb_sql.Table50Id;


/**
 * ServiceImpl object for domain model class Table50.
 *
 * @see Table50
 */
@Service("TestingDB_SQL.Table50Service")
@Validated
public class Table50ServiceImpl implements Table50Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table50ServiceImpl.class);


    @Autowired
    @Qualifier("TestingDB_SQL.Table50Dao")
    private WMGenericDao<Table50, Table50Id> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table50, Table50Id> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public Table50 create(Table50 table50) {
        LOGGER.debug("Creating a new Table50 with information: {}", table50);

        Table50 table50Created = this.wmGenericDao.create(table50);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(table50Created);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Table50 getById(Table50Id table50Id) {
        LOGGER.debug("Finding Table50 by id: {}", table50Id);
        return this.wmGenericDao.findById(table50Id);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Table50 findById(Table50Id table50Id) {
        LOGGER.debug("Finding Table50 by id: {}", table50Id);
        try {
            return this.wmGenericDao.findById(table50Id);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Table50 found with id: {}", table50Id, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public List<Table50> findByMultipleIds(List<Table50Id> table50Ids, boolean orderedReturn) {
        LOGGER.debug("Finding Table50s by ids: {}", table50Ids);

        return this.wmGenericDao.findByMultipleIds(table50Ids, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TestingDB_SQLTransactionManager")
    @Override
    public Table50 update(Table50 table50) {
        LOGGER.debug("Updating Table50 with information: {}", table50);

        this.wmGenericDao.update(table50);
        this.wmGenericDao.refresh(table50);

        return table50;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public Table50 delete(Table50Id table50Id) {
        LOGGER.debug("Deleting Table50 with id: {}", table50Id);
        Table50 deleted = this.wmGenericDao.findById(table50Id);
        if (deleted == null) {
            LOGGER.debug("No Table50 found with id: {}", table50Id);
            throw new EntityNotFoundException(String.valueOf(table50Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public void delete(Table50 table50) {
        LOGGER.debug("Deleting Table50 with {}", table50);
        this.wmGenericDao.delete(table50);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<Table50> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table50s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<Table50> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table50s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table Table50 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table Table50 to {} format", options.getExportType());
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