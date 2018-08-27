/*Copyright (c) 2018-2019 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.basicsanity.testingdb_sql.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.basicsanity.testingdb_sql.ManyToOneChild;

/**
 * Service object for domain model class {@link ManyToOneChild}.
 */
public interface ManyToOneChildService {

    /**
     * Creates a new ManyToOneChild. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on ManyToOneChild if any.
     *
     * @param manyToOneChild Details of the ManyToOneChild to be created; value cannot be null.
     * @return The newly created ManyToOneChild.
     */
    ManyToOneChild create(@Valid ManyToOneChild manyToOneChild);


	/**
     * Returns ManyToOneChild by given id if exists.
     *
     * @param manytoonechildId The id of the ManyToOneChild to get; value cannot be null.
     * @return ManyToOneChild associated with the given manytoonechildId.
	 * @throws EntityNotFoundException If no ManyToOneChild is found.
     */
    ManyToOneChild getById(Integer manytoonechildId);

    /**
     * Find and return the ManyToOneChild by given id if exists, returns null otherwise.
     *
     * @param manytoonechildId The id of the ManyToOneChild to get; value cannot be null.
     * @return ManyToOneChild associated with the given manytoonechildId.
     */
    ManyToOneChild findById(Integer manytoonechildId);

	/**
     * Find and return the list of ManyToOneChilds by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param manytoonechildIds The id's of the ManyToOneChild to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return ManyToOneChilds associated with the given manytoonechildIds.
     */
    List<ManyToOneChild> findByMultipleIds(List<Integer> manytoonechildIds, boolean orderedReturn);


    /**
     * Updates the details of an existing ManyToOneChild. It replaces all fields of the existing ManyToOneChild with the given manyToOneChild.
     *
     * This method overrides the input field values using Server side or database managed properties defined on ManyToOneChild if any.
     *
     * @param manyToOneChild The details of the ManyToOneChild to be updated; value cannot be null.
     * @return The updated ManyToOneChild.
     * @throws EntityNotFoundException if no ManyToOneChild is found with given input.
     */
    ManyToOneChild update(@Valid ManyToOneChild manyToOneChild);

    /**
     * Deletes an existing ManyToOneChild with the given id.
     *
     * @param manytoonechildId The id of the ManyToOneChild to be deleted; value cannot be null.
     * @return The deleted ManyToOneChild.
     * @throws EntityNotFoundException if no ManyToOneChild found with the given id.
     */
    ManyToOneChild delete(Integer manytoonechildId);

    /**
     * Deletes an existing ManyToOneChild with the given object.
     *
     * @param manyToOneChild The instance of the ManyToOneChild to be deleted; value cannot be null.
     */
    void delete(ManyToOneChild manyToOneChild);

    /**
     * Find all ManyToOneChilds matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ManyToOneChilds.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<ManyToOneChild> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all ManyToOneChilds matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ManyToOneChilds.
     *
     * @see Pageable
     * @see Page
     */
    Page<ManyToOneChild> findAll(String query, Pageable pageable);

    /**
     * Exports all ManyToOneChilds matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
     */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

    /**
     * Exports all ManyToOneChilds matching the given input query to the given exportType format.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     * @see Pageable
     * @see OutputStream
     */
    void export(DataExportOptions options, Pageable pageable, OutputStream outputStream);

    /**
     * Retrieve the count of the ManyToOneChilds in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the ManyToOneChild.
     */
    long count(String query);

    /**
     * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return Paginated data with included fields.
     *
     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
    Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}