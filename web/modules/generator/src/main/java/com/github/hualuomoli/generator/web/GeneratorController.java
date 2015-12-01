package com.github.hualuomoli.generator.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.hualuomoli.commons.json.JsonMapper;
import com.github.hualuomoli.generator.entity.Column;
import com.github.hualuomoli.generator.entity.Table;
import com.github.hualuomoli.generator.service.IGeneratorService;
import com.google.common.collect.Lists;

@Controller
@RequestMapping(value = "generator")
public class GeneratorController {

	@Autowired
	private IGeneratorService generatorService;

	@RequestMapping(value = { "", "listData" })
	@ResponseBody
	public String listData(HttpServletRequest request, HttpServletResponse response) {
		Table table = new Table();
		table.setOwner(request.getParameter("owner"));
		table.setDatabase(request.getParameter("database"));
		table.setTableName(request.getParameter("tableName"));
		List<Column> dataList = Lists.newArrayList();
		//generatorService.assemble(table);
		return JsonMapper.toJsonString(dataList);
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
