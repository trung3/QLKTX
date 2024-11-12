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
import org.springframework.web.bind.annotation.RequestParam;

import com.QLKTX.Entity.NhanVien;
import com.QLKTX.Entity.sinhvien;
import com.QLKTX.Service.NhanVienServiceImpl;

@Controller
public class taikhoanController {

	@Autowired
	NhanVienServiceImpl nvmpl;
//	@RequestMapping("/security/login/form")
//	public String loginForm(Model m) {
//		m.addAttribute("tb","Vui lòng đăng nhập!!");
//		return "trang/Login";
//	}
//	@RequestMapping("/security/success")
//	public String loginSucess(Model m) {
//		m.addAttribute("tb","Đăng nhập thành công");
//		return "trang/Login";
//	}
//	
//	@RequestMapping("/security/error")
//	public String loginError(Model m) {
//		m.addAttribute("tb","Sai thông tin đăng nhập hoặc tài khoản ngừng hoạt động!!");
//		return "trang/Login";
//	}
//	@RequestMapping("/security/unauthoried")
//	public String Unauthoried(Model m) {
//		m.addAttribute("tb","Không có quyền truy cập!!");
//		return "trang/Login";
//	}
//	@RequestMapping("/security/logout/success")
//	public String LogoutSuccess(Model m) {
//		m.addAttribute("tb","Bạn đã đăng xuất!!");
//		return "trang/Login";
//	}
	
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
            m.addAttribute("tb","Sai mật khẩu");
            return "trang/Login"; // Trả về trang login nếu có lỗi
        }

        // Tìm nhân viên theo mã số nhân viên
        Optional<NhanVien> checkMSNV = nvmpl.findByMaNVService(nv.getIdNV());

        // Kiểm tra xem nhân viên có tồn tại không
        if (checkMSNV.isPresent()) {
            NhanVien getNV = checkMSNV.get();

            // Kiểm tra mật khẩu
            if (getNV.getMatKhau().equals(nv.getMatKhau())) {
                if(getNV.isTrangThai()) {
                	// Đăng nhập thành công
                    session.setAttribute("loggedInUser",getNV);// Lưu đối tượng NhanVien vào session
                  return "redirect:/index"; // Chuyển hướng đến trang index
                }else {
                	m.addAttribute("tb", "Tài khoản đã bị khóa");
                }
            	
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
	
	@GetMapping("/dk")
	public String dk(Model m) {
		NhanVien nv = new NhanVien();
	    m.addAttribute("nv",nv);
		return "trang/dk";
	}
	@PostMapping("/dk")
	public String dk1(Model m,@Validated @ModelAttribute("nv") NhanVien nv,Errors errors,
			@RequestParam("NLMK") String NLpass) {
		boolean check =true;
		nv.setGhiChu(null);
		nv.setTrangThai(true);
		if(!errors.hasErrors()) {
			Optional<NhanVien> checkMSNV = nvmpl.findByMaNVService(nv.getIdNV());
			if(!checkMSNV.isEmpty()) {
				check= false;
				m.addAttribute("ktTonTai", "Mã nhân viên đã tồn tại");
			}
			if(nvmpl.findByEmail(nv.getEmail())!=null) {
				check= false;
				m.addAttribute("ktEmail", "Email đã tồn tại");
			}
			if(nvmpl.findBySdt(nv.getSdt())!=null) {
				check= false;
				m.addAttribute("ktPhone", "Số điện thoại đã tồn tại");
			}
			
			if (!NLpass.equals(nv.getMatKhau())) {
				check= false;
				m.addAttribute("ktPass", "Mật khẩu không khớp");
			}
			
			if(check) {
				nvmpl.add(nv);
				m.addAttribute("tb","Đăng ký thành công");
			}
			
		}else {
			System.err.println(errors.getAllErrors());
			m.addAttribute("tb", "Đăng ký thất bại");
		}
		return "trang/dk";
	}
}
