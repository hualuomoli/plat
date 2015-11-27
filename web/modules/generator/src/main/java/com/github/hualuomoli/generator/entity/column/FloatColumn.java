package com.github.hualuomoli.generator.entity.column;

import com.github.hualuomoli.generator.entity.Column;

/**
 * column is float
 * @author hualuomoli
 *
 */
public class FloatColumn extends Column {

	private static final long serialVersionUID = -8303065060221314281L;

	private Integer dataPrecision;
	private Integer dataScale;

	private Boolean showStr; // string show float data such as 1.20

	private Boolean queryStart; // query start contain this value. such as salary >= queryStart
	private Boolean queryEnd; // query end contain this value. such as salary <= queryEnd
	private Boolean queryStartNoContain; // query start no contain this value. such as salary > queryStartNoContain
	private Boolean queryEndNoContain; // query end no contain this value. such as salary < queryEndNoContain

	public FloatColumn() {
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

	public Boolean getShowStr() {
		return showStr;
	}

	public void setShowStr(Boolean showStr) {
		this.showStr = showStr;
	}

	public Boolean getQueryStart() {
		return queryStart;
	}

	public void setQueryStart(Boolean queryStart) {
		this.queryStart = queryStart;
	}

	public Boolean getQueryEnd() {
		return queryEnd;
	}

	public void setQueryEnd(Boolean queryEnd) {
		this.queryEnd = queryEnd;
	}

	public Boolean getQueryStartNoContain() {
		return queryStartNoContain;
	}

	public void setQueryStartNoContain(Boolean queryStartNoContain) {
		this.queryStartNoContain = queryStartNoContain;
	}

	public Boolean getQueryEndNoContain() {
		return queryEndNoContain;
	}

	public void setQueryEndNoContain(Boolean queryEndNoContain) {
		this.queryEndNoContain = queryEndNoContain;
	}

}
