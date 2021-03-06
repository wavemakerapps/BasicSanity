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

import com.basicsanity.testingdb_sql.CompositePkToNonPkChild;
import com.basicsanity.testingdb_sql.service.CompositePkToNonPkChildService;


/**
 * Controller object for domain model class CompositePkToNonPkChild.
 * @see CompositePkToNonPkChild
 */
@RestController("TestingDB_SQL.CompositePkToNonPkChildController")
@Api(value = "CompositePkToNonPkChildController", description = "Exposes APIs to work with CompositePkToNonPkChild resource.")
@RequestMapping("/TestingDB_SQL/CompositePkToNonPkChild")
public class CompositePkToNonPkChildController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompositePkToNonPkChildController.class);

    @Autowired
	@Qualifier("TestingDB_SQL.CompositePkToNonPkChildService")
	private CompositePkToNonPkChildService compositePkToNonPkChildService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new CompositePkToNonPkChild instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CompositePkToNonPkChild createCompositePkToNonPkChild(@RequestBody CompositePkToNonPkChild compositePkToNonPkChild) {
		LOGGER.debug("Create CompositePkToNonPkChild with information: {}" , compositePkToNonPkChild);

		compositePkToNonPkChild = compositePkToNonPkChildService.create(compositePkToNonPkChild);
		LOGGER.debug("Created CompositePkToNonPkChild with information: {}" , compositePkToNonPkChild);

	    return compositePkToNonPkChild;
	}

    @ApiOperation(value = "Returns the CompositePkToNonPkChild instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CompositePkToNonPkChild getCompositePkToNonPkChild(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting CompositePkToNonPkChild with id: {}" , id);

        CompositePkToNonPkChild foundCompositePkToNonPkChild = compositePkToNonPkChildService.getById(id);
        LOGGER.debug("CompositePkToNonPkChild details with id: {}" , foundCompositePkToNonPkChild);

        return foundCompositePkToNonPkChild;
    }

    @ApiOperation(value = "Updates the CompositePkToNonPkChild instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CompositePkToNonPkChild editCompositePkToNonPkChild(@PathVariable("id") Integer id, @RequestBody CompositePkToNonPkChild compositePkToNonPkChild) {
        LOGGER.debug("Editing CompositePkToNonPkChild with id: {}" , compositePkToNonPkChild.getCompositeChildId());

        compositePkToNonPkChild.setCompositeChildId(id);
        compositePkToNonPkChild = compositePkToNonPkChildService.update(compositePkToNonPkChild);
        LOGGER.debug("CompositePkToNonPkChild details with id: {}" , compositePkToNonPkChild);

        return compositePkToNonPkChild;
    }

    @ApiOperation(value = "Deletes the CompositePkToNonPkChild instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteCompositePkToNonPkChild(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting CompositePkToNonPkChild with id: {}" , id);

        CompositePkToNonPkChild deletedCompositePkToNonPkChild = compositePkToNonPkChildService.delete(id);

        return deletedCompositePkToNonPkChild != null;
    }

    /**
     * @deprecated Use {@link #findCompositePkToNonPkChilds(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of CompositePkToNonPkChild instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CompositePkToNonPkChild> searchCompositePkToNonPkChildsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering CompositePkToNonPkChilds list by query filter:{}", (Object) queryFilters);
        return compositePkToNonPkChildService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of CompositePkToNonPkChild instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CompositePkToNonPkChild> findCompositePkToNonPkChilds(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering CompositePkToNonPkChilds list by filter:", query);
        return compositePkToNonPkChildService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of CompositePkToNonPkChild instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CompositePkToNonPkChild> filterCompositePkToNonPkChilds(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering CompositePkToNonPkChilds list by filter", query);
        return compositePkToNonPkChildService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportCompositePkToNonPkChilds(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return compositePkToNonPkChildService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportCompositePkToNonPkChildsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = CompositePkToNonPkChild.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> compositePkToNonPkChildService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of CompositePkToNonPkChild instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countCompositePkToNonPkChilds( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting CompositePkToNonPkChilds");
		return compositePkToNonPkChildService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getCompositePkToNonPkChildAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return compositePkToNonPkChildService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CompositePkToNonPkChildService instance
	 */
	protected void setCompositePkToNonPkChildService(CompositePkToNonPkChildService service) {
		this.compositePkToNonPkChildService = service;
	}

}