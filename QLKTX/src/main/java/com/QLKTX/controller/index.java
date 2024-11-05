package com.QLKTX.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.QLKTX.Entity.NhanVien;

@Controller
public class index {
    
	@RequestMapping("/index")
	public String index(Model m,HttpSession session) {
//		NhanVien loggedInUser =(NhanVien) session.getAttribute("loggedInUser");
//		if(loggedInUser != null)
//			m.addAttribute("user", loggedInUser);
//		else
//			return "redirect:/trang/Login";
		return "trang/index";
	}

	
	
}
