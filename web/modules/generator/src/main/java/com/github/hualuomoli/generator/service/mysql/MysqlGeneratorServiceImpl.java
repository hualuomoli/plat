package com.github.hualuomoli.generator.service.mysql;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.hualuomoli.generator.db.JavaType;
import com.github.hualuomoli.generator.entity.Column;
import com.github.hualuomoli.generator.mapper.IColumnMapper;
import com.github.hualuomoli.generator.mapper.ITableMapper;
import com.github.hualuomoli.generator.service.AbstractGeneratorService;

/**
 * Mysql generator
 * @author hualuomoli
 *
 */
@Service(value = "mysqlGeneratorService")
public class MysqlGeneratorServiceImpl extends AbstractGeneratorService {

	@Resource(name = "mysqlTableMapper")
	private ITableMapper tableMapper;
	@Resource(name = "mysqlColumnMapper")
	private IColumnMapper columnMapper;

	@Override
	protected ITableMapper getTableMapper() {
		return tableMapper;
	}

	@Override
	protected IColumnMapper getColumnMapper() {
		return columnMapper;
	}

	@Override
	protected void parseColumn(Column column) {

		String dataType = column.getDataType();

		if (DataType.STRING.contains(dataType)) {
			// string
			column.setJavaType(JavaType.STRING);
			return;
		}
		if (DataType.INTEGER.contains(dataType)) {
			// integer
			column.setJavaType(JavaType.INTEGER);
			return;
		}
		if (DataType.LONG.contains(dataType)) {
			// long
			column.setJavaType(JavaType.LONG);
			return;
		}
		if (DataType.FLOAT.contains(dataType)) {
			// float
			column.setJavaType(JavaType.FLOAT);
			return;
		}
		if (DataType.DOUBLE.contains(dataType)) {
			// double
			column.setJavaType(JavaType.DOUBLE);
			return;
		}
		if (DataType.DATE.contains(dataType)) {
			// date
			column.setJavaType(JavaType.DATE);
			return;
		}
		throw new RuntimeException("dataType " + dataType + " con't be Resolve");
	}

}
