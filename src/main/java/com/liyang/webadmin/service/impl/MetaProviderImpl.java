package com.liyang.webadmin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.liyang.module.config.MetaProvider;
import com.liyang.module.config.entity.Meta;
import com.liyang.webadmin.persistence.mapper.MetaMapper;

@Service
public class MetaProviderImpl implements MetaProvider{
	
	private static Logger logger = Logger.getLogger(MetaProviderImpl.class);
	
	@Resource
	private MetaMapper metaMapper;

	public Map<String, Map<String, Meta>> getAllMetas() {
		// TODO Auto-generated method stub
		Map<String, Map<String, Meta>> metas = new HashMap<String, Map<String, Meta>>();
		
		try {
			List<Meta> list = metaMapper.findAll();
			for(Meta meta:list) {
				Map<String,Meta> map = metas.get(meta.getMetaType());
				if(map==null){
					map = new HashMap<String,Meta>();
					metas.put(meta.getMetaType(), map);
				}
				map.put(meta.getValue(), meta);
			}
		} catch (Exception e) {
			logger.error(e,e);
		}
		
		return metas;
	}

	public Map<String, Meta> getMetaMap(String metaType) {
		// TODO Auto-generated method stub
		Map<String, Meta> map = new HashMap<String, Meta>();
		
		try {
		 	List<Meta> list = metaMapper.findByType(metaType);
		 	for(Meta meta:list) {
				map.put(meta.getValue(), meta);
			}
		} catch (Exception e) {
			logger.error(e,e);
		}
		
		return map;
		
	}

	public Map<String, List<Meta>> getAllMetasMap() {
		// TODO Auto-generated method stub
		Map<String, List<Meta>> metaMap = new HashMap<String, List<Meta>>();
		try {
			List<Meta> list = metaMapper.findAll();
			for(Meta meta:list) {
				List<Meta> metaList = metaMap.get(meta.getMetaType());
				if(metaList==null){
					metaList = new ArrayList<Meta>();
					metaMap.put(meta.getMetaType(), metaList);
				}
				metaList.add(meta);
			}
		} catch (Exception e) {
			logger.error(e,e);
		}
		return metaMap;
	}

	public List<Meta> getMetaList(String metaType) {
		// TODO Auto-generated method stub
		List<Meta> metaList = metaMapper.findByType(metaType);;
		
		
		return metaList;
	}

}
