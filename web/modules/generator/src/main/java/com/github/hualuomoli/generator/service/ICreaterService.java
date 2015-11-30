package com.github.hualuomoli.generator.service;

import com.github.hualuomoli.generator.entity.Table;

/**
 * create file of xml mapper service and entity
 * @author hualuomoli
 *
 */
public interface ICreaterService {

	/** create files */
	void create(Table table);

}
