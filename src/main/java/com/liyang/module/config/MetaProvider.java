package com.liyang.module.config;

import java.util.List;
import java.util.Map;

import com.liyang.module.config.entity.Meta;

/**
 * 元数据提供者接口，用于获取系统配置的元数据
 * 
 * @author lijieran
 * 
 */
public interface MetaProvider {

	/**
	 * 获取所有的元数据信息
	 * 
	 * @return
	 */
	public Map<String, Map<String, Meta>> getAllMetas();
	
	/**
	 * 获取所有的元数据信息
	 * 
	 * @return
	 */
	public Map<String, List<Meta>> getAllMetasMap();

	/**
	 * 获取指定类型的元数据
	 * 
	 * @param metaType 指定的元数据类型
	 * @return
	 */
	public Map<String, Meta> getMetaMap(String metaType);
	
	/**
	 * 获取指定类型的元数据
	 * 
	 * @param metaType 指定的元数据类型
	 * @return
	 */
	public List<Meta> getMetaList(String metaType);
}
