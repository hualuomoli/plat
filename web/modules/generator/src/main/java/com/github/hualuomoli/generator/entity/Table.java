package com.github.hualuomoli.generator.entity;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Table Message entity
 * @author hualuomoli
 *
 */
public class Table implements Serializable {

	private static final long serialVersionUID = 330163532973316097L;

	private String tableName;
	private String javaName;
	private String owner;
	private String comments;

	private List<Column> columnList;

	// 
	private Integer pkSize; // primary key size
	private Param params; // params

	public Table() {
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getJavaName() {
		return javaName;
	}

	public void setJavaName(String javaName) {
		this.javaName = javaName;
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

	public List<Column> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<Column> columnList) {
		this.columnList = columnList;
	}

	public Integer getPkSize() {
		return pkSize;
	}

	public void setPkSize(Integer pkSize) {
		this.pkSize = pkSize;
	}

	public Param getParams() {
		return params;
	}

	public void setParams(Param params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
