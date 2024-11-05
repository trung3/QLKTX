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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.QLKTX.Entity.Phong;
import com.QLKTX.Entity.ThuePhong;
import com.QLKTX.Repository.ThuePhongRepository;
@Controller
public class ThuePhongController {
	@Autowired
	ThuePhongRepository thuePhongRepo;
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
