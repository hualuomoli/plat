package com.github.hualuomoli.generator.db;

import java.util.Set;

import com.google.common.collect.Sets;

/**
 * column database type 
 * @author hualuomoli
 *
 */
public interface DataType {

	public static final Set<String> STRING = Sets.newHashSet(new String[] { "varchar", "varchar2", "char", "text", "longtext" });
	public static final Set<String> INTEGER = Sets.newHashSet(new String[] { "int", "integer" });
	public static final Set<String> LONG = Sets.newHashSet(new String[] { "bigint" });
	public static final Set<String> FLOAT = Sets.newHashSet(new String[] { "float" });
	public static final Set<String> DOUBLE = Sets.newHashSet(new String[] { "double" });
	public static final Set<String> DATE = Sets.newHashSet(new String[] { "date", "datetime" });

}
