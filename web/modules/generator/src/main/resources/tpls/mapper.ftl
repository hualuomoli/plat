package ${params.package}.basic.mapper;

import java.util.List;
<#-- date -->
<#list columnList as column>
<#if column.javaType == 'Date' && column.pk == params.YES>
import java.util.Date;
<#break>
</#if>
</#list>

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import ${params.package}.basic.entity.${javaName};

@Repository
public interface I${javaName}Mapper {

	<#-- get by all primary keys -->
	<#if pkSize gt 0>
	
	// get by primary key
	${javaName} get(${javaName} ${javaName?uncap_first});
	
	// get by primary key
	${javaName} get(
		<#list columnList as column>
		<#if column.pk == params.YES>
		@Param(value="${column.javaName}") ${column.javaType} ${column.javaName}<#if column.position lt pkSize>,</#if>
		</#if>
		</#list>
		);
	</#if>
	
	<#-- get by one primary key -->
	<#if pkSize gt 1>
	<#list columnList as column>
	<#if column.pk == params.YES >
	// get by ${column.javaName}
	${javaName} get${column.javaName?cap_first}(@Param(value="${column.javaName}") ${column.javaType} ${column.javaName});
	</#if>
	</#list>
	</#if>
	
	<#-- insert -->
	// insert
	int insert(${javaName} ${javaName?uncap_first});
	
	<#-- batch insert -->
	// batch insert
	int batchInsert(@Param(value="list")List<${javaName}> list);
	
	<#-- update by primary key for only one primary key -->
	<#if pkSize == 1>
	// update by primary key
	int update(${javaName} ${javaName?uncap_first});
	</#if>
	
	<#-- delete by all primary keys -->
	<#if pkSize gt 0>
	// delete by primary key
	int delete(${javaName} ${javaName?uncap_first});
	
	// delete by primary key
	int delete(
		<#list columnList as column>
		<#if column.pk == params.YES>
		@Param(value="${column.javaName}") ${column.javaType} ${column.javaName}<#if column.position lt pkSize>,</#if>
		</#if>
		</#list>
		);
	</#if>
	
	<#if pkSize gt 1>
	<#list columnList as column>
	<#if column.pk == params.YES>
	// delete by ${column.javaName}
	int deleteBy${column.javaName?cap_first}(@Param(value="${column.javaName}")${column.javaType} ${column.javaName});
	</#if>
	</#list>
	</#if>
	
	<#-- query data list -->
	// find data list
	List<${javaName}> findList(${javaName} ${javaName?uncap_first});

}
