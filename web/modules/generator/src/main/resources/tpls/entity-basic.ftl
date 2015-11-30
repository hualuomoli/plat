package ${params.package}.basic.entity;
<#-- date -->
<#list columnList as column>
<#if column.javaType == 'Date'>

import java.util.Date;
<#break>
</#if>
</#list>

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.github.hualuomoli.base.entity.BaseEntity;
import com.github.hualuomoli.commons.util.DateUtils;
import com.github.hualuomoli.commons.util.NumberUtils;

/**
 * ${tableName} basic entity
 * ${comments}
 * @author 
 */
class ${javaName}Basic extends BaseEntity {
	
	<#-- column -->
	<#list columnList as column>
	private ${column.javaType} ${column.javaName}; /** ${column.comments} */
	</#list>
	
	<#-- query -->
	<#list columnList as column><#-- level1 -->
	<#if column.javaType == "String"><#-- level2 -->
	<#if column.queryLikeLeft == params.YES><#-- level3 -->
	private ${column.javaType} ${column.javaName}LikeLeft; /** ${column.comments} left like. such as name like '%admin' */
	</#if><#-- ./level3 -->
	<#if column.queryLikeRight == params.YES><#-- level3 -->
	private ${column.javaType} ${column.javaName}LikeRight; /** ${column.comments} right like. such as name like 'admin%' */
	</#if><#-- ./level3 -->
	<#if column.queryLike == params.YES><#-- level3 -->
	private ${column.javaType} ${column.javaName}Like; /** ${column.comments} both like. such as name like '%admin%' */
	</#if><#-- ./level3 -->
	</#if><#-- ./level2 -->
	<#if column.javaType == "Integer" || column.javaType == "Long" || column.javaType == "Float" || column.javaType == "Double"><#-- level2 -->
	<#if column.queryStart == params.YES><#-- level3 -->
	private ${column.javaType} ${column.javaName}Start; /** ${column.comments} greater than. such as salary >= 500.36 */
	</#if><#-- ./level3 -->
	<#if column.queryEnd == params.YES><#-- level3 -->
	private ${column.javaType} ${column.javaName}End; /** ${column.comments} greater than. such as salary <= 500.36 */
	</#if><#-- ./level3 -->
	<#if column.queryStartNoContain == params.YES><#-- level3 -->
	private ${column.javaType} ${column.javaName}StartNo; /** ${column.comments} greater than. such as salary > 500.36 */
	</#if><#-- ./level3 -->
	<#if column.queryEndNoContain == params.YES><#-- level3 -->
	private ${column.javaType} ${column.javaName}EndNo; /** ${column.comments} greater than. such as salary < 500.36 */
	</#if><#-- ./level3 -->
	</#if><#-- ./level2 -->
	<#if column.javaType == "Date"><#-- level2 -->
	<#if column.queryStart == params.YES><#-- level3 -->
	private ${column.javaType} ${column.javaName}Start; /** ${column.comments} greater than. such as createDate >= 2015-01-15 12:36:28 */
	</#if><#-- ./level3 -->
	<#if column.queryEnd == params.YES><#-- level3 -->
	private ${column.javaType} ${column.javaName}End; /** ${column.comments} greater than. such as createDate <= 2015-01-15 12:36:28 */
	</#if><#-- ./level3 -->
	<#if column.queryStartNoContain == params.YES><#-- level3 -->
	private ${column.javaType} ${column.javaName}StartNo; /** ${column.comments} greater than. such as createDate > 2015-01-15 12:36:28 */
	</#if><#-- ./level3 -->
	<#if column.queryEndNoContain == params.YES><#-- level3 -->
	private ${column.javaType} ${column.javaName}EndNo; /** ${column.comments} greater than. such as createDate < 2015-01-15 12:36:28 */
	</#if><#-- ./level3 -->
	</#if><#-- ./level2 -->
	</#list><#-- ./level1 -->
	
	<#-- show -->
	<#list columnList as column>
	<#if column.javaType == "Double" || column.javaType == "Float">
	<#if column.dataScale?? && column.dataScale gt 0 && column.showStr == params.YES>
	private String ${column.javaName}ShowStr; /** ${column.comments} string show which use scale is ${column.dataScale} */
	</#if>
	</#if>
	<#if column.javaType == "Date">
	<#if column.showSlashYmd == params.YES>
	private String ${column.javaName}ShowSlashYmd; /** ${column.comments} show string date. such as 2015/10/01 */
	</#if>
	<#if column.showSlashYmdHms == params.YES>
	private String ${column.javaName}ShowSlashYmdHms; /** ${column.comments} show string date. such as 2015/10/01 13:05:29 */
	</#if>
	<#if column.showBarYmd == params.YES>
	private String ${column.javaName}ShowBarYmd; /** ${column.comments} show string date. such as 2015-10-01 */
	</#if>
	<#if column.showBarYmdHms == params.YES>
	private String ${column.javaName}ShowBarYmdHms; /** ${column.comments} show string date. such as 2015-10-01 13:05:29 */
	</#if>
	<#if column.showYmd == params.YES>
	private String ${column.javaName}ShowYmd; /** ${column.comments} show string date. such as 20151001 */
	</#if>
	<#if column.showYmdHms == params.YES>
	private String ${column.javaName}ShowYmdHms; /** ${column.comments} show string date. such as 20151001130529 */
	</#if>
	<#if column.showColonHms == params.YES>
	private String ${column.javaName}ShowColonHms; /** ${column.comments} show string date. such as 13:05:29 */
	</#if>
	<#if column.showHms == params.YES>
	private String ${column.javaName}ShowHms; /** ${column.comments} show string date. such as 130529 */
	</#if>
	</#if>
	</#list>
	
