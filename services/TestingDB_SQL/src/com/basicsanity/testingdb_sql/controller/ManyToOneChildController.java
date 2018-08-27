/*Copyright (c) 2018-2019 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.basicsanity.testingdb_sql.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.basicsanity.testingdb_sql.ManyToOneChild;
import com.basicsanity.testingdb_sql.service.ManyToOneChildService;


/**
 * Controller object for domain model class ManyToOneChild.
 * @see ManyToOneChild
 */
@RestController("TestingDB_SQL.ManyToOneChildController")
@Api(value = "ManyToOneChildController", description = "Exposes APIs to work with ManyToOneChild resource.")
@RequestMapping("/TestingDB_SQL/ManyToOneChild")
public class ManyToOneChildController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManyToOneChildController.class);

    @Autowired
	@Qualifier("TestingDB_SQL.ManyToOneChildService")
	private ManyToOneChildService manyToOneChildService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new ManyToOneChild instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ManyToOneChild createManyToOneChild(@RequestBody ManyToOneChild manyToOneChild) {
		LOGGER.debug("Create ManyToOneChild with information: {}" , manyToOneChild);

		manyToOneChild = manyToOneChildService.create(manyToOneChild);
		LOGGER.debug("Created ManyToOneChild with information: {}" , manyToOneChild);

	    return manyToOneChild;
	}

    @ApiOperation(value = "Returns the ManyToOneChild instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ManyToOneChild getManyToOneChild(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting ManyToOneChild with id: {}" , id);

        ManyToOneChild foundManyToOneChild = manyToOneChildService.getById(id);
        LOGGER.debug("ManyToOneChild details with id: {}" , foundManyToOneChild);

        return foundManyToOneChild;
    }

    @ApiOperation(value = "Updates the ManyToOneChild instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ManyToOneChild editManyToOneChild(@PathVariable("id") Integer id, @RequestBody ManyToOneChild manyToOneChild) {
        LOGGER.debug("Editing ManyToOneChild with id: {}" , manyToOneChild.getChildPk());

        manyToOneChild.setChildPk(id);
        manyToOneChild = manyToOneChildService.update(manyToOneChild);
        LOGGER.debug("ManyToOneChild details with id: {}" , manyToOneChild);

        return manyToOneChild;
    }

    @ApiOperation(value = "Deletes the ManyToOneChild instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteManyToOneChild(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting ManyToOneChild with id: {}" , id);

        ManyToOneChild deletedManyToOneChild = manyToOneChildService.delete(id);

        return deletedManyToOneChild != null;
    }

    /**
     * @deprecated Use {@link #findManyToOneChilds(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of ManyToOneChild instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ManyToOneChild> searchManyToOneChildsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering ManyToOneChilds list by query filter:{}", (Object) queryFilters);
        return manyToOneChildService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ManyToOneChild instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ManyToOneChild> findManyToOneChilds(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ManyToOneChilds list by filter:", query);
        return manyToOneChildService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ManyToOneChild instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ManyToOneChild> filterManyToOneChilds(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ManyToOneChilds list by filter", query);
        return manyToOneChildService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportManyToOneChilds(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return manyToOneChildService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportManyToOneChildsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = ManyToOneChild.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> manyToOneChildService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of ManyToOneChild instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countManyToOneChilds( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting ManyToOneChilds");
		return manyToOneChildService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getManyToOneChildAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return manyToOneChildService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ManyToOneChildService instance
	 */
	protected void setManyToOneChildService(ManyToOneChildService service) {
		this.manyToOneChildService = service;
	}

}