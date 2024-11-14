package com.QLKTX.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.QLKTX.Entity.NhanVien;
import com.QLKTX.Entity.PhongTrong;

@Controller
public class index {
	 @Autowired
	    private JdbcTemplate jdbcTemplate;
	@RequestMapping("/index")
	public String index(Model m,HttpSession session) {
		  // Gọi stored procedure để lấy danh sách nhân viên
        List<PhongTrong> phongTrong = jdbcTemplate.query(
                "CALL `qlktx`.`thong_ke_phong_trong`()",  // Câu lệnh để gọi stored procedure
                (rs, rowNum) -> new PhongTrong(
                        rs.getString("maPhong"),
                        rs.getInt("sucChua"),
                        rs.getInt("dangO")
                )
        );

        // Thêm danh sách nhân viên vào model
        m.addAttribute("phongTrong", phongTrong);

		return "trang/index";
	}


//	@RequestMapping("/addSV")
//	public String addSV(Model m) {
//		return "trang/addSV";
//	}
//	@RequestMapping("/tableSV")
//	public String tableSV(Model m) {
//		return "trang/tableSV";
//	}

	
	
}
