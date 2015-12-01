package com.github.hualuomoli.generator.entity;

import java.util.HashMap;

import com.github.hualuomoli.generator.db.TrueFalse;

/**
 * constant parameter
 * @author hualuomoli
 *
 */
public class Param extends HashMap<String, String> {

	private static final long serialVersionUID = 8192081303829420637L;

	public static final String PACKAGE = "package";

	public static final String BATCH_INSERT_START = "BIS";
	public static final String BATCH_INSERT_END = "BIE";

	public static final String GREATER_EQUALS = "GE";
	public static final String LESSER_EQUALS = "LE";
	public static final String GREATER = "GT";
	public static final String LESSER = "LT";

	public static final String YES = "YES"; // use in ftl

	private static final String OBJECT = "GENERATOR";
	private static Param datas;

	public static final Param getParams() {
		synchronized (OBJECT) {
			if (datas == null) {

				datas = new Param();

				datas.put(PACKAGE, GenConfig.getPackage());

				// batch insert start,end
				datas.put(BATCH_INSERT_START, GenConfig.getBatchInsertStart());
				datas.put(BATCH_INSERT_END, GenConfig.getBatchInsertEnd());

				// compare
				datas.put(GREATER_EQUALS, "<![CDATA[ >= ]]>");
				datas.put(LESSER_EQUALS, "<![CDATA[ <= ]]>");
				datas.put(GREATER, "<![CDATA[ > ]]>");
				datas.put(LESSER, "<![CDATA[ < ]]>");

				datas.put(YES, TrueFalse.TRUE);
			}
		}
		return datas;
	}

}
