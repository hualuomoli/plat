package com.github.hualuomoli.generator.util;

import org.apache.commons.lang3.StringUtils;

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

}
