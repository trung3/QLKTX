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
	@RequestMapping("/addNV")
	public String addNV(Model m) {
		return "trang/addNV";
	}
	@RequestMapping("/tableNV")
	public String tableNV(Model m) {
		return "trang/tableNV";
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
