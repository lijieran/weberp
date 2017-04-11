package com.liyang.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class AbstractService {
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String toJson(List<?> list) {
		GsonBuilder gsonbuilder = new GsonBuilder().serializeNulls();
		Gson gson = gsonbuilder.create();
		Map map = new HashMap();
		map.put("draw", 0);
		map.put("recordsTotal", list.size());
		map.put("recordsFiltered", list.size());
		map.put("data", list);
		String json = gson.toJson(map);
		return json;
	}

}
