package com.github.hualuomoli.generator.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.github.hualuomoli.generator.entity.ColumnAttribute;

/**
 * find table columns such as columnName comments type
 * @author hualuomoli
 *
 */
@Repository
public interface IColumnMapper {

	/**
	 * get column Attribute
	 * @param schema owner of the table
	 * @param tableName table's name
	 * @return Attributes
	 */
	List<ColumnAttribute> findList_mysql(@Param(value = "schema") String schema, @Param(value = "tableName") String tableName);

}
