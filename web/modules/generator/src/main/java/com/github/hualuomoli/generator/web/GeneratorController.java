package com.github.hualuomoli.generator.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.hualuomoli.commons.json.JsonMapper;
import com.github.hualuomoli.generator.db.DataBase;
import com.github.hualuomoli.generator.entity.Column;
import com.github.hualuomoli.generator.entity.Table;
import com.github.hualuomoli.generator.service.IGeneratorService;

@Controller
@RequestMapping(value = "generator")
public class GeneratorController {

	@Resource(name = "mysqlGeneratorService")
	private IGeneratorService mysqlGeneratorService;

	@Value(value = "database")
	private String dataBase;

	// table
	@RequestMapping(value = "tableList")
	@ResponseBody
	public String tableList(HttpServletRequest request, HttpServletResponse response) {
		//		mysqlGeneratorService
		List<Table> tableList = null;
		if (DataBase.DATABASE_MYSQL.equals(dataBase)) {
			tableList = mysqlGeneratorService.findTableList();
		}
		String data = JsonMapper.toJsonString(tableList);
		return data;
	}

	// column
	@RequestMapping(value = "columnList")
	@ResponseBody
	public String columnList(HttpServletRequest request, HttpServletResponse response) {
		String tableName = request.getParameter("tableName");
		Table table = null;
		if (DataBase.DATABASE_MYSQL.equals(dataBase)) {
			table = mysqlGeneratorService.assemble(tableName);
		}
		String data = JsonMapper.toJsonString(table);
		return data;
	}

	@RequestMapping(value = "save")
	@ResponseBody
	public String save(HttpServletRequest request, HttpServletResponse response) {
		String data = null;
		Map<String, Object> map = request.getParameterMap();
		for (String key : map.keySet()) {
			if (data != null)
				break;
			data = key;
		}

		System.out.println(data);
		Table table = JsonMapper.fromJsonString(data, Table.class);
		System.out.println(ToStringBuilder.reflectionToString(table));
		List<Column> list = table.getColumnList();
		for (Column column : list) {
			System.out.println(ToStringBuilder.reflectionToString(column));
		}
		return "{\"retCode\":\"0000\",\"retMsg\":\"生成成功\"}";
	}

}
