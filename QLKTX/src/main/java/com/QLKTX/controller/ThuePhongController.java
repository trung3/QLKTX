package com.QLKTX.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.QLKTX.Service.PhongServiceImpl;
import com.QLKTX.Service.TT_ThuePhongServiceImpl;
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
	TT_ThuePhongServiceImpl ttSVI;
	@Autowired 
	PhongServiceImpl phongSVI;
	@Autowired
	HttpServletRequest req;
	@Autowired
	com.QLKTX.SessionService session;
	@GetMapping("/admin/addTP")
	public String addTP(Model m) {
		ThuePhong thuePhong = new ThuePhong();
	
	
		m.addAttribute("thuephong",thuePhong);
		return "trang/addTP";
	}
	
	@PostMapping("/admin/addTP")
	public String addTP(Model m,@Validated @ModelAttribute("thuephong") ThuePhong thuephong,Errors errors,
			@RequestParam("hocKy") Integer hocKy ) {
		 Boolean check=true;
			
//		 if(!errors.hasErrors()) {
Optional<ThuePhong> checkmssv = thuePhongSVI.findByMaThuePhongService(thuephong.getMaThuePhong());
//
//		if(!checkmssv.isEmpty()) {
//        	 check =false;
//        	 m.addAttribute("ktTonTai", " đã tồn tại");
//         
//
//		} 
		 sinhvien sv = sinhVienRepo.findByMaSV(thuephong.getMaSV().getIdSV());
		 Phong phong = phongRepo.findByMaPhong(thuephong.getMaPhong().getIdPhong());
		 
		 if(!checkmssv.isEmpty()) {
			 check =false;
			 m.addAttribute("tb","Thêm thất bại");
		 }
				 
		  if(sv == null) {
			   m.addAttribute("ktTonTai", " không tồn tại");
			   check=false;
		   }
		   if(phong == null) {
			   m.addAttribute("ktmaPhong", " không tồn tại");
			   check=false;
		   }
		   if(hocKy == 0) {
			   m.addAttribute("kthocKy", " chưa chọn");
			   check=false;
		   }

		
		if(check) {
		int nam=	LocalDate.now().getYear();
			if(phong.getConTrong()==0) {
				m.addAttribute("tb","Phòng đã hết chỗ");
				
			}else {
				
				int daO = phong.getDaO()	+1;
				int conTrong = phong.getConTrong()-1;
				phong.setDaO(daO)	;
				phong.setConTrong(conTrong)	;
				if(hocKy==1) {
			
			
			  LocalDate specificDate = LocalDate.of(nam, 1, 1);
			  LocalDate newDateAfterMonths = specificDate.plusMonths(5);
		      LocalDate finalDate = newDateAfterMonths.minusDays(1);
		      thuephong.setNgayBatDau(specificDate);
			  thuephong.setNgayKetThuc(finalDate);
			}	else {
				 LocalDate specificDate = LocalDate.of(nam, 1, 1);
				 LocalDate newDateAfterYears = specificDate.plusYears(1);
				  LocalDate newDateAfterMonths = newDateAfterYears.plusMonths(7);
			      LocalDate finalDate = newDateAfterMonths.minusDays(1);
			      thuephong.setNgayBatDau(newDateAfterYears);
				  thuephong.setNgayKetThuc(finalDate);
			}
			thuephong.setMaSV(sv);
			thuephong.setMaPhong(phong);
			thuephong.setGiaThue(phong.getGiaThue());
		
			Object loggedInUser = session.getAttribute("loggedInUser");

			NhanVien nv =(NhanVien) loggedInUser;
			if(loggedInUser!=null) {
			thuePhongSVI.add(thuephong);
			 // thêm tt_thue phong	
				TT_ThuePhong tt = new TT_ThuePhong();
				ThuePhong tp = thuePhongRepo.findByMaThue(thuephong.getMaThuePhong());
				
				tt.setMaThuePhong(tp);			
				tt.setGiaThue(tp.getGiaThue());
				tt.setMaNV(nv);
				tt.setNgayThanhToan(null);
				tt.setThanhToan(false);
				tt.setTrangThai(true);
				ttSVI.add(tt);
				m.addAttribute("tb","Thêm thành công");
			}else {
				 m.addAttribute("tb","Chưa đăng nhập");
			}
			}
			
			
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
		int nam=	LocalDate.now().getYear();
		Optional<ThuePhong> checkmstp= thuePhongSVI.findByMaThuePhongService(id);
		ThuePhong tp = checkmstp.get();
		  LocalDate specificDate = LocalDate.of(nam, 1, 1);

	        // Giả sử tp.getNgayBatDau() trả về ngày bắt đầu của sự kiện


	        // Kiểm tra ngày bắt đầu của sự kiện có bằng ngày cố định không
	        String selectedOption = tp.getNgayBatDau().isEqual(specificDate) ? "Kỳ 1" : "Kỳ 2";

	        // Truyền selectedOption vào Model để sử dụng trong view
	        m.addAttribute("selectedOption", selectedOption);  
	            m.addAttribute("thuephong",tp);
	            return "trang/addTP";
	}
	@PostMapping("/admin/updateTP")
	public String Update1(Model m,@RequestParam("id") Integer id,
			@Validated @ModelAttribute("thuephong") ThuePhong thuephong, 
			Errors errors,@RequestParam("hocKy") Integer hocKy ) {
		 Boolean check=true;
		 if(!errors.hasErrors()) {
//
//		if(!checkmssv.isEmpty()) {
//        	 check =false;
//        	 m.addAttribute("ktTonTai", " đã tồn tại");
//         
//
//		} 
		 sinhvien sv = sinhVienRepo.findByMaSV(thuephong.getMaSV().getIdSV());
		 Phong phong = phongRepo.findByMaPhong(thuephong.getMaPhong().getIdPhong());
		
			
		  if(sv == null) {
			   m.addAttribute("ktTonTai", " không tồn tại");
			   check=false;
		   }
		   if(phong == null) {
			   m.addAttribute("ktmaPhong", " không tồn tại");
			   check=false;
		   }
		   if(hocKy == 0) {
			   m.addAttribute("kthocKy", " chưa chọn");
			   check=false;
		   }
		   //Kiểm tra sdt có tồn tại không
		
		if(check) {
		int nam=	LocalDate.now().getYear();
//			Phong phong = phongRepo.findByMaPhong(thuephong.getMaPhong().getIdPhong());
//			if(phong.getSucChua()==0) {
//				m.addAttribute("tb","Phòng đã hết chỗ");
//				
//			}else {
//				TT_ThuePhong ttthuePhong = new TT_ThuePhong();
//				int daO = phong.getDaO()	+1;
//				int conTrong = phong.getConTrong()-1;
			if(hocKy==1) {
			
			
			  LocalDate specificDate = LocalDate.of(nam, 1, 1);
			  LocalDate newDateAfterMonths = specificDate.plusMonths(5);
		      LocalDate finalDate = newDateAfterMonths.minusDays(1);
		      thuephong.setNgayBatDau(specificDate);
			  thuephong.setNgayKetThuc(finalDate);
			}else {
				 LocalDate specificDate = LocalDate.of(nam, 1, 1);
				 LocalDate newDateAfterYears = specificDate.plusYears(1);
				  LocalDate newDateAfterMonths = newDateAfterYears.plusMonths(7);
			      LocalDate finalDate = newDateAfterMonths.minusDays(1);
			      thuephong.setNgayBatDau(newDateAfterYears);
				  thuephong.setNgayKetThuc(finalDate);
			}
			thuephong.setMaSV(sv);
			thuephong.setMaPhong(phong);
			thuePhongSVI.add(thuephong);
			m.addAttribute("tb","Sửa thành công");
		}
	
		 } else {
				System.err.print(errors.getAllErrors());
		 }
				return "trang/addTP";
		 
	}
	@RequestMapping("/admin/TableTP")
	public String tableNV(Model m,	@RequestParam("p") Optional<Integer> p,
			@RequestParam("s") Optional<Integer> s) {
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
	@PostMapping("/admin/TableTP/search")
	public String search(Model m,
			@RequestParam("keywords") Optional<String> kw,
			@RequestParam("p") Optional<Integer> p,
			@RequestParam("s") Optional<Integer> s){
			m.addAttribute("tp",new ThuePhong());
		
		String kwords = kw.orElse(session.getAttribute("keywords"));
		int key = Integer.parseInt(kwords);
		session.setAttribute("keywords", kwords);
		m.addAttribute("keywords", kwords);
		int currentPage = p.orElse(0);
		int pagesize = s.orElse(5);
		Pageable pageable = PageRequest.of(currentPage, pagesize);
		Page<ThuePhong> resultPage = thuePhongRepo.findByKeywords(key, pageable);
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
	
		

		return "trang/tableTP";
		
	}

}
