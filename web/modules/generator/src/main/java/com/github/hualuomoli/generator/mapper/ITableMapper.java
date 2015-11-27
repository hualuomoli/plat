package com.github.hualuomoli.generator.mapper;

import java.util.List;

import com.github.hualuomoli.generator.entity.Table;

/**
 * find Table message such tableName comments
 * @author hualuomoli
 *
 */
public interface ITableMapper {

	List<Table> findList(Table table);

}
