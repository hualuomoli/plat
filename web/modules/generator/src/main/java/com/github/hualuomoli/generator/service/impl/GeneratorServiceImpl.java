package com.github.hualuomoli.generator.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hualuomoli.generator.db.DataBase;
import com.github.hualuomoli.generator.db.DataType;
import com.github.hualuomoli.generator.db.JavaType;
import com.github.hualuomoli.generator.entity.Column;
import com.github.hualuomoli.generator.entity.Table;
import com.github.hualuomoli.generator.mapper.IColumnMapper;
import com.github.hualuomoli.generator.service.IGeneratorService;
import com.google.common.collect.Lists;

@Service
public class GeneratorServiceImpl implements IGeneratorService {

	//	@Autowired
	//	private ITableMapper tableMapper;
	@Autowired
	private IColumnMapper columnMapper;

	@Override
	public List<Column> assemble(Table table) {
		if (table == null || StringUtils.isBlank(table.getTableName())) {
			throw new RuntimeException("please set table's name.");
		}
		if (StringUtils.isBlank(table.getDatabase())) {
			throw new RuntimeException("please set database name.");
		}
		List<Column> columnList = null;
		if (DataBase.DATABASE_MYSQL.equals(table.getDatabase())) {
			columnList = columnMapper.findList_mysql(table.getOwner(), table.getTableName());
		}

		return this.format(columnList);

	}

	/**
	 * format column message to specific ColumnType
	 * @param columnAttributeList query database column message
	 * @return Column Entity Message
	 */
	private List<Column> format(List<Column> ColumnList) {
		if (ColumnList == null || ColumnList.size() == 0) {
			return Lists.newArrayList();
		}
		for (Column column : ColumnList) {

			column.setJavaName(this.parseName(column.getColumnName()));
			column.setComments(this.parseComment(column.getComments()));

			String dataType = column.getDataType();

			if (DataType.STRING.contains(dataType)) {
				// string
				column.setJavaType(JavaType.STRING);
				continue;
			}
			if (DataType.INTEGER.contains(dataType)) {
				// integer
				column.setJavaType(JavaType.INTEGER);
				continue;
			}
			if (DataType.LONG.contains(dataType)) {
				// long
				column.setJavaType(JavaType.LONG);
				continue;
			}
			if (DataType.FLOAT.contains(dataType)) {
				// float
				column.setJavaType(JavaType.FLOAT);
				continue;
			}
			if (DataType.DOUBLE.contains(dataType)) {
				// double
				column.setJavaType(JavaType.DOUBLE);
				continue;
			}
			if (DataType.DATE.contains(dataType)) {
				// date
				column.setJavaType(JavaType.DATE);
				continue;
			}

			// other such as number(10,2)
			// TODO

		}
		return ColumnList;
	}

	/**
	 * parse column name to java such as parse user_name to userName
	 * @param columnName column's name such as user_name
	 * @return column's java name such as userName
	 */
	private String parseName(String columnName) {
		if (StringUtils.isBlank(columnName)) {
			return StringUtils.EMPTY;
		}
		columnName = columnName.toLowerCase();
		String[] array = columnName.split("[_]");
		if (array.length == 1) { // column's name don't has _ such as address
			return columnName;
		}
		StringBuilder buffer = new StringBuilder(); // column's name has _ such as user_name
		buffer.append(array[0]); // append string user
		String temp;
		for (int i = 1; i < array.length; i++) {
			temp = array[i];
			temp = temp.substring(0, 1).toUpperCase() + temp.substring(1);
			buffer.append(temp);
		}
		return buffer.toString();
	}

	/** parse comments */
	private String parseComment(String comments) {
		if (StringUtils.isBlank(comments)) {
			return StringUtils.EMPTY;
		}
		// replace Enter to four blank
		String regex = "\\r";
		return comments.replaceAll(regex, "    ");
	}

}
