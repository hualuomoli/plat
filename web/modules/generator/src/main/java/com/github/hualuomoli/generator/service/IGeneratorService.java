package com.github.hualuomoli.generator.service;

import com.github.hualuomoli.generator.entity.Table;

/**
 * generator service
 * query table message and column message
 * Assemble to a Table entity
 * @author hualuomoli
 *
 */
public interface IGeneratorService {

	/**
	 * assemble message to a table Entity
	 * @param tableName table's name
	 * @param owner table owner
	 * @return table message
	 */
	Table assemble(String tableName, String owner);

}
