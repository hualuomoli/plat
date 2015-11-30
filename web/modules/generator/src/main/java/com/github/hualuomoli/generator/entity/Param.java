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

	public static final String BIS = "BIS";
	public static final String BIE = "BIE";

	public static final String GE = "GE";
	public static final String LE = "LE";
	public static final String GT = "GT";
	public static final String LT = "LT";

	public static final String YES = "YES";

	private static final String OBJECT = "GENERATOR";
	private static Param datas;

	public static final Param getParams() {
		synchronized (OBJECT) {
			if (datas == null) {

				datas = new Param();

				datas.put(PACKAGE, "com.github.hualuomoli");

				// batch insert start,end
				datas.put(BIS, "select");
				datas.put(BIE, "");

				// compare
				datas.put(GE, "<![CDATA[ >= ]]>");
				datas.put(LE, "<![CDATA[ <= ]]>");
				datas.put(GT, "<![CDATA[ > ]]>");
				datas.put(LT, "<![CDATA[ < ]]>");

				datas.put(YES, TrueFalse.TRUE);
			}
		}
		return datas;
	}

}
