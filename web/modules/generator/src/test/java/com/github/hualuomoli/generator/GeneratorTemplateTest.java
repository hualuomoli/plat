package com.github.hualuomoli.generator;

import javax.annotation.Resource;

import org.junit.Test;

import com.github.hualuomoli.generator.db.TrueFalse;
import com.github.hualuomoli.generator.entity.Column;
import com.github.hualuomoli.generator.entity.Table;
import com.github.hualuomoli.generator.service.IGeneratorService;
import com.github.hualuomoli.generator.util.GeneratorUtils;
import com.github.hualuomoli.junit4.SpringTestRunner;

public class GeneratorTemplateTest extends SpringTestRunner {

	@Resource(name = "mysqlGeneratorService")
	private IGeneratorService generatorService;

	private static final String tableName = "gen_demo";

	@Test
	public void test() {
		Table table = generatorService.assemble(tableName);
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

		try {
			GeneratorUtils.createFiles(table);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
