package com.github.hualuomoli.generator.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.hualuomoli.generator.entity.Table;

/**
 * find Table message such tableName comments
 * @author hualuomoli
 *
 */
public interface ITableMapper {

	/** find table list by table owner */
	List<Table> findList(@Param(value = "owner") String owner);

	/** get table message by table name and table owner */
	Table get(@Param(value = "tableName") String tableName, @Param(value = "owner") String owner);

}
