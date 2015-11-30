package com.github.hualuomoli.generator;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.hualuomoli.common.util.TemplateUtils;
import com.github.hualuomoli.generator.db.DataBase;
import com.github.hualuomoli.generator.entity.Param;
import com.github.hualuomoli.generator.entity.Table;
import com.github.hualuomoli.generator.service.IGeneratorService;
import com.github.hualuomoli.junit4.SpringTestRunner;

public class XmlTemplateTest extends SpringTestRunner {

	@Autowired
	private IGeneratorService generatorService;

	@Test
	public void test() {
		Table table = new Table();
		table.setTableName("financial");
		table.setComments("理财");
		table.setDatabase(DataBase.DATABASE_MYSQL);
		table.setOwner("financial");
		table.setJavaName("earn");

		table.setParams(Param.getParams());

		table.setColumnList(generatorService.assemble(table));
		try {
			String data = TemplateUtils.getTemplateData("E:/github/web/web/modules/generator/src/main/resources/tpls", "xml.ftl", table);
			logger.debug(data);
			FileUtils.write(new File("E:/data.xml"), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
