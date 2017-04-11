package com.liyang.module.config;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.liyang.module.config.entity.Meta;
import com.liyang.module.spring.SpringUtil;

public class MetaPool {

	// 禁止构造实例
	private MetaPool() {
	}

	/** 高并发实现的元数据缓存池 */
	private static Map<String, Map<String, Meta>> METAS_POOL = null;
	
	/** 高并发实现的元数据缓存池 */
	private static Map<String, List<Meta>> METAS_MAP = null;
	
	/** 元数据提供者接口实现类 */
	private static MetaProvider META_PROVIDER = null;
	static {
		META_PROVIDER = SpringUtil.getBean(MetaProvider.class);
		reload();
	}

	/**
	 * 重新加载所有的元数据
	 * 
	 */
	public static final void reload() {
		METAS_POOL = META_PROVIDER.getAllMetas();
		METAS_MAP = META_PROVIDER.getAllMetasMap();
	}

	/**
	 * 重新加载指定类型的元数据
	 * 
	 * @param metaType
	 */
	public static final void reload(String metaType) {
		if (metaType == null) {
			throw new NullPointerException("metaType must be not null:" + metaType);
		}
		Map<String, Meta> map = META_PROVIDER.getMetaMap(metaType);
		METAS_POOL.put(metaType, map);
	}

	/**
	 * 移除缓存中指定类型的所有元数据
	 * 
	 * @param metaType
	 */
	public static final Map<String, Meta> remove(String metaType) {
		if (metaType == null) {
			throw new NullPointerException("metaType must be not null:" + metaType);
		}
		return METAS_POOL.remove(metaType);
	}

	/**
	 * 根据指定的元数据类型获取对应的元数据Map集合
	 * 
	 * @param metaType 指定的元数据类型
	 * @return
	 */
	public static final Map<String, Meta> getMetaMap(String metaType) {
		return METAS_POOL.get(metaType);
	}
	
	public static final List<Meta> getMetaList(String metaType) {
		return METAS_MAP.get(metaType);
	}
	
	

	/**
	 * 根据指定的元数据类型和所属群组获取对应的元数据Map集合<br>
	 * <strong>注意：</strong>该方法内部返回的是<code>LinkedHashMap</code>，请不要用于多线程环境
	 * 
	 * @param metaType 指定的元数据类型
	 * @param group 所属群组
	 * @return
	 */
	public static final Map<String, Meta> getMetaMap(String metaType, String group) {
		Map<String, Meta> metaMap = METAS_POOL.get(metaType);
		if (metaMap == null) {
			return null;
		}
		LinkedHashMap<String, Meta> resultMetaMap = new LinkedHashMap<String, Meta>();
		for (Entry<String, Meta> entry : metaMap.entrySet()) {
			//if (entry.getValue().getGroup().equals(group)) {
				resultMetaMap.put(entry.getKey(), entry.getValue());
			//}
		}
		return resultMetaMap;
	}

	/**
	 * 根据元数据的类型和代码值，获取对应的元数据标签文本
	 * 
	 * @param metaType 指定的元数据类型
	 * @param value 指定的元数据代码值
	 * @return
	 */
	public static final String getLabel(String metaType, String value) {
		Map<String, Meta> metaMap = METAS_POOL.get(metaType);
		if (metaMap != null) {
			Meta meta = metaMap.get(value);
			if (meta != null) {
				return meta.getLabel();
			}
		}
		return null;
	}

	/**
	 * 根据元数据的类型和标签文本，获取对应的元数据代码值
	 * 
	 * @param metaType 指定的元数据类型
	 * @param label 指定的元数据标签文本
	 * @return
	 */
	public static final String getValue(String metaType, String label) {
		Map<String, Meta> metaMap = METAS_POOL.get(metaType);
		if (metaMap != null) {
			for (Meta meta : metaMap.values()) {
				if (meta.getLabel().equals(label)) {
					return meta.getValue();
				}
			}
		}
		return null;
	}
}
