package com.github.hualuomoli.generator;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.hualuomoli.common.util.TemplateUtils;
import com.github.hualuomoli.generator.db.DataBase;
import com.github.hualuomoli.generator.db.TrueFalse;
import com.github.hualuomoli.generator.entity.Column;
import com.github.hualuomoli.generator.entity.Param;
import com.github.hualuomoli.generator.entity.Table;
import com.github.hualuomoli.generator.service.IGeneratorService;
import com.github.hualuomoli.junit4.SpringTestRunner;

public class GeneratorTemplateTest extends SpringTestRunner {

	private static final String tplPath = "E:/github/web/web/modules/generator/src/main/resources/tpls";
	private static final String destPath = "E:/demo/src/main";
	@Autowired
	private IGeneratorService generatorService;
	private static Table table;

	@BeforeClass
	public static void beforeClass() {
		table = new Table();
		table.setTableName("gen_demo");
		table.setComments("代码生成器测试");
		table.setDatabase(DataBase.DATABASE_MYSQL);
		table.setOwner("financial");
		table.setJavaName("GenDemo");

		table.setParams(Param.getParams());

	}

	private void init() {
		table.setColumnList(generatorService.assemble(table));
		// 增加查询
		// string
		Column name = table.getColumnList().get(2);
		name.setQueryLike(TrueFalse.TRUE);
		name.setQueryLikeLeft(TrueFalse.TRUE);
		name.setQueryLikeRight(TrueFalse.TRUE);

		// double
		Column salary = table.getColumnList().get(4);
		salary.setQueryStart(TrueFalse.TRUE);
		salary.setQueryEnd(TrueFalse.TRUE);
		salary.setQueryStartNoContain(TrueFalse.TRUE);
		salary.setQueryEndNoContain(TrueFalse.TRUE);

		// show
		salary.setShowStr(TrueFalse.TRUE);

		// date
		Column date = table.getColumnList().get(6);
		date.setQueryStart(TrueFalse.TRUE);
		date.setQueryEnd(TrueFalse.TRUE);
		date.setQueryStartNoContain(TrueFalse.TRUE);
		date.setQueryEndNoContain(TrueFalse.TRUE);

		// show
		date.setShowBarYmd(TrueFalse.TRUE);
		date.setShowBarYmdHms(TrueFalse.TRUE);
		date.setShowSlashYmd(TrueFalse.TRUE);
		date.setShowSlashYmdHms(TrueFalse.TRUE);
		date.setShowYmd(TrueFalse.TRUE);
		date.setShowYmdHms(TrueFalse.TRUE);
		date.setShowHms(TrueFalse.TRUE);
		date.setShowColonHms(TrueFalse.TRUE);

	}

	@Test
	@Ignore
	public void testXml() {

		try {
			init();
			String data = TemplateUtils.getTemplateData(tplPath, "xml.ftl", table);
			logger.debug(data);
			FileUtils.write(new File(destPath, "resources/mappers/" + table.getJavaName() + "Mapper.xml"), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void testEntity() {

		try {
			String packageName = table.getParams().get(Param.PACKAGE).replaceAll("[.]", "/");
			init();
			String data = TemplateUtils.getTemplateData(tplPath, "entity-basic.ftl", table);
			logger.debug(data);
			FileUtils.write(new File(destPath, "java/" + packageName + "/basic/entity/" + table.getJavaName() + "Basic.java"), data);

			data = TemplateUtils.getTemplateData(tplPath, "entity.ftl", table);
			logger.debug(data);
			FileUtils.write(new File(destPath, "java/" + packageName + "/basic/entity/" + table.getJavaName() + ".java"), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	//	@Ignore
	public void testMapper() {

		try {
			String packageName = table.getParams().get(Param.PACKAGE).replaceAll("[.]", "/");
			init();
			String data = TemplateUtils.getTemplateData(tplPath, "mapper.ftl", table);
			logger.debug(data);
			FileUtils.write(new File(destPath, "java/" + packageName + "/basic/mapper/I" + table.getJavaName() + "Mapper.java"), data);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
