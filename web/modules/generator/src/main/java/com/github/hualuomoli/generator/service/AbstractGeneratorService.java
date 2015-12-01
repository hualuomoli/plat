package com.github.hualuomoli.generator.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.github.hualuomoli.generator.db.TrueFalse;
import com.github.hualuomoli.generator.entity.Column;
import com.github.hualuomoli.generator.entity.Param;
import com.github.hualuomoli.generator.entity.Table;
import com.github.hualuomoli.generator.mapper.IColumnMapper;
import com.github.hualuomoli.generator.mapper.ITableMapper;
import com.github.hualuomoli.generator.util.GeneratorUtils;

public abstract class AbstractGeneratorService implements IGeneratorService {

	// get tableMapper
	protected abstract ITableMapper getTableMapper();

	// get columnMapper
	protected abstract IColumnMapper getColumnMapper();

	// parse column 
	protected abstract void parseColumn(Column column);

	@Override
	public Table assemble(String tableName, String owner) {

		if (StringUtils.isBlank(tableName)) {
			throw new RuntimeException("please set table's name.");
		}
		if (StringUtils.isBlank(owner)) {
			throw new RuntimeException("please set owner.");
		}

		Table table = getTable(tableName, owner); // get table
		this.parseTable(table); // parse table
		this.addColumnList(table); // add column list
		this.parseColumns(table.getColumnList()); // parse columns

		return table;
	}

	// get table message
	private Table getTable(String tableName, String owner) {
		Table table = getTableMapper().get(tableName, owner);
		if (table == null) {
			throw new RuntimeException("There is no table " + owner + "." + tableName);
		}
		table.setOwner(owner);
		return table;
	}

	// add column list
	private void addColumnList(Table table) {
		List<Column> columnList = getColumnMapper().findList(table.getOwner(), table.getTableName());
		// check list size
		if (columnList == null || columnList.size() == 0) {
			throw new RuntimeException("There is no column in " + table.getOwner() + "." + table.getTableName());
		}

		// order by column by pk,position
		Collections.sort(columnList, new Comparator<Column>() {

			@Override
			public int compare(Column o1, Column o2) {
				String pk1 = o1.getPk();
				String pk2 = o2.getPk();

				if (TrueFalse.TRUE.equals(pk1) && TrueFalse.TRUE.equals(pk2)) {
					// o1 and o2 is primary key,order by position
					return o1.getPosition() - o2.getPosition();
				}
				if (TrueFalse.TRUE.equals(pk1)) {
					// o1 is primary key
					return -1;
				}
				if (TrueFalse.TRUE.equals(pk2)) {
					// o2 is primary key
					return 1;
				}

				// // o1 and o2 is not primary key,order by position
				return o1.getPosition() - o2.getPosition();
			}
		});

		// change column position,set pkSize
		int pkSize = 0;
		for (int i = 0; i < columnList.size(); i++) {
			Column column = columnList.get(i);
			column.setPosition(i + 1);
			if (TrueFalse.TRUE.equals(column.getPk())) {
				pkSize++;
			}
		}

		// set pkSize
		table.setPkSize(pkSize);
		// set default table params
		table.setParams(Param.getParams());

		// set table columns
		table.setColumnList(columnList);

	}

	// parse table message
	private void parseTable(Table table) {
		table.setJavaName(GeneratorUtils.parseTableName(table.getTableName()));
		table.setComments(GeneratorUtils.parseComment(table.getComments()));
	}

	// parse column message
	private void parseColumns(List<Column> columnList) {
		for (Column column : columnList) {
			column.setJavaName(GeneratorUtils.parseColumnName(column.getColumnName()));
			column.setComments(GeneratorUtils.parseComment(column.getComments()));
			this.parseColumn(column);
		}
	}

}
