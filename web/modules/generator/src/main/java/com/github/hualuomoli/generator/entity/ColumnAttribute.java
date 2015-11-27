package com.github.hualuomoli.generator.entity;

import java.io.Serializable;

/**
 * column attribute such as column name, comments,type length
 * @author hualuomoli
 *
 */
public class ColumnAttribute implements Serializable {

	private static final long serialVersionUID = 5561701746562097694L;

	private String columnName;
	private Integer position; // column position in table, start is 1
	private String dataType;
	private Integer dataLength;
	private Integer dataPrecision;
	private Integer dataScale;

	private String nullable; // #TrueFalse
	private String dataDefault; // #TrueFalse

	private String comments;
	private String pk; // #TrueFalse

	public ColumnAttribute() {
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Integer getDataLength() {
		return dataLength;
	}

	public void setDataLength(Integer dataLength) {
		this.dataLength = dataLength;
	}

	public Integer getDataPrecision() {
		return dataPrecision;
	}

	public void setDataPrecision(Integer dataPrecision) {
		this.dataPrecision = dataPrecision;
	}

	public Integer getDataScale() {
		return dataScale;
	}

	public void setDataScale(Integer dataScale) {
		this.dataScale = dataScale;
	}

	public String getNullable() {
		return nullable;
	}

	public void setNullable(String nullable) {
		this.nullable = nullable;
	}

	public String getDataDefault() {
		return dataDefault;
	}

	public void setDataDefault(String dataDefault) {
		this.dataDefault = dataDefault;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

}
