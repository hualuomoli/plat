<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${params.package}.base.mapper.I${javaName}Mapper">
	
	<#-- show columns -->
	<sql id="showColumns">
		<#list columnList as column>
		t.${column.columnName} AS "${column.javaName}"<#if column.position lt columnList?size>,</#if>
		</#list>
	</sql>
	
	<#-- add query -->
	<sql id="queryColumns">
		<#-- equals -->
		<#list columnList as column><#-- level1 -->
		<#if column.javaType == "String"><#-- level2 -->
		<if test="${column.javaName} != null and ${column.javaName} != ''">
			and t.${column.columnName} = ${r"#{"}${column.javaName}${r"}"}
		</if>
		<#else><#-- level2 -->
		<if test="${column.javaName} != null">
			and t.${column.columnName} = ${r"#{"}${column.javaName}${r"}"}
		</if>
		</#if><#-- ./level2 -->
		</#list><#-- ./level1 -->
		<#-- query -->
		<#list columnList as column><#-- level1 -->
		<#if column.javaType == "String"><#-- level2 -->
		<#if column.queryLikeLeft == params.YES><#-- level3 -->
		<if test="${column.javaName}LikeLeft != null and ${column.javaName}LikeLeft != ''">
			and t.${column.columnName} like ${r"#{"}${column.javaName}LikeLeft${r"}"}
		</if>
		</#if><#-- ./level3 -->
		<#if column.queryLikeRight == params.YES><#-- level3 -->
		<if test="${column.javaName}LikeRight != null and ${column.javaName}LikeRight != ''">
			and t.${column.columnName} like ${r"#{"}${column.javaName}LikeRight${r"}"}
		</if>
		</#if><#-- ./level3 -->
		<#if column.queryLike == params.YES><#-- level3 -->
		<if test="${column.javaName}Like != null and ${column.javaName}Like != ''">
			and t.${column.columnName} like ${r"#{"}${column.javaName}Like${r"}"}
		</if>
		</#if><#-- ./level3 -->
		</#if><#-- ./level2 -->
		<#if column.javaType == "Date" || column.javaType == "Integer" || column.javaType == "Long" || column.javaType == "Float" || column.javaType == "Double"><#-- level2 -->
		<#if column.queryStart == params.YES><#-- level3 -->
		<if test="${column.javaName}Start != null">
			and t.${column.columnName} ${params.GE} ${r"#{"}${column.javaName}Start${r"}"}
		</if>
		</#if><#-- ./level3 -->
		<#if column.queryEnd == params.YES><#-- level3 -->
		<if test="${column.javaName}End != null">
			and t.${column.columnName} ${params.LE} ${r"#{"}${column.javaName}End${r"}"}
		</if>
		</#if><#-- ./level3 -->
		<#if column.queryStartNoContain == params.YES><#-- level3 -->
		<if test="${column.javaName}StartNo != null">
			and t.${column.columnName} ${params.GT} ${r"#{"}${column.javaName}StartNo${r"}"}
		</if>
		</#if><#-- ./level3 -->
		<#if column.queryEndNoContain == params.YES><#-- level3 -->
		<if test="${column.javaName}EndNo != null">
			and t.${column.columnName} ${params.LT} ${r"#{"}${column.javaName}EndNo${r"}"}
		</if>
		</#if><#-- ./level3 -->
		</#if><#-- ./level2 -->
		</#list><#-- ./level1 -->
		
	</sql>
	
	<#-- get by all primary keys -->
	<#if pkSize gt 0>
	<select id="get" resultType="${params.package}.base.entity.${javaName}">
		select
		<include refid="showColumns"/>
		from ${tableName} t
		<where>
		<#list columnList as column>
			<#if column.pk == params.YES >
			and t.${column.columnName} = ${r"#{"}${column.javaName}${r"}"}
			</#if>
		</#list>
		</where>
	</select>
	</#if>
	
	<#-- get by one primary key -->
	<#if pkSize gt 1>
	<#list columnList as column>
	<#if column.pk == params.YES >
	<select id="getBy${column.javaName?cap_first}" resultType="${params.package}.base.entity.${javaName}">
		select
		<include refid="showColumns"/>
		from ${tableName} t
		where t.${column.columnName} = ${r"#{"}${column.javaName}${r"}"}
	</select>
	</#if>
	</#list>
	</#if>
	
	<#-- insert -->
	<insert id="insert">
		insert into ${tableName}(
		<#list columnList as column>
			<#if column.dataDefault == params.YES><#-- has default value. null data don't in insert statement -->
			<if test="${column.javaName} != null">
			${column.columnName}<#if column.position lt columnList?size>,</#if>
			</if>
			<#else>
			${column.columnName}<#if column.position lt columnList?size>,</#if>
			</#if>
		</#list>
		)values(
		<#list columnList as column>
			<#if column.dataDefault == params.YES><#-- has default value. null data don't in insert statement -->
			<if test="${column.javaName} != null">
			${r"#{"}${column.javaName}${r"}"}<#if column.position lt columnList?size>,</#if>
			</if>
			<#else>
			${r"#{"}${column.javaName}${r"}"}<#if column.position lt columnList?size>,</#if>
			</#if>
		</#list>
		)
	</insert>
	
	<#-- batch insert -->
	<insert id="batchInsert">
		insert into ${tableName}(
		<#list columnList as column>
			${column.columnName}<#if column.position lt columnList?size>,</#if>
		</#list>
		)
		<foreach collection="list" item="t" separator="union all">
		<#-- batch insert start string such as select -->
		${params.BIS}
		<#list columnList as column>
			${r"#{"}t.${column.javaName}, jdbcType=${column.dataType}${r"}"}
		</#list>
		<#-- batch insert end string such as from dual for oracle -->
		${params.BIE}
		</foreach>
	</insert>
	
	
	<#-- update by primary key for only one primary key -->
	<#if pkSize == 1>
	<update id="update">
		update ${tableName}
		<set> 
			<#list columnList as column><#-- level1 -->
			<#if column.javaType == "String"><#-- level2 -->
			<if test="${column.javaName} != null and ${column.javaName} != ''">
				${column.columnName} = ${r"#{"}${column.javaName}${r"}"},
			</if>
			<#else><#-- level2 -->
			<if test="${column.javaName} != null">
				${column.columnName} = ${r"#{"}${column.javaName}${r"}"},
			</if>
			</#if><#-- ./level2 -->
			</#list><#-- ./level1 -->
		</set>
		<where>
		<#list columnList as column>
			<#if column.pk == params.YES >
			and ${column.columnName} = ${r"#{"}${column.javaName}${r"}"}
			</#if>
		</#list>
		</where>
	</update>
	</#if>
	
	<#-- delete by all primary keys -->
	<#if pkSize gt 0>
	<delete id="delete">
		delete from ${tableName}
		<where>
		<#list columnList as column>
			<#if column.pk == params.YES >
			and ${column.columnName} = ${r"#{"}${column.javaName}${r"}"}
			</#if>
		</#list>
		</where>
	</delete>
	</#if>
	
	<#if pkSize gt 1>
	<#list columnList as column>
	<#if column.pk == params.YES>
	<delete id="deleteBy${column.javaName?cap_first}">
		delete from ${tableName}
		where ${column.columnName} = ${r"#{"}${column.javaName}${r"}"}
	</delete>
	</#if>
	</#list>
	</#if>
	
	<#-- query data list -->
	<select id="findList" resultType="${params.package}.base.entity.${javaName}">
		select
		<include refid="showColumns"/>
		from ${tableName} t
		<where>
		<include refid="queryColumns"/>
		</where>
		<if test="page != null and page.orderBy != null and page.orderBy != ''">
			order by ${r"#{"}page.orderBy${r"}"}
		</if>
	</select>
	
</mapper>