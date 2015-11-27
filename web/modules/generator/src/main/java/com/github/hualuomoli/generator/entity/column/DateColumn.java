package com.github.hualuomoli.generator.entity.column;

import com.github.hualuomoli.generator.entity.Column;

/**
 * column is date
 * @author hualuomoli
 *
 */
public class DateColumn extends Column {

	private static final long serialVersionUID = -4149137531042383455L;

	// show style
	private Boolean showSlashYmd; // yyyy/MM/dd such as 2015/10/01
	private Boolean showSlashHms; // HH:mm:ss such as 13:05:29
	private Boolean showSlashYmdHms; // yyyy/MM/dd HH:mm:ss such as 2015/10/01 13:05:29

	private Boolean showBarYmd; // yyyy-MM-dd such as 2015-10-01
	private Boolean showBarHms; // HH:mm:ss such as 13:05:29
	private Boolean showBarYmdHms; // yyyy-MM-dd HH:mm:ss such as 2015-10-01 13:05:29

	private Boolean showYmd; // yyyyMMdd such as 20151001
	private Boolean showHms; // HHmmss such as 130529
	private Boolean showYmdHms; // yyyyMMddHHmmss such as 20151001130529

	// query
	private Boolean queryStart; // query start contain this time. such as time >= queryStart
	private Boolean queryEnd; // query end contain this time. such as time <= queryEnd
	private Boolean queryStartNoContain; // query start no contain this time. such as time > queryStartNoContain
	private Boolean queryEndNoContain; // query end no contain this time. such as time < queryEndNoContain

	public DateColumn() {
	}

	public Boolean getShowSlashYmd() {
		return showSlashYmd;
	}

	public void setShowSlashYmd(Boolean showSlashYmd) {
		this.showSlashYmd = showSlashYmd;
	}

	public Boolean getShowSlashHms() {
		return showSlashHms;
	}

	public void setShowSlashHms(Boolean showSlashHms) {
		this.showSlashHms = showSlashHms;
	}

	public Boolean getShowSlashYmdHms() {
		return showSlashYmdHms;
	}

	public void setShowSlashYmdHms(Boolean showSlashYmdHms) {
		this.showSlashYmdHms = showSlashYmdHms;
	}

	public Boolean getShowBarYmd() {
		return showBarYmd;
	}

	public void setShowBarYmd(Boolean showBarYmd) {
		this.showBarYmd = showBarYmd;
	}

	public Boolean getShowBarHms() {
		return showBarHms;
	}

	public void setShowBarHms(Boolean showBarHms) {
		this.showBarHms = showBarHms;
	}

	public Boolean getShowBarYmdHms() {
		return showBarYmdHms;
	}

	public void setShowBarYmdHms(Boolean showBarYmdHms) {
		this.showBarYmdHms = showBarYmdHms;
	}

	public Boolean getShowYmd() {
		return showYmd;
	}

	public void setShowYmd(Boolean showYmd) {
		this.showYmd = showYmd;
	}

	public Boolean getShowHms() {
		return showHms;
	}

	public void setShowHms(Boolean showHms) {
		this.showHms = showHms;
	}

	public Boolean getShowYmdHms() {
		return showYmdHms;
	}

	public void setShowYmdHms(Boolean showYmdHms) {
		this.showYmdHms = showYmdHms;
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
