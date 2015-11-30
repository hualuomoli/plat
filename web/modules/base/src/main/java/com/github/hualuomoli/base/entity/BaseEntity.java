package com.github.hualuomoli.base.entity;

import java.util.Date;

import com.github.hualuomoli.base.Pagination;
import com.github.hualuomoli.base.Paginator;

/**
 * base entity implements Paginator and define common attribute
 * @author hualuomoli
 *
 */
public abstract class BaseEntity implements Paginator {

	private Pagination pagination; // pagination

	private String createBy; // data create by which user
	private Date createDate; // data create date
	private String updateBy; // data update by which user
	private Date updateDate; // data update date
	private Integer status; // data's status
	private String remark; // data remark

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
