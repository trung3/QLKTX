package com.QLKTX.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.QLKTX.Entity.NhanVien;
import com.QLKTX.Entity.sinhvien;
import com.QLKTX.Service.NhanVienServiceImpl;

@Controller
public class taikhoanController {

	@Autowired
	NhanVienServiceImpl nvmpl;
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	@GetMapping("/login")
	public String login(Model m) {
	    NhanVien nv = new NhanVien();
	    m.addAttribute("nv",nv);
		return "trang/Login";
	}
	@PostMapping("/login")
	public String login2(Model m,@Validated @ModelAttribute("nv") NhanVien nv,
			Errors errors,HttpSession session) {
		// Kiểm tra lỗi xác thực
        if (errors.hasErrors()) {
            m.addAttribute("tb", "Đăng nhập thất bại do lỗi xác thực");
            return "trang/Login"; // Trả về trang login nếu có lỗi
        }

        // Tìm nhân viên theo mã số nhân viên
        Optional<NhanVien> checkMSNV = nvmpl.findByMaNVService(nv.getIdNV());

        // Kiểm tra xem nhân viên có tồn tại không
        if (checkMSNV.isPresent()) {
            NhanVien getNV = checkMSNV.get();

            // Kiểm tra mật khẩu
            if (getNV.getMatKhau().equals(nv.getMatKhau())) {
                
            	// Đăng nhập thành công
                  session.setAttribute("loggedInUser",getNV);// Lưu đối tượng NhanVien vào session
                return "redirect:/index"; // Chuyển hướng đến trang index
            } else {
                // Mật khẩu không đúng
                m.addAttribute("tb", "Mật khẩu không đúng.");
            }
        } else {
            // Không tìm thấy nhân viên
            m.addAttribute("tb", "Không tìm thấy nhân viên.");
        }

        // Nếu không đăng nhập thành công, quay lại trang login với thông báo lỗi
        return "trang/Login";
    }
	
	
}