	public ${javaName}Basic() {
	}
	
	<#-- getter and setter -->
	<#list columnList as column>
	public ${column.javaType} get${column.javaName?cap_first}(){
		return ${column.javaName};
	}
	
	public void set${column.javaName?cap_first}(${column.javaType} ${column.javaName}){
		this.${column.javaName} = ${column.javaName};
	}
	</#list>
	
	<#-- query -->
	<#list columnList as column><#-- level1 -->
	<#if column.javaType == "String"><#-- level2 -->
	<#if column.queryLikeLeft == params.YES><#-- level3 -->
	public ${column.javaType} get${column.javaName?cap_first}LikeLeft(){
		return ${column.javaName}LikeLeft;
	}
	public void set${column.javaName?cap_first}LikeLeft(${column.javaType} ${column.javaName}LikeLeft){
		if(StringUtils.isBlank(${column.javaName}LikeLeft)){
			return;
		}
		${column.javaName}LikeLeft = ${column.javaName}LikeLeft.trim();
		if(${column.javaName}LikeLeft.startsWith("%")){
			this.${column.javaName}LikeLeft = ${column.javaName}LikeLeft;
		}else{
			this.${column.javaName}LikeLeft = "%" + ${column.javaName}LikeLeft;
		}
	}
	</#if><#-- ./level3 -->
	<#if column.queryLikeRight == params.YES><#-- level3 -->
	public ${column.javaType} get${column.javaName?cap_first}LikeRight(){
		return ${column.javaName}LikeRight;
	}
	public void set${column.javaName?cap_first}LikeRight(${column.javaType} ${column.javaName}LikeRight){
		if(StringUtils.isBlank(${column.javaName}LikeRight)){
			return;
		}
		${column.javaName}LikeRight = ${column.javaName}LikeRight.trim();
		if(${column.javaName}LikeRight.endsWith("%")){
			this.${column.javaName}LikeRight = ${column.javaName}LikeRight;
		}else{
			this.${column.javaName}LikeRight = ${column.javaName}LikeRight + "%";
		}
	}
	</#if><#-- ./level3 -->
	<#if column.queryLike == params.YES><#-- level3 -->
	public ${column.javaType} get${column.javaName?cap_first}Like(){
		return ${column.javaName}Like;
	}
	public void set${column.javaName?cap_first}Like(${column.javaType} ${column.javaName}Like){
		if(StringUtils.isBlank(${column.javaName}Like)){
			return;
		}
		${column.javaName}Like = ${column.javaName}Like.trim();
		if(${column.javaName}Like.startsWith("%") && !${column.javaName}Like.endsWith("%")){
			this.${column.javaName}Like = ${column.javaName}Like + "%";
		}else if(!${column.javaName}Like.startsWith("%") && ${column.javaName}Like.endsWith("%")){
			this.${column.javaName}Like = "%" + ${column.javaName}Like;
		}else if(${column.javaName}Like.startsWith("%") && ${column.javaName}Like.endsWith("%")){
			this.${column.javaName}Like = ${column.javaName}Like;
		}else{
			this.${column.javaName}Like = "%" + ${column.javaName}Like + "%";
		}
	}
	</#if><#-- ./level3 -->
	</#if><#-- ./level2 -->
	<#if column.javaType == "Date" || column.javaType == "Integer" || column.javaType == "Long" || column.javaType == "Float" || column.javaType == "Double"><#-- level2 -->
	<#if column.queryStart == params.YES><#-- level3 -->
	public ${column.javaType} get${column.javaName?cap_first}Start(){
		return ${column.javaName}Start;
	}
	public void set${column.javaName?cap_first}Start(${column.javaType} ${column.javaName}Start){
		this.${column.javaName}Start = ${column.javaName}Start;
	}
	</#if><#-- ./level3 -->
	<#if column.queryEnd == params.YES><#-- level3 -->
	public ${column.javaType} get${column.javaName?cap_first}End(){
		return ${column.javaName}End;
	}
	public void set${column.javaName?cap_first}End(${column.javaType} ${column.javaName}End){
		this.${column.javaName}End = ${column.javaName}End;
	}
	</#if><#-- ./level3 -->
	<#if column.queryStartNoContain == params.YES><#-- level3 -->
	public ${column.javaType} get${column.javaName?cap_first}StartNo(){
		return ${column.javaName}StartNo;
	}
	public void set${column.javaName?cap_first}StartNo(${column.javaType} ${column.javaName}StartNo){
		this.${column.javaName}StartNo = ${column.javaName}StartNo;
	}
	</#if><#-- ./level3 -->
	<#if column.queryEndNoContain == params.YES><#-- level3 -->
	public ${column.javaType} get${column.javaName?cap_first}EndNo(){
		return ${column.javaName}EndNo;
	}
	public void set${column.javaName?cap_first}EndNo(${column.javaType} ${column.javaName}EndNo){
		this.${column.javaName}EndNo = ${column.javaName}EndNo;
	}
	</#if><#-- ./level3 -->
	</#if><#-- ./level2 -->
	</#list><#-- ./level1 -->
	
