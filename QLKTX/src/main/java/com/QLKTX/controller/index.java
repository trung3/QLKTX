package com.QLKTX.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class index {
    
	@RequestMapping("/index")
	public String index(Model m) {
		return "trang/index";
	}

//	@RequestMapping("/addSV")
//	public String addSV(Model m) {
//		return "trang/addSV";
//	}
//	@RequestMapping("/tableSV")
//	public String tableSV(Model m) {
//		return "trang/tableSV";
//	}
	
	
}
