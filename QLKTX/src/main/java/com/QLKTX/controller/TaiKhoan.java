package com.QLKTX.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import com.QLKTX.Repository.SinhVienRepository;
import com.QLKTX.Service.LopService;
import com.QLKTX.Service.LopServiceImpl;
import com.QLKTX.Service.SinhVienServiceImpl;
@Controller
public class TaiKhoan {
	@Autowired
	SinhVienServiceImpl sinhvien;
	@Autowired
    LopServiceImpl lop;
	@Autowired
	SinhVienRepository sinhvienrepo;
	@RequestMapping("/dangnhap")
	public String index() {
	     return "trang/aa";
	}
	
	@GetMapping("/addSV")
	public String addsv(Model m) {
		sinhvien sv = new sinhvien();
		sv.setGioiTinh(true);
		
		 List<lop> danhSachLop = lop.findAllLop(); // Thay thế bằng phương thức hợp lệ để lấy danh sách lớp
		    m.addAttribute("danhSachLop", danhSachLop);
		m.addAttribute("sv",sv);
		
		
		return "trang/addSV";
	}
	@PostMapping("/addSV")
	public String addsv(Model m,@Validated @ModelAttribute("sv") sinhvien sv,
			Errors errors){
		 Boolean check=false;
		 List<lop> danhSachLop = lop.findAllLop(); // Thay thế bằng phương thức hợp lệ để lấy danh sách lớp
		    m.addAttribute("danhSachLop", danhSachLop);
		    if(errors.hasErrors()==false) {
		   Optional<com.QLKTX.Entity.sinhvien> checkmssv= sinhvien.findByMaSVService(sv.getIdSV());
		         if(!checkmssv.isEmpty()) {
		        	 check =false;
		        	 m.addAttribute("ktTonTai", "Mã số sinh viên đã tồn tại");
		         }else {
		        	 check=true;
		         }
		         if(check==true) {
		        	 sinhvien.add(sv);
				    	m.addAttribute("tb","Đăng ký thành công");
		         }
		    	
		    }else {
		    	m.addAttribute("tb","Đăng ký thất bại");
		    }
		return "trang/addSV";
	}
	@RequestMapping("/TableSV")
	public String tablesv(Model m) {
		Pageable pageable =PageRequest.of(0,5);
		Page<sinhvien> resultPage= sinhvienrepo.findAll(pageable);
		m.addAttribute("svPage",resultPage);
		return "trang/tableSV";
	}
}
