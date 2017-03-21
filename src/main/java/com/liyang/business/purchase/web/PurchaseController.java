package com.liyang.business.purchase.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("purchase")
public class PurchaseController {
	
	@RequestMapping({"index"})
	public String index() {
		return "purchase/index";
	}

}
