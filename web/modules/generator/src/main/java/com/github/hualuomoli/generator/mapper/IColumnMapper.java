package com.github.hualuomoli.generator.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.hualuomoli.generator.entity.Column;

/**
 * find table columns such as columnName comments type
 * @author hualuomoli
 *
 */
public interface IColumnMapper {

	/**
	 * get column Attribute
	 * @param owner owner of the table
	 * @param tableName table's name
	 * @return Attributes
	 */
	List<Column> findList(@Param(value = "owner") String owner, @Param(value = "tableName") String tableName);

}
