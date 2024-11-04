package com.QLKTX.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.QLKTX.Service.NhanVienServiceImpl;

@Controller
public class taikhoanController {

	
	@RequestMapping("/login")
	public String index() {
	     return "trang/Login";
	}
	
	
}
