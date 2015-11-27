package com.github.hualuomoli.generator.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Table Message entity
 * @author hualuomoli
 *
 */
public class Table implements Serializable {

	private static final long serialVersionUID = 330163532973316097L;

	private String tableName;
	private String owner;
	private String comments;
	private String database; // database name #DataBase

	private List<Column> columnList;

	public Table() {
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public List<Column> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<Column> columnList) {
		this.columnList = columnList;
	}

}
