package com.liyang.webadmin.web;

import java.util.Map;

import com.liyang.module.config.MetaPool;
import com.liyang.module.config.entity.Meta;

public class MetaUtils {
	
	/**
	 * 根据jquery-table格式生成前端所需的columnDef
	 * @param metaType
	 * @return 
	 */
	public static String generateColumnDefs(String metaType) {
		StringBuilder builder = new StringBuilder();
		Map<String,Meta> metaMap = MetaPool.getMetaMap(metaType);
		
		for (Meta meta : metaMap.values()) {
			String label = meta.getLabel(), value = meta.getValue();
			builder.append("if(data=='"+value+"') return '"+label+"';");
				
		}
		return builder.toString();
	}

}