	<#-- show -->
	<#list columnList as column>
	<#if column.javaType == "Float">
	<#if column.dataScale?? && column.dataScale gt 0 && column.showStr == params.YES>
	public String get${column.javaName?cap_first}ShowStr(){
		if(StringUtils.isBlank(${column.javaName}ShowStr)){
			${column.javaName}ShowStr = NumberUtils.parseFloat(${column.javaName}, ${column.dataScale});
		}
		return ${column.javaName}ShowStr;
	}
	</#if>
	</#if>
	<#if column.javaType == "Double">
	<#if column.dataScale?? && column.dataScale gt 0 && column.showStr == params.YES>
	public String get${column.javaName?cap_first}ShowStr(){
		if(StringUtils.isBlank(${column.javaName}ShowStr)){
			${column.javaName}ShowStr = NumberUtils.parseDouble(${column.javaName}, ${column.dataScale});
		}
		return ${column.javaName}ShowStr;
	}
	</#if>
	</#if>
	<#if column.javaType == "Date">
	<#if column.showSlashYmd == params.YES>
	public String get${column.javaName?cap_first}ShowSlashYmd(){
		if(StringUtils.isBlank(${column.javaName}ShowSlashYmd)){
			${column.javaName}ShowSlashYmd = DateUtils.sdfSlashYmd.format(${column.javaName});
		}
		return ${column.javaName}ShowSlashYmd;
	}
	</#if>
	<#if column.showSlashYmdHms == params.YES>
	public String get${column.javaName?cap_first}showSlashYmdHms(){
		if(StringUtils.isBlank(${column.javaName}ShowSlashYmdHms)){
			${column.javaName}ShowSlashYmdHms = DateUtils.sdfSlashYmdHms.format(${column.javaName});
		}
		return ${column.javaName}ShowSlashYmdHms;
	}
	</#if>
	<#if column.showBarYmd == params.YES>
	public String get${column.javaName?cap_first}showBarYmd(){
		if(StringUtils.isBlank(${column.javaName}ShowBarYmd)){
			${column.javaName}ShowBarYmd = DateUtils.sdfBarYmd.format(${column.javaName});
		}
		return ${column.javaName}ShowBarYmd;
	}
	</#if>
	<#if column.showBarYmdHms == params.YES>
	public String get${column.javaName?cap_first}showBarYmdHms(){
		if(StringUtils.isBlank(${column.javaName}ShowBarYmdHms)){
			${column.javaName}ShowBarYmdHms = DateUtils.sdfBarYmdHms.format(${column.javaName});
		}
		return ${column.javaName}ShowBarYmdHms;
	}
	</#if>
	<#if column.showYmd == params.YES>
	public String get${column.javaName?cap_first}showYmd(){
		if(StringUtils.isBlank(${column.javaName}ShowYmd)){
			${column.javaName}ShowYmd = DateUtils.sdfYmd.format(${column.javaName});
		}
		return ${column.javaName}ShowYmd;
	}
	</#if>
	<#if column.showYmdHms == params.YES>
	public String get${column.javaName?cap_first}showYmdHms(){
		if(StringUtils.isBlank(${column.javaName}ShowYmdHms)){
			${column.javaName}ShowYmdHms = DateUtils.sdfYmdHms.format(${column.javaName});
		}
		return ${column.javaName}ShowYmdHms;
	}
	</#if>
	<#if column.showColonHms == params.YES>
	public String get${column.javaName?cap_first}showColonHms(){
		if(StringUtils.isBlank(${column.javaName}ShowColonHms)){
			${column.javaName}ShowColonHms = DateUtils.sdfColonHms.format(${column.javaName});
		}
		return ${column.javaName}ShowColonHms;
	}
	</#if>
	<#if column.showHms == params.YES>
	public String get${column.javaName?cap_first}showHms(){
		if(StringUtils.isBlank(${column.javaName}ShowHms)){
			${column.javaName}ShowHms = DateUtils.sdfHms.format(${column.javaName});
		}
		return ${column.javaName}ShowHms;
	}
	</#if>
	</#if>
	</#list>
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}