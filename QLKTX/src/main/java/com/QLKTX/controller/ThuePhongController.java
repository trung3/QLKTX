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
import com.QLKTX.Entity.Phong;
import com.QLKTX.Entity.TT_ThuePhong;
import com.QLKTX.Entity.ThuePhong;
import com.QLKTX.Entity.sinhvien;
import com.QLKTX.Repository.NhanVienRepository;
import com.QLKTX.Repository.PhongRepository;
import com.QLKTX.Repository.SinhVienRepository;
import com.QLKTX.Repository.ThuePhongRepository;
import com.QLKTX.Service.NhanVienServiceImpl;
import com.QLKTX.Service.PhongServiceImpl;
import com.QLKTX.Service.ThuePhongServiceImpl;
@Controller
public class ThuePhongController {
	@Autowired
	ThuePhongRepository thuePhongRepo;
	@Autowired
	PhongRepository phongRepo;
	@Autowired
	NhanVienRepository nhanVienRepo;
	@Autowired
SinhVienRepository sinhVienRepo;
	@Autowired 
	ThuePhongServiceImpl thuePhongSVI;
	@Autowired 
	PhongServiceImpl phongSVI;
	@GetMapping("/admin/addTP")
	public String addTP(Model m) {
		ThuePhong thuePhong = new ThuePhong();
	
		m.addAttribute("thuephong",thuePhong);
		return "trang/addTP";
	}
	
	@PostMapping("/admin/addTP")
	public String addTP(Model m,@Validated @ModelAttribute("thuephong") ThuePhong thuephong,Errors errors) {
		 Boolean check=true;
//		 if(!errors.hasErrors()) {
//ThuePhong checkmssv = thuePhongRepo.findByMaSV(thuephong.getMaSV().getIdSV());
//
//		if(checkmssv != null) {
//        	 check =false;
//        	 m.addAttribute("ktTonTai", " đã tồn tại");
//         
//
//		} 
		
		 Phong phong = phongRepo.findByMaPhong(thuephong.getMaPhong().getIdPhong());
		 
		   if(phong == null) {
			   m.addAttribute("ktmaPhong", " không tồn tại");
			   check=false;
		   }
		   //Kiểm tra sdt có tồn tại không
		
		if(check) {
//			Phong phong = phongRepo.findByMaPhong(thuephong.getMaPhong().getIdPhong());
//			if(phong.getSucChua()==0) {
//				m.addAttribute("tb","Phòng đã hết chỗ");
//				
//			}else {
//				TT_ThuePhong ttthuePhong = new TT_ThuePhong();
//				int daO = phong.getDaO()	+1;
//				int conTrong = phong.getConTrong()-1;
			sinhvien sv = sinhVienRepo.findByMaSV(thuephong.getMaSV().getIdSV());
			Phong maPhong = phongRepo.findByMaPhong(thuephong.getMaPhong().getIdPhong());
			
			thuephong.setMaSV(sv);
			thuephong.setMaPhong(maPhong);
						thuePhongSVI.add(thuephong);
			m.addAttribute("tb","Thêm thuê phòng thành công");
//			}}
		}
//		}else {
//	    	m.addAttribute("tb","Thêm thuê phòng thất bại");
//	    
//	    	System.err.print(thuephong.getMaSV().getIdSV());
//	    	System.err.print(thuephong.getMaPhong().getIdPhong());
//		 }
		return "trang/addTP";
	}
	@GetMapping("/admin/updateTP")
	public String Update(Model m,@RequestParam("id") Integer id,
			@Validated @ModelAttribute("thuephong") ThuePhong thuephong, 
			Errors errors) {
		Optional<ThuePhong> checkmstp= thuePhongSVI.findByMaThuePhongService(id);
		ThuePhong tp = checkmstp.get();
		

	            m.addAttribute("thuephong",tp);
	            return "trang/addTP";
	}
	@RequestMapping("/admin/TableTP")
	public String tableNV(Model m,	@RequestParam("p") Optional<Integer> p,@RequestParam("s") Optional<Integer> s) {
		int currentPage = p.orElse(0);
		int pagesize = s.orElse(5);
		Pageable pageable = PageRequest.of(currentPage, pagesize);
		Page<ThuePhong> resultPage = thuePhongRepo.findAll(pageable);
		ThuePhong tp = new ThuePhong();
		
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
		m.addAttribute("ThuePhongPage",resultPage);
		m.addAttribute("tp",tp);
		
		return "trang/tableTP";
	}
}
