package com.github.hualuomoli.generator.entity.column;

import com.github.hualuomoli.generator.entity.Column;

/**
 * column is integer
 * @author hualuomoli
 *
 */
public class IntegerColumn extends Column {

	private static final long serialVersionUID = 1180252005845413924L;

	private Boolean queryStart; // query start contain this value. such as salary >= queryStart
	private Boolean queryEnd; // query end contain this value. such as salary <= queryEnd
	private Boolean queryStartNoContain; // query start no contain this value. such as salary > queryStartNoContain
	private Boolean queryEndNoContain; // query end no contain this value. such as salary < queryEndNoContain

	public IntegerColumn() {
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
