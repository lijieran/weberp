package com.liyang.business.stock;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("stock")
public class StockController {
	
	@RequestMapping({"addItem"})
	public String add() {
		return "stock/addItem";
	}
	
	@RequestMapping({"index"})
	public String index() {
		return "stock/index";
	}
	
	@RequestMapping({"category"})
	public String category() {
		return "stock/category";
	}

}
