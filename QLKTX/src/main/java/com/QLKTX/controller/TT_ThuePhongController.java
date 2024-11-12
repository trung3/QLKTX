package com.QLKTX.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.QLKTX.Entity.TT_ThuePhong;

import com.QLKTX.Repository.PhongRepository;
import com.QLKTX.Repository.SinhVienRepository;
import com.QLKTX.Repository.ThuePhongRepository;

import com.QLKTX.Service.TT_ThuePhongServiceImpl;
import com.QLKTX.Service.ThuePhongServiceImpl;
@Controller
public class TT_ThuePhongController {
	@Autowired
	ThuePhongRepository thuePhongRepo;
	@Autowired
	PhongRepository phongRepo;

	@Autowired
SinhVienRepository sinhVienRepo;
	@Autowired 
	ThuePhongServiceImpl thuePhongSVI;
	@Autowired 
	TT_ThuePhongServiceImpl ttSVI;

	
	@GetMapping("/admin/updateTT")
	public String Update(Model m, @RequestParam("id") Integer id,@Validated @ModelAttribute("thongtintp") TT_ThuePhong thongtintp) {
	    TT_ThuePhong checkmstp = ttSVI.findByMaThuePhongService(id);

	    // Thêm đối tượng vào model để hiển thị trong form
	    m.addAttribute("thongtintp", checkmstp);

	    return "trang/viewTT"; // Trả về view chứa form
	}

	@PostMapping("/admin/updateTT")
	public String Update( @RequestParam("id") Integer id,@Validated @ModelAttribute("thongtintp") TT_ThuePhong thongtintp,
	                     Errors errors, Model m) {
		Optional<TT_ThuePhong> checkmtttp = ttSVI.findByMaTTThuePhongService(id);
				TT_ThuePhong tt =checkmtttp.get();
				if (!errors.hasErrors()) {
	    	
	    	ttSVI.add(thongtintp);
		    
	        
	    }

	    // Nếu không có lỗi, thực hiện cập nhật dữ liệu
	    m.addAttribute("thongtintp", tt);
	    return "trang/viewTT"; // Chuyển hướng đến trang thành công
	}



}
