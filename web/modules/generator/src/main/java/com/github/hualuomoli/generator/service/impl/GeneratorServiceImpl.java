package com.github.hualuomoli.generator.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hualuomoli.generator.db.DataBase;
import com.github.hualuomoli.generator.db.DataType;
import com.github.hualuomoli.generator.db.JavaType;
import com.github.hualuomoli.generator.db.TrueFalse;
import com.github.hualuomoli.generator.entity.Column;
import com.github.hualuomoli.generator.entity.ColumnAttribute;
import com.github.hualuomoli.generator.entity.Table;
import com.github.hualuomoli.generator.entity.column.DateColumn;
import com.github.hualuomoli.generator.entity.column.DoubleColumn;
import com.github.hualuomoli.generator.entity.column.FloatColumn;
import com.github.hualuomoli.generator.entity.column.IntegerColumn;
import com.github.hualuomoli.generator.entity.column.LongColumn;
import com.github.hualuomoli.generator.entity.column.StringColumn;
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
		List<ColumnAttribute> columnAttributeList = null;
		if (DataBase.DATABASE_MYSQL.equals(table.getDatabase())) {
			columnAttributeList = columnMapper.findList_mysql(table.getOwner(), table.getTableName());
		}

		return this.format(columnAttributeList);

	}

	/**
	 * format column message to specific ColumnType
	 * @param columnAttributeList query database column message
	 * @return Column Entity Message
	 */
	private List<Column> format(List<ColumnAttribute> columnAttributeList) {
		List<Column> columnList = Lists.newArrayList();
		if (columnAttributeList == null || columnAttributeList.size() == 0) {
			return columnList;
		}
		for (ColumnAttribute columnAttribute : columnAttributeList) {
			String dataType = columnAttribute.getDataType();
			if (DataType.STRING.contains(dataType)) {
				// string
				columnList.add(this.parseString(columnAttribute));
				continue;
			}
			if (DataType.INTEGER.contains(dataType)) {
				// integer
				columnList.add(this.parseInteger(columnAttribute));
				continue;
			}
			if (DataType.LONG.contains(dataType)) {
				// long
				columnList.add(this.parseLong(columnAttribute));
				continue;
			}
			if (DataType.FLOAT.contains(dataType)) {
				// float
				columnList.add(this.parseFloat(columnAttribute));
				continue;
			}
			if (DataType.DOUBLE.contains(dataType)) {
				// double
				columnList.add(this.parseDouble(columnAttribute));
				continue;
			}
			if (DataType.DATE.contains(dataType)) {
				// date
				columnList.add(this.parseDate(columnAttribute));
				continue;
			}

			// other such as number(10,2)
			columnList.add(this.parse(columnAttribute));

		}
		return columnList;
	}

	/** parse column data type to String */
	private Column parseString(ColumnAttribute columnAttribute) {
		StringColumn column = new StringColumn();
		this.addCommon(column, columnAttribute);
		column.setJavaType(JavaType.STRING);
		return column;
	}

	/** parse column data type to Integer */
	private Column parseInteger(ColumnAttribute columnAttribute) {
		IntegerColumn column = new IntegerColumn();
		this.addCommon(column, columnAttribute);
		column.setJavaType(JavaType.INTEGER);
		return column;
	}

	/** parse column data type to Long */
	private Column parseLong(ColumnAttribute columnAttribute) {
		LongColumn column = new LongColumn();
		this.addCommon(column, columnAttribute);
		column.setJavaType(JavaType.LONG);
		return column;
	}

	/** parse column data type to Float */
	private Column parseFloat(ColumnAttribute columnAttribute) {
		FloatColumn column = new FloatColumn();
		this.addCommon(column, columnAttribute);
		column.setJavaType(JavaType.FLOAT);
		return column;
	}

	/** parse column data type to Double */
	private Column parseDouble(ColumnAttribute columnAttribute) {
		DoubleColumn column = new DoubleColumn();
		this.addCommon(column, columnAttribute);
		column.setJavaType(JavaType.DOUBLE);
		return column;
	}

	/** parse column data type to Date */
	private Column parseDate(ColumnAttribute columnAttribute) {
		DateColumn column = new DateColumn();
		this.addCommon(column, columnAttribute);
		column.setJavaType(JavaType.DATE);
		return column;
	}

	/** check the column's java type */
	private Column parse(ColumnAttribute columnAttribute) {
		// TODO
		return null;
	}

	/**
	 * add common column message
	 * @param column column entity
	 * @param columnAttribute column attribute
	 */
	private void addCommon(Column column, ColumnAttribute columnAttribute) {
		column.setColumnName(this.parseName(columnAttribute.getColumnName()));
		column.setComments(this.parseComment(columnAttribute.getComments()));
		column.setPosition(columnAttribute.getPosition());
		column.setDataDefault(TrueFalse.TRUE.equals(columnAttribute.getDataDefault()));
		column.setNullable(TrueFalse.TRUE.equals(columnAttribute.getNullable()));
		column.setPk(TrueFalse.TRUE.equals(columnAttribute.getPk()));
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
