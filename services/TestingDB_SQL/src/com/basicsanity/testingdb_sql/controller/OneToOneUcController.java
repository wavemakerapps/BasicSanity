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

import com.basicsanity.testingdb_sql.OneToOneUc;
import com.basicsanity.testingdb_sql.service.OneToOneUcService;


/**
 * Controller object for domain model class OneToOneUc.
 * @see OneToOneUc
 */
@RestController("TestingDB_SQL.OneToOneUcController")
@Api(value = "OneToOneUcController", description = "Exposes APIs to work with OneToOneUc resource.")
@RequestMapping("/TestingDB_SQL/OneToOneUc")
public class OneToOneUcController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OneToOneUcController.class);

    @Autowired
	@Qualifier("TestingDB_SQL.OneToOneUcService")
	private OneToOneUcService oneToOneUcService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new OneToOneUc instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public OneToOneUc createOneToOneUc(@RequestBody OneToOneUc oneToOneUc) {
		LOGGER.debug("Create OneToOneUc with information: {}" , oneToOneUc);

		oneToOneUc = oneToOneUcService.create(oneToOneUc);
		LOGGER.debug("Created OneToOneUc with information: {}" , oneToOneUc);

	    return oneToOneUc;
	}

    @ApiOperation(value = "Returns the OneToOneUc instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public OneToOneUc getOneToOneUc(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting OneToOneUc with id: {}" , id);

        OneToOneUc foundOneToOneUc = oneToOneUcService.getById(id);
        LOGGER.debug("OneToOneUc details with id: {}" , foundOneToOneUc);

        return foundOneToOneUc;
    }

    @ApiOperation(value = "Updates the OneToOneUc instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public OneToOneUc editOneToOneUc(@PathVariable("id") Integer id, @RequestBody OneToOneUc oneToOneUc) {
        LOGGER.debug("Editing OneToOneUc with id: {}" , oneToOneUc.getPkColumn());

        oneToOneUc.setPkColumn(id);
        oneToOneUc = oneToOneUcService.update(oneToOneUc);
        LOGGER.debug("OneToOneUc details with id: {}" , oneToOneUc);

        return oneToOneUc;
    }

    @ApiOperation(value = "Deletes the OneToOneUc instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteOneToOneUc(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting OneToOneUc with id: {}" , id);

        OneToOneUc deletedOneToOneUc = oneToOneUcService.delete(id);

        return deletedOneToOneUc != null;
    }

    @RequestMapping(value = "/uniqueParentId/{uniqueParentId}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching OneToOneUc with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public OneToOneUc getByUniqueParentId(@PathVariable("uniqueParentId") Integer uniqueParentId) {
        LOGGER.debug("Getting OneToOneUc with uniques key UniqueParentId");
        return oneToOneUcService.getByUniqueParentId(uniqueParentId);
    }

    /**
     * @deprecated Use {@link #findOneToOneUcs(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of OneToOneUc instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<OneToOneUc> searchOneToOneUcsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering OneToOneUcs list by query filter:{}", (Object) queryFilters);
        return oneToOneUcService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of OneToOneUc instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<OneToOneUc> findOneToOneUcs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering OneToOneUcs list by filter:", query);
        return oneToOneUcService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of OneToOneUc instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<OneToOneUc> filterOneToOneUcs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering OneToOneUcs list by filter", query);
        return oneToOneUcService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportOneToOneUcs(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return oneToOneUcService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportOneToOneUcsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = OneToOneUc.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> oneToOneUcService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of OneToOneUc instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countOneToOneUcs( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting OneToOneUcs");
		return oneToOneUcService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getOneToOneUcAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return oneToOneUcService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service OneToOneUcService instance
	 */
	protected void setOneToOneUcService(OneToOneUcService service) {
		this.oneToOneUcService = service;
	}

}