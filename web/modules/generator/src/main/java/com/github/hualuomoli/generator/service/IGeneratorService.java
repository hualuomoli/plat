package com.github.hualuomoli.generator.service;

import java.util.List;

import com.github.hualuomoli.generator.entity.Column;
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
	 * @param table table's name and comments
	 * @return  Column Entity Message
	 */
	List<Column> assemble(Table table);

}
