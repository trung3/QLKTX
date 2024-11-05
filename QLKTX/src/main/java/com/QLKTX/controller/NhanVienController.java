package com.QLKTX.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

import com.QLKTX.Entity.NhanVien;
import com.QLKTX.Entity.sinhvien;
import com.QLKTX.Repository.NhanVienRepository;
import com.QLKTX.Service.NhanVienServiceImpl;

@Controller
public class NhanVienController {
	@Autowired
	NhanVienRepository nhanVienRepo;
	@Autowired 
	NhanVienServiceImpl nhanVienSVI;
	@GetMapping("/admin/addNV")
	public String addNV(Model m) {
		NhanVien nhanvien = new NhanVien();
		nhanvien.setTrangThai(true);
		m.addAttribute("nhanvien",nhanvien);
		return "trang/addNV";
	}
	@PostMapping("/admin/addNV")
	public String addNV(Model m,@Validated @ModelAttribute("nhanvien") NhanVien nhanvien,Errors errors) {
		 Boolean check=true;
		 if(!errors.hasErrors()) {
Optional<NhanVien> checkmsnv = nhanVienSVI.findByMaNVService(nhanvien.getIdNV());

		if(!checkmsnv.isEmpty()) {
        	 check =false;
        	 m.addAttribute("ktTonTai", " đã tồn tại");
         

		} 
		   if(nhanVienSVI.findByEmail(nhanvien.getEmail())!=null) {
			   m.addAttribute("ktEmail", " đã tồn tại");
			   check=false;
		   }
		   //Kiểm tra sdt có tồn tại không
		   if(nhanVienSVI.findBySdt(nhanvien.getSdt())!=null) {
			   m.addAttribute("ktPhone", " đã tồn tại");
			  
			   check=false;
		   }
		if(check) {
			nhanVienSVI.add(nhanvien);
			m.addAttribute("tb","Thêm nhân viên thành công");
		}
		}else {
	    	m.addAttribute("tb","Thêm nhân viên thất bại");
	    

		 }
		return "trang/addNV";
	}
	
	@GetMapping("/admin/updateNV")
	public String Update(Model m,@RequestParam("id") String id,
			@Validated @ModelAttribute("nhanvien") NhanVien nhanvien, 
			Errors errors) {
		Optional<NhanVien> checkmsnv= nhanVienSVI.findByMaNVService(id);
		NhanVien nv = checkmsnv.get();
		

	            m.addAttribute("nhanvien",nv);
	            return "trang/addNV";
	}
	
	@PostMapping("/admin/updateNV")
	public String Update1(Model m,@RequestParam("id") String id,
			@Validated @ModelAttribute("nhanvien") NhanVien nhanvien, 
			Errors errors) {
		Optional<NhanVien> checkmsnv= nhanVienSVI.findByMaNVService(id);
		NhanVien nv = checkmsnv.get();
		 if(!errors.hasErrors()) {    	     	
			 nhanVienSVI.add(nhanvien);
					    	m.addAttribute("tb","Sửa nhân viên thành công");
			         
			    	
			    }else {
			    	m.addAttribute("tb","Sửa nhân viên thất bại");
			    }
		

	            m.addAttribute("nhanvien",nv);
	            return "trang/addNV";
	}
	@RequestMapping("/admin/TableNV")
	public String tableNV(Model m,	@RequestParam("p") Optional<Integer> p,@RequestParam("s") Optional<Integer> s) {
		int currentPage = p.orElse(0);
		int pagesize = s.orElse(5);
		Pageable pageable = PageRequest.of(currentPage, pagesize);
		Page<NhanVien> resultPage = nhanVienRepo.findAll(pageable);
		NhanVien nv = new NhanVien();
		nv.setTrangThai(true);
		int totalPages = resultPage.getTotalPages();
		if(totalPages >0) {
			int start = Math.max(1,currentPage-2);
			int end = Math.min(currentPage +2,totalPages);
			
			if(totalPages >5) {
				if(end == totalPages) {
					start = end -5;
				}else if(start == 1) {
					end = start +5;
				}
			}
			List<Integer> pageNumber = IntStream.rangeClosed(start,end)
					.boxed()
					.collect(Collectors.toList());
			
			m.addAttribute("pageNumbers",pageNumber);
		}
		m.addAttribute("NhanVienPage",resultPage);
		m.addAttribute("nv",nv);
		
		return "trang/tableNV";
	}
}
