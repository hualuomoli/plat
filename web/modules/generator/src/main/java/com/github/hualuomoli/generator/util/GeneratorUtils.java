package com.github.hualuomoli.generator.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.github.hualuomoli.common.util.TemplateUtils;
import com.github.hualuomoli.generator.entity.GenConfig;
import com.github.hualuomoli.generator.entity.Param;
import com.github.hualuomoli.generator.entity.Table;

/**
 * generator util
 * @author hualuomoli
 *
 */
public class GeneratorUtils {

	/**
	 * parse table name to java such as parse gen_demo to GenDemo
	 * @param tableName table's  name such as gen_demo
	 * @return table's java name such as userName
	 */
	public static String parseTableName(String tableName) {
		if (StringUtils.isBlank(tableName)) {
			return StringUtils.EMPTY;
		}
		tableName = tableName.trim().toLowerCase();
		String[] array = tableName.split("[_]");
		StringBuilder buffer = new StringBuilder();
		String temp;
		for (int i = 0; i < array.length; i++) {
			temp = array[i];
			temp = temp.substring(0, 1).toUpperCase() + temp.substring(1);
			buffer.append(temp);
		}
		return buffer.toString();
	}

	/**
	* parse column name to java such as parse user_name to userName
	* @param columnName column's name such as user_name
	* @return column's java name such as userName
	*/
	public static String parseColumnName(String columnName) {
		if (StringUtils.isBlank(columnName)) {
			return StringUtils.EMPTY;
		}
		columnName = columnName.trim().toLowerCase();
		if (columnName.startsWith("[_]")) { // column start with _.such as _id
			throw new RuntimeException("Generator con't stand by column start with _.");
		}
		String[] array = columnName.split("[_]");
		if (array.length == 1) { // column's name don't has _ such as address
			return columnName;
		}
		StringBuilder buffer = new StringBuilder(); // column's name has _ such as user_name
		buffer.append(array[0]); // append string user
		String temp;
		for (int i = 1; i < array.length; i++) {
			temp = array[i];
			temp = temp.substring(0, 1).toUpperCase() + temp.substring(1);
			buffer.append(temp);
		}
		return buffer.toString();
	}

	/** parse comments */
	public static String parseComment(String comments) {
		if (StringUtils.isBlank(comments)) {
			return StringUtils.EMPTY;
		}
		// replace Enter to four blank
		String regex = "\\r";
		return comments.replaceAll(regex, "    ");
	}

	// create files
	public static void createFiles(Table table) throws Exception {

		String packageFolder = table.getParams().get(Param.PACKAGE).replaceAll("[.]", "/");
		String tplPath = GeneratorUtils.class.getClassLoader().getResource("tpls").getPath();
		String projectPath = GenConfig.getProjectPath();

		// create xml
		GeneratorUtils.createXmlFile(table, tplPath, packageFolder, projectPath);
		// create entity
		GeneratorUtils.createEntityFile(table, tplPath, packageFolder, projectPath);
		// create mapper
		GeneratorUtils.createMapperFile(table, tplPath, packageFolder, projectPath);

	}

	// create xml file
	public static void createXmlFile(Table table, String tplPath, String packageFolder, String projectPath) throws Exception {
		String data = TemplateUtils.getTemplateData(tplPath, "xml.ftl", table);
		FileUtils.write(new File(projectPath, "src/main/resources/mappers/" + table.getJavaName() + "Mapper.xml"), data);
	}

	// create entity file 
	public static void createEntityFile(Table table, String tplPath, String packageFolder, String projectPath) throws Exception {
		String data = TemplateUtils.getTemplateData(tplPath, "entity-basic.ftl", table);
		FileUtils.write(new File(projectPath, "src/main/java/" + packageFolder + "/basic/entity/" + table.getJavaName() + "Basic.java"), data);

		data = TemplateUtils.getTemplateData(tplPath, "entity.ftl", table);
		FileUtils.write(new File(projectPath, "src/main/java/" + packageFolder + "/basic/entity/" + table.getJavaName() + ".java"), data);
	}

	// create mapper
	public static void createMapperFile(Table table, String tplPath, String packageFolder, String projectPath) throws Exception {
		String data = TemplateUtils.getTemplateData(tplPath, "mapper.ftl", table);
		FileUtils.write(new File(projectPath, "src/main/java/" + packageFolder + "/basic/mapper/I" + table.getJavaName() + "Mapper.java"), data);
	}

}
