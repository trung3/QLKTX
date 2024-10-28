package com.QLKTX.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.QLKTX.Entity.lop;
import com.QLKTX.Entity.sinhvien;
import com.QLKTX.Service.LopService;
import com.QLKTX.Service.LopServiceImpl;
import com.QLKTX.Service.SinhVienServiceImpl;
@Controller
public class TaiKhoan {
	@Autowired
	SinhVienServiceImpl sinhvien;
	@Autowired

	@RequestMapping("/dangnhap")
	public String index() {
	     return "trang/aa";
	}
	
	@GetMapping("/addSV")
	public String addsv(Model m) {
		sinhvien sv = new sinhvien();
		sv.setGioiTinh(true);
		
//		 List<lop> danhSachLop = lop.findAll(); // Thay thế bằng phương thức hợp lệ để lấy danh sách lớp
//		    m.addAttribute("danhSachLop", danhSachLop);
		m.addAttribute("sv",sv);
		return "trang/addSV";
	}
	@PostMapping("/addSV")
	public String addsv(Model m,@Validated @ModelAttribute("sv") sinhvien sv,
			Errors errors){
		 sinhvien.add(sv);
		 List<lop> danhSachLop = lop.findAll(); // Thay thế bằng phương thức hợp lệ để lấy danh sách lớp
		    m.addAttribute("danhSachLop", danhSachLop);
		return "trang/addSV";
	}
}
