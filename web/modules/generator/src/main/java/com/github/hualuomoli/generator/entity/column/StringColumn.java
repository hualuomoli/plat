package com.github.hualuomoli.generator.entity.column;

import com.github.hualuomoli.generator.entity.Column;

/**
 * column is String
 * @author hualuomoli
 *
 */
public class StringColumn extends Column {

	private static final long serialVersionUID = -1911456962749692510L;

	private Integer maxLength;

	private String queryLikeLeft; // query like left. such as name like '%queryLikeLeft'
	private String queryLikeRight; // query like right. such as name like 'queryLikeRight%'
	private String queryLike; // query like both left and right. such as name like '%queryLike%'

	public StringColumn() {
	}

	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
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

}
