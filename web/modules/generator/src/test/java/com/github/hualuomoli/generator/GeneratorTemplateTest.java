package com.github.hualuomoli.generator;

import java.io.File;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;

import com.github.hualuomoli.common.util.TemplateUtils;
import com.github.hualuomoli.generator.db.TrueFalse;
import com.github.hualuomoli.generator.entity.Column;
import com.github.hualuomoli.generator.entity.Param;
import com.github.hualuomoli.generator.entity.Table;
import com.github.hualuomoli.generator.service.IGeneratorService;
import com.github.hualuomoli.junit4.SpringTestRunner;

public class GeneratorTemplateTest extends SpringTestRunner {

	private static final String tplPath = "E:/github/web/web/modules/generator/src/main/resources/tpls";
	private static final String destPath = "E:/demo/src/main";
	@Resource(name = "mysqlGeneratorService")
	private IGeneratorService generatorService;

	private static Table commonTable;

	private static final String owner = "financial";
	private static final String tableName = "gen_demo";
	private static String packageName;

	private void init() {
		if (commonTable != null) {
			return;
		}
		Table table = generatorService.assemble(tableName, owner);
		// 增加查询
		// string
		Column name = table.getColumnList().get(2); // gen_name
		name.setQueryLike(TrueFalse.TRUE);
		name.setQueryLikeLeft(TrueFalse.TRUE);
		name.setQueryLikeRight(TrueFalse.TRUE);

		// double
		Column salary = table.getColumnList().get(4); // salary
		salary.setQueryStart(TrueFalse.TRUE);
		salary.setQueryEnd(TrueFalse.TRUE);
		salary.setQueryStartNoContain(TrueFalse.TRUE);
		salary.setQueryEndNoContain(TrueFalse.TRUE);

		// show
		salary.setShowStr(TrueFalse.TRUE);

		// date
		Column date = table.getColumnList().get(6); // create_date
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

		packageName = table.getParams().get(Param.PACKAGE).replaceAll("[.]", "/");

		commonTable = table;

		System.out.println(ToStringBuilder.reflectionToString(table.getColumnList().get(2)));

		System.out.println(ToStringBuilder.reflectionToString(table));
		System.out.println(ToStringBuilder.reflectionToString(commonTable));

	}

	@Test
	//	@Ignore
	public void testXml() {

		try {
			init();
			String data = TemplateUtils.getTemplateData(tplPath, "xml.ftl", commonTable);
			logger.debug(data);
			FileUtils.write(new File(destPath, "resources/mappers/" + commonTable.getJavaName() + "Mapper.xml"), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	//	@Ignore
	public void testEntity() {

		try {
			init();
			String data = TemplateUtils.getTemplateData(tplPath, "entity-basic.ftl", commonTable);
			logger.debug(data);
			FileUtils.write(new File(destPath, "java/" + packageName + "/basic/entity/" + commonTable.getJavaName() + "Basic.java"), data);

			data = TemplateUtils.getTemplateData(tplPath, "entity.ftl", commonTable);
			logger.debug(data);
			FileUtils.write(new File(destPath, "java/" + packageName + "/basic/entity/" + commonTable.getJavaName() + ".java"), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	//	@Ignore
	public void testMapper() {

		try {
			init();
			String data = TemplateUtils.getTemplateData(tplPath, "mapper.ftl", commonTable);
			logger.debug(data);
			FileUtils.write(new File(destPath, "java/" + packageName + "/basic/mapper/I" + commonTable.getJavaName() + "Mapper.java"), data);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
