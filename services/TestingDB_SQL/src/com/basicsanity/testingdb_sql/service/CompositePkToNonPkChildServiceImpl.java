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

import com.basicsanity.testingdb_sql.CompositePkToNonPkChild;


/**
 * ServiceImpl object for domain model class CompositePkToNonPkChild.
 *
 * @see CompositePkToNonPkChild
 */
@Service("TestingDB_SQL.CompositePkToNonPkChildService")
@Validated
public class CompositePkToNonPkChildServiceImpl implements CompositePkToNonPkChildService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompositePkToNonPkChildServiceImpl.class);


    @Autowired
    @Qualifier("TestingDB_SQL.CompositePkToNonPkChildDao")
    private WMGenericDao<CompositePkToNonPkChild, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<CompositePkToNonPkChild, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public CompositePkToNonPkChild create(CompositePkToNonPkChild compositePkToNonPkChild) {
        LOGGER.debug("Creating a new CompositePkToNonPkChild with information: {}", compositePkToNonPkChild);

        CompositePkToNonPkChild compositePkToNonPkChildCreated = this.wmGenericDao.create(compositePkToNonPkChild);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(compositePkToNonPkChildCreated);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public CompositePkToNonPkChild getById(Integer compositepktononpkchildId) {
        LOGGER.debug("Finding CompositePkToNonPkChild by id: {}", compositepktononpkchildId);
        return this.wmGenericDao.findById(compositepktononpkchildId);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public CompositePkToNonPkChild findById(Integer compositepktononpkchildId) {
        LOGGER.debug("Finding CompositePkToNonPkChild by id: {}", compositepktononpkchildId);
        try {
            return this.wmGenericDao.findById(compositepktononpkchildId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No CompositePkToNonPkChild found with id: {}", compositepktononpkchildId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public List<CompositePkToNonPkChild> findByMultipleIds(List<Integer> compositepktononpkchildIds, boolean orderedReturn) {
        LOGGER.debug("Finding CompositePkToNonPkChilds by ids: {}", compositepktononpkchildIds);

        return this.wmGenericDao.findByMultipleIds(compositepktononpkchildIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TestingDB_SQLTransactionManager")
    @Override
    public CompositePkToNonPkChild update(CompositePkToNonPkChild compositePkToNonPkChild) {
        LOGGER.debug("Updating CompositePkToNonPkChild with information: {}", compositePkToNonPkChild);

        this.wmGenericDao.update(compositePkToNonPkChild);
        this.wmGenericDao.refresh(compositePkToNonPkChild);

        return compositePkToNonPkChild;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public CompositePkToNonPkChild delete(Integer compositepktononpkchildId) {
        LOGGER.debug("Deleting CompositePkToNonPkChild with id: {}", compositepktononpkchildId);
        CompositePkToNonPkChild deleted = this.wmGenericDao.findById(compositepktononpkchildId);
        if (deleted == null) {
            LOGGER.debug("No CompositePkToNonPkChild found with id: {}", compositepktononpkchildId);
            throw new EntityNotFoundException(String.valueOf(compositepktononpkchildId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public void delete(CompositePkToNonPkChild compositePkToNonPkChild) {
        LOGGER.debug("Deleting CompositePkToNonPkChild with {}", compositePkToNonPkChild);
        this.wmGenericDao.delete(compositePkToNonPkChild);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<CompositePkToNonPkChild> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all CompositePkToNonPkChilds");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<CompositePkToNonPkChild> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all CompositePkToNonPkChilds");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table CompositePkToNonPkChild to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table CompositePkToNonPkChild to {} format", options.getExportType());
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