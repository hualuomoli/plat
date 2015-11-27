package com.github.hualuomoli.generator.service;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.hualuomoli.generator.db.DataBase;
import com.github.hualuomoli.generator.entity.Column;
import com.github.hualuomoli.generator.entity.Table;
import com.github.hualuomoli.junit4.SpringTestRunner;

public class IGeneratorServiceTest extends SpringTestRunner {

	@Autowired
	private IGeneratorService generatorService;

	@Test
	public void testAssemble() {
		Table table = new Table();
		table.setTableName("demo");
		table.setDatabase(DataBase.DATABASE_MYSQL);
		table.setOwner("ln_test");
		List<Column> list = generatorService.assemble(table);
		for (Column column : list) {
			logger.debug(ToStringBuilder.reflectionToString(column));
		}
	}

}
