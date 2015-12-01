package com.github.hualuomoli.generator.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.DefaultResourceLoader;

import com.github.hualuomoli.generator.entity.Param;

public final class GenConfig {

	private static final Properties prop = new Properties();

	static {
		try {
			prop.load(new DefaultResourceLoader().getResource("prop/gen.properties").getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getPackage() {
		return prop.getProperty(Param.PACKAGE);
	}

	public static String getBatchInsertStart() {
		return prop.getProperty(Param.BATCH_INSERT_START);
	}

	public static String getBatchInsertEnd() {
		return prop.getProperty(Param.BATCH_INSERT_END);
	}

	public static String getDataBase() {
		return prop.getProperty("database");
	}

	public static String getProjectPath() {
		return prop.getProperty("projectPath");
	}

	public static String getOwner() {
		return prop.getProperty("owner");
	}

}
