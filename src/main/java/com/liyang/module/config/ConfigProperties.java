package com.liyang.module.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class ConfigProperties {
	
	// 禁止实例创建
		private ConfigProperties() {
		}

		private static final Map<String, String> config = new ConcurrentHashMap<String, String>();
		static {
			reload();
		}

		/**
		 * 获取config.properties配置中指定属性的值，如果没有指定的属性，将返回null
		 * 
		 * @param key
		 * @return
		 */
		public static String get(String key) {
			return config.get(key);
		}

		/**
		 * 重新加载config.properties配置文件
		 * 
		 * @since
		 */
		public static final void reload() {
			InputStream inputStream = ConfigProperties.class.getResourceAsStream("/config.properties");
			if (inputStream != null) {
				Properties prop = new Properties();
				try {
					prop.load(inputStream);
				} catch (IOException e) {
					System.err.println("加载config.properties文件失败，该文件可能被其他程序占用!");
				} finally {
					if (inputStream != null) {
						try {
							inputStream.close();
						} catch (IOException e) {
							// ignore exception
						}
					}
				}
				config.clear();
				for (Entry<Object, Object> entry : prop.entrySet()) {
					config.put(entry.getKey().toString(), entry.getValue().toString());
				}
			} else {
				System.err.println("在classpath目录下没有找到config.properties文件，系统将使用默认配置!");
			}
		}

}
