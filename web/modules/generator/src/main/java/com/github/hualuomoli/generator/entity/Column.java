package com.github.hualuomoli.generator.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.github.hualuomoli.generator.db.TrueFalse;

/**
 * Column Message
 * @author hualuomoli
 *
 */
public class Column implements Serializable {

	private static final long serialVersionUID = -6425870390798526252L;

	private String columnName;
	private String comments;
	private String javaType;
	private String javaName;
	private Integer position;
	private String nullable = TrueFalse.TRUE; // #TrueFalse
	private String dataDefault = TrueFalse.FALSE; // #TrueFalse
	private String pk = TrueFalse.FALSE; // #TrueFalse

	/////////////////////////////////////////
	private String dataType;
	private Long dataLength; // mysql longtext data type is out of Integer length
	private Integer dataPrecision;
	private Integer dataScale;

	///// show
	// number
	private String showStr = TrueFalse.FALSE; // string show float data such as 1.20
	// data
	private String showSlashYmd = TrueFalse.FALSE; // yyyy/MM/dd such as 2015/10/01
	private String showSlashYmdHms = TrueFalse.FALSE; // yyyy/MM/dd HH:mm:ss such as 2015/10/01 13:05:29
	private String showBarYmd = TrueFalse.FALSE; // yyyy-MM-dd such as 2015-10-01
	private String showBarYmdHms = TrueFalse.FALSE; // yyyy-MM-dd HH:mm:ss such as 2015-10-01 13:05:29
	private String showYmd = TrueFalse.FALSE; // yyyyMMdd such as 20151001
	private String showYmdHms = TrueFalse.FALSE; // yyyyMMddHHmmss such as 20151001130529
	private String showColonHms = TrueFalse.FALSE; // HH:mm:ss such as 13:05:29
	private String showHms = TrueFalse.FALSE; // HHmmss such as 130529

	///// query
	// number, date
	private String queryStart = TrueFalse.FALSE; // query start contain this value. such as salary >= queryStart
	private String queryEnd = TrueFalse.FALSE; // query end contain this value. such as salary <= queryEnd
	private String queryStartNoContain = TrueFalse.FALSE; // query start no contain this value. such as salary > queryStartNoContain
	private String queryEndNoContain = TrueFalse.FALSE; // query end no contain this value. such as salary < queryEndNoContain
	// string
	private String queryLikeLeft = TrueFalse.FALSE; // query like left. such as name like '%queryLikeLeft'
	private String queryLikeRight = TrueFalse.FALSE; // query like right. such as name like 'queryLikeRight%'
	private String queryLike = TrueFalse.FALSE; // query like both left and right. such as name like '%queryLike%'

	public Column() {
	}

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

	public String getJavaName() {
		return javaName;
	}

	public void setJavaName(String javaName) {
		this.javaName = javaName;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
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

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Long getDataLength() {
		return dataLength;
	}

	public void setDataLength(Long dataLength) {
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

	public String getShowStr() {
		return showStr;
	}

	public void setShowStr(String showStr) {
		this.showStr = showStr;
	}

	public String getShowSlashYmd() {
		return showSlashYmd;
	}

	public void setShowSlashYmd(String showSlashYmd) {
		this.showSlashYmd = showSlashYmd;
	}

	public String getShowSlashYmdHms() {
		return showSlashYmdHms;
	}

	public void setShowSlashYmdHms(String showSlashYmdHms) {
		this.showSlashYmdHms = showSlashYmdHms;
	}

	public String getShowBarYmd() {
		return showBarYmd;
	}

	public void setShowBarYmd(String showBarYmd) {
		this.showBarYmd = showBarYmd;
	}

	public String getShowBarYmdHms() {
		return showBarYmdHms;
	}

	public void setShowBarYmdHms(String showBarYmdHms) {
		this.showBarYmdHms = showBarYmdHms;
	}

	public String getShowYmd() {
		return showYmd;
	}

	public void setShowYmd(String showYmd) {
		this.showYmd = showYmd;
	}

	public String getShowYmdHms() {
		return showYmdHms;
	}

	public void setShowYmdHms(String showYmdHms) {
		this.showYmdHms = showYmdHms;
	}

	public String getShowColonHms() {
		return showColonHms;
	}

	public void setShowColonHms(String showColonHms) {
		this.showColonHms = showColonHms;
	}

	public String getShowHms() {
		return showHms;
	}

	public void setShowHms(String showHms) {
		this.showHms = showHms;
	}

	public String getQueryStart() {
		return queryStart;
	}

	public void setQueryStart(String queryStart) {
		this.queryStart = queryStart;
	}

	public String getQueryEnd() {
		return queryEnd;
	}

	public void setQueryEnd(String queryEnd) {
		this.queryEnd = queryEnd;
	}

	public String getQueryStartNoContain() {
		return queryStartNoContain;
	}

	public void setQueryStartNoContain(String queryStartNoContain) {
		this.queryStartNoContain = queryStartNoContain;
	}

	public String getQueryEndNoContain() {
		return queryEndNoContain;
	}

	public void setQueryEndNoContain(String queryEndNoContain) {
		this.queryEndNoContain = queryEndNoContain;
	}

	public String getQueryLikeLeft() {
		return queryLikeLeft;
	}

	public void setQueryLikeLeft(String queryLikeLeft) {
		this.queryLikeLeft = queryLikeLeft;
	}

	public String getQueryLikeRight() {
		return queryLikeRight;
	}

	public void setQueryLikeRight(String queryLikeRight) {
		this.queryLikeRight = queryLikeRight;
	}

	public String getQueryLike() {
		return queryLike;
	}

	public void setQueryLike(String queryLike) {
		this.queryLike = queryLike;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
