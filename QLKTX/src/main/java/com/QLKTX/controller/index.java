package com.QLKTX.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class index {
    
	@RequestMapping("/index")
	public String index(Model m) {
		return "index";
	}
	@RequestMapping("/addNV")
	public String addNV(Model m) {
		return "addNV";
	}
	@RequestMapping("/tableNV")
	public String tableNV(Model m) {
		return "tableNV";
	}
	@RequestMapping("/addSV")
	public String addSV(Model m) {
		return "addSV";
	}
	@RequestMapping("/tableSV")
	public String tableSV(Model m) {
		return "tableSV";
	}
}
