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

import com.basicsanity.testingdb_sql.JoiningDetails;


/**
 * ServiceImpl object for domain model class JoiningDetails.
 *
 * @see JoiningDetails
 */
@Service("TestingDB_SQL.JoiningDetailsService")
@Validated
public class JoiningDetailsServiceImpl implements JoiningDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JoiningDetailsServiceImpl.class);


    @Autowired
    @Qualifier("TestingDB_SQL.JoiningDetailsDao")
    private WMGenericDao<JoiningDetails, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<JoiningDetails, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public JoiningDetails create(JoiningDetails joiningDetails) {
        LOGGER.debug("Creating a new JoiningDetails with information: {}", joiningDetails);

        JoiningDetails joiningDetailsCreated = this.wmGenericDao.create(joiningDetails);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(joiningDetailsCreated);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public JoiningDetails getById(Integer joiningdetailsId) {
        LOGGER.debug("Finding JoiningDetails by id: {}", joiningdetailsId);
        return this.wmGenericDao.findById(joiningdetailsId);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public JoiningDetails findById(Integer joiningdetailsId) {
        LOGGER.debug("Finding JoiningDetails by id: {}", joiningdetailsId);
        try {
            return this.wmGenericDao.findById(joiningdetailsId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No JoiningDetails found with id: {}", joiningdetailsId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public List<JoiningDetails> findByMultipleIds(List<Integer> joiningdetailsIds, boolean orderedReturn) {
        LOGGER.debug("Finding JoiningDetails by ids: {}", joiningdetailsIds);

        return this.wmGenericDao.findByMultipleIds(joiningdetailsIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TestingDB_SQLTransactionManager")
    @Override
    public JoiningDetails update(JoiningDetails joiningDetails) {
        LOGGER.debug("Updating JoiningDetails with information: {}", joiningDetails);

        this.wmGenericDao.update(joiningDetails);
        this.wmGenericDao.refresh(joiningDetails);

        return joiningDetails;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public JoiningDetails delete(Integer joiningdetailsId) {
        LOGGER.debug("Deleting JoiningDetails with id: {}", joiningdetailsId);
        JoiningDetails deleted = this.wmGenericDao.findById(joiningdetailsId);
        if (deleted == null) {
            LOGGER.debug("No JoiningDetails found with id: {}", joiningdetailsId);
            throw new EntityNotFoundException(String.valueOf(joiningdetailsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public void delete(JoiningDetails joiningDetails) {
        LOGGER.debug("Deleting JoiningDetails with {}", joiningDetails);
        this.wmGenericDao.delete(joiningDetails);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<JoiningDetails> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all JoiningDetails");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<JoiningDetails> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all JoiningDetails");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table JoiningDetails to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table JoiningDetails to {} format", options.getExportType());
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