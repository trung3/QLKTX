package com.QLKTX.controller;

import java.util.Arrays;
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
public class sinhvienController {
	@Autowired
	SinhVienServiceImpl sinhvien;
	@Autowired
    LopServiceImpl lop;
	@Autowired
	SinhVienRepository sinhvienrepo;
	
	
	@GetMapping("/admin/addSV")
	public String addsv(Model m) {
		sinhvien sv = new sinhvien();
		sv.setGioiTinh(true);
		
		 List<lop> danhSachLop = lop.findAllLop(); // Thay thế bằng phương thức hợp lệ để lấy danh sách lớp
		    m.addAttribute("danhSachLop", danhSachLop);
		m.addAttribute("sv",sv);
		
		
		return "trang/addSV";
	}
	@PostMapping("/admin/addSV")
	public String addsv(Model m,@Validated @ModelAttribute("sv") sinhvien sv,
			Errors errors){
		 Boolean check=true;
		 List<lop> danhSachLop = lop.findAllLop(); // Thay thế bằng phương thức hợp lệ để lấy danh sách lớp
		    m.addAttribute("danhSachLop", danhSachLop);
		    if(!errors.hasErrors()) {
		   Optional<sinhvien> checkmssv= sinhvien.findByMaSVService(sv.getIdSV());
		   
		 //Kiểm tra mssv có tồn tại không?   
		   if(!checkmssv.isEmpty()) {
		        	 check =false;
		        	 m.addAttribute("ktTonTai", " đã tồn tại");
		         }
		//   Kiểm tra email có tồn tại không
		   if(sinhvien.findByEmail(sv.getEmail())!=null) {
			   m.addAttribute("ktEmail", " đã tồn tại");
			   check=false;
		   }
		   //Kiểm tra sdt có tồn tại không
		   if(sinhvien.findBySdt(sv.getSdtSV())!=null) {
			   m.addAttribute("ktPhone", " đã tồn tại");
			  
			   check=false;
		   }
		         
		         if(check) {
		        	 sinhvien.add(sv);
				    	m.addAttribute("tb","Thêm sinh viên thành công");
		         }
		    	
		    }else {
		    	m.addAttribute("tb","Thêm sinh viên thất bại");
		    }
		return "trang/addSV";
	}
	@RequestMapping("/admin/TableSV")
	public String Updatetablesv(Model m) {
		Pageable pageable =PageRequest.of(0,5);
		Page<sinhvien> resultPage= sinhvienrepo.findAll(pageable);
		m.addAttribute("svPage",resultPage);
		sinhvien sv = new sinhvien();
		sv.setGioiTinh(true);
		
		 List<lop> danhSachLop = lop.findAllLop(); // Thay thế bằng phương thức hợp lệ để lấy danh sách lớp
		    m.addAttribute("danhSachLop", danhSachLop);
		m.addAttribute("sv",sv);
		return "trang/tableSV";
	}
	@GetMapping("/admin/update")
	public String Updatetablesv1(Model m,@RequestParam("id") String id,@RequestParam("edit") Boolean edit,
			@Validated @ModelAttribute("sv") sinhvien sv, 
			Errors errors) {
		m.addAttribute("edit",edit);
		Pageable pageable =PageRequest.of(0,5);
		Page<sinhvien> resultPage= sinhvienrepo.findAll(pageable);
		m.addAttribute("svPage",resultPage);
		Optional<sinhvien> checkmssv= sinhvien.findByMaSVService(id);
		sinhvien sinhVien = checkmssv.get();
	            m.addAttribute("sv",sinhVien);
	            // Thêm các thuộc tính khác nếu cần
		 List<lop> danhSachLop = lop.findAllLop(); // Thay thế bằng phương thức hợp lệ để lấy danh sách lớp
		    m.addAttribute("danhSachLop", danhSachLop);
//		m.addAttribute("sv",sv);
		return "trang/addSV";
	}
	@PostMapping("/admin/update")
	public String Updatetablesv(Model m,@RequestParam("id") String id,
			@Validated @ModelAttribute("sv") sinhvien sv, 
			Errors errors) {
		Boolean check=true;
		Pageable pageable =PageRequest.of(0,5);
		Page<sinhvien> resultPage= sinhvienrepo.findAll(pageable);
		m.addAttribute("svPage",resultPage);
		Optional<sinhvien> checkmssv= sinhvien.findByMaSVService(id);
		sinhvien sinhVien = checkmssv.get();
		 if(!errors.hasErrors()) {    	
       	  
       	
     	  if(sinhvien.findByEmail(sv.getEmail() )!= null) {
     		 sinhvien ktEmailTonTai = sinhvien.findByMSSVAndEmailService(sv.getIdSV(),sv.getEmail());
     		  if(ktEmailTonTai ==null) {
     	    		  check =false;
     	    		 m.addAttribute("ktEmail", " đã tồn tại");
     	    	  }

     	  }
     	 if(sinhvien.findBySdt(sv.getSdtSV() )!= null) {
     		sinhvien ktsdtTonTai = sinhvien.findByMSSVAndSdtService(sv.getIdSV(),sv.getSdtSV());
     		 if(ktsdtTonTai==null) {
				 check =false;
				 m.addAttribute("ktPhone", " đã tồn tại");
			 }
     	 }
     	      if(check) {
     	    	 sinhvien.add(sv);
			    	m.addAttribute("tb","Sửa sinh viên thành công");
     	      }
			    }else {
			    	m.addAttribute("tb","Sửa sinh viên thất bại");
			    }
		
		 

	        // Kiểm tra nếu có sinh viên
	        
	            

	            // Lấy dữ liệu từng dòng
	          
	            m.addAttribute("sv",sinhVien);
	            // Thêm các thuộc tính khác nếu cần
	        
		
		 List<lop> danhSachLop = lop.findAllLop(); // Thay thế bằng phương thức hợp lệ để lấy danh sách lớp
		    m.addAttribute("danhSachLop", danhSachLop);
//		m.addAttribute("sv",sv);
		return "trang/addSV";
	}
}
