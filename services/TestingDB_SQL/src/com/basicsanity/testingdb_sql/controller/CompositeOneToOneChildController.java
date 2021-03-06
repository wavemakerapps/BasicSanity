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

import com.basicsanity.testingdb_sql.CompositeOneToOneChild;
import com.basicsanity.testingdb_sql.CompositeOneToOneParentId;
import com.basicsanity.testingdb_sql.service.CompositeOneToOneChildService;


/**
 * Controller object for domain model class CompositeOneToOneChild.
 * @see CompositeOneToOneChild
 */
@RestController("TestingDB_SQL.CompositeOneToOneChildController")
@Api(value = "CompositeOneToOneChildController", description = "Exposes APIs to work with CompositeOneToOneChild resource.")
@RequestMapping("/TestingDB_SQL/CompositeOneToOneChild")
public class CompositeOneToOneChildController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompositeOneToOneChildController.class);

    @Autowired
	@Qualifier("TestingDB_SQL.CompositeOneToOneChildService")
	private CompositeOneToOneChildService compositeOneToOneChildService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new CompositeOneToOneChild instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CompositeOneToOneChild createCompositeOneToOneChild(@RequestBody CompositeOneToOneChild compositeOneToOneChild) {
		LOGGER.debug("Create CompositeOneToOneChild with information: {}" , compositeOneToOneChild);

		compositeOneToOneChild = compositeOneToOneChildService.create(compositeOneToOneChild);
		LOGGER.debug("Created CompositeOneToOneChild with information: {}" , compositeOneToOneChild);

	    return compositeOneToOneChild;
	}

    @ApiOperation(value = "Returns the CompositeOneToOneChild instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CompositeOneToOneChild getCompositeOneToOneChild(@RequestParam("compId") Integer compId, @RequestParam("compName") String compName) {

        CompositeOneToOneParentId compositeonetoonechildId = new CompositeOneToOneParentId();
        compositeonetoonechildId.setCompId(compId);
        compositeonetoonechildId.setCompName(compName);

        LOGGER.debug("Getting CompositeOneToOneChild with id: {}" , compositeonetoonechildId);
        CompositeOneToOneChild compositeOneToOneChild = compositeOneToOneChildService.getById(compositeonetoonechildId);
        LOGGER.debug("CompositeOneToOneChild details with id: {}" , compositeOneToOneChild);

        return compositeOneToOneChild;
    }



    @ApiOperation(value = "Updates the CompositeOneToOneChild instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CompositeOneToOneChild editCompositeOneToOneChild(@RequestParam("compId") Integer compId, @RequestParam("compName") String compName, @RequestBody CompositeOneToOneChild compositeOneToOneChild) {

        compositeOneToOneChild.setCompId(compId);
        compositeOneToOneChild.setCompName(compName);

        LOGGER.debug("CompositeOneToOneChild details with id is updated with: {}" , compositeOneToOneChild);

        return compositeOneToOneChildService.update(compositeOneToOneChild);
    }


    @ApiOperation(value = "Deletes the CompositeOneToOneChild instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteCompositeOneToOneChild(@RequestParam("compId") Integer compId, @RequestParam("compName") String compName) {

        CompositeOneToOneParentId compositeonetoonechildId = new CompositeOneToOneParentId();
        compositeonetoonechildId.setCompId(compId);
        compositeonetoonechildId.setCompName(compName);

        LOGGER.debug("Deleting CompositeOneToOneChild with id: {}" , compositeonetoonechildId);
        CompositeOneToOneChild compositeOneToOneChild = compositeOneToOneChildService.delete(compositeonetoonechildId);

        return compositeOneToOneChild != null;
    }


    /**
     * @deprecated Use {@link #findCompositeOneToOneChilds(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of CompositeOneToOneChild instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CompositeOneToOneChild> searchCompositeOneToOneChildsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering CompositeOneToOneChilds list by query filter:{}", (Object) queryFilters);
        return compositeOneToOneChildService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of CompositeOneToOneChild instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CompositeOneToOneChild> findCompositeOneToOneChilds(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering CompositeOneToOneChilds list by filter:", query);
        return compositeOneToOneChildService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of CompositeOneToOneChild instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CompositeOneToOneChild> filterCompositeOneToOneChilds(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering CompositeOneToOneChilds list by filter", query);
        return compositeOneToOneChildService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportCompositeOneToOneChilds(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return compositeOneToOneChildService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportCompositeOneToOneChildsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = CompositeOneToOneChild.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> compositeOneToOneChildService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of CompositeOneToOneChild instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countCompositeOneToOneChilds( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting CompositeOneToOneChilds");
		return compositeOneToOneChildService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getCompositeOneToOneChildAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return compositeOneToOneChildService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CompositeOneToOneChildService instance
	 */
	protected void setCompositeOneToOneChildService(CompositeOneToOneChildService service) {
		this.compositeOneToOneChildService = service;
	}

}