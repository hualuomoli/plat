package com.github.hualuomoli.generator.entity;

import java.io.Serializable;

/**
 * Column Message
 * @author hualuomoli
 *
 */
public abstract class Column implements Serializable {

	private static final long serialVersionUID = -6425870390798526252L;

	protected String columnName;
	protected String comments;
	protected String javaType;
	protected Integer position;
	protected Boolean nullable; // #TrueFalse
	protected Boolean dataDefault; // #TrueFalse
	protected Boolean pk; // #TrueFalse

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Boolean getNullable() {
		return nullable;
	}

	public void setNullable(Boolean nullable) {
		this.nullable = nullable;
	}

	public Boolean getDataDefault() {
		return dataDefault;
	}

	public void setDataDefault(Boolean dataDefault) {
		this.dataDefault = dataDefault;
	}

	public Boolean getPk() {
		return pk;
	}

	public void setPk(Boolean pk) {
		this.pk = pk;
	}

}
