package com.QLKTX.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.QLKTX.Entity.NhanVien;
import com.QLKTX.Entity.Phong;
import com.QLKTX.Entity.PhongTrong;
import com.QLKTX.Entity.SinhVienTheoPhong;
import com.QLKTX.Entity.ThuePhong;
import com.QLKTX.Entity.sinhvien;
import com.QLKTX.Repository.PhongRepository;
import com.QLKTX.Repository.SinhVienRepository;
import com.QLKTX.Repository.ThuePhongRepository;
import com.QLKTX.Service.SinhVienServiceImpl;

@Controller
public class index {
	 @Autowired
	SinhVienRepository svRepo;
	 @Autowired
		PhongRepository phongRepo;
	 @Autowired
		ThuePhongRepository thuephongRepo;
	 @Autowired
	    private JdbcTemplate jdbcTemplate;
	@RequestMapping("/index")
	public String index(@RequestParam(value = "roomNumber", required = false) String roomNumber,Model m,HttpSession session) {
List<sinhvien> sinnhvienList = svRepo.findAll();
List<Phong> phongList = phongRepo.findAll();
List<ThuePhong> thuePhongList = thuephongRepo.findAll();
int sv,phong,tp,ptrong =0;
		  // Gọi stored procedure để lấy danh sách nhân viên
        List<PhongTrong> phongTrong = jdbcTemplate.query(
                "CALL `qlktx`.`thong_ke_phong_trong`()",  // Câu lệnh để gọi stored procedure
                (rs, rowNum) -> new PhongTrong(
                        rs.getString("maPhong"),
                        rs.getInt("sucChua"),
                        rs.getInt("dangO")
                )
        );
sv=sinnhvienList.size();
phong=phongList.size();
tp=thuePhongList.size();
ptrong=phongTrong.size();
m.addAttribute("sv", sv);
m.addAttribute("phong", phong);
m.addAttribute("tp", tp);
m.addAttribute("ptrong", ptrong);
// Thêm danh sách nhân viên vào model
        m.addAttribute("phongTrong", phongTrong);
  
        List<SinhVienTheoPhong> studentList = new ArrayList<>();
        if (roomNumber != null && !roomNumber.isEmpty()) {
        	 // Gọi Stored Function để lấy thông tin sinh viên theo mã phòng
            String studentInfo = getStudentsInfoByRoom(roomNumber);
            // Tách thông tin sinh viên thành danh sách các đối tượng Student
            studentList = processStudentInfo(studentInfo);
        }

      

        // Thêm vào model để hiển thị trên HTML
        // Truyền danh sách sinh viên vào model
        m.addAttribute("students", studentList);
        m.addAttribute("roomNumber", roomNumber);  // Để giữ giá trị mã phòng trong form tìm kiếm  
		return "trang/index";
	}


	  private String getStudentsInfoByRoom(String roomNumber) {
	        String studentInfo = "";

	        // SQL để gọi Stored Function
	        String sql = "{ ? = CALL GetStudentsInfoByRoom(?) }";

	        try (java.sql.Connection connection = jdbcTemplate.getDataSource().getConnection();
	             java.sql.CallableStatement stmt = connection.prepareCall(sql)) {
	            stmt.setString(2, roomNumber); // Tham số đầu vào: mã phòng
	            stmt.registerOutParameter(1, java.sql.Types.VARCHAR); // Tham số đầu ra: chuỗi thông tin sinh viên

	            // Thực thi và lấy kết quả
	            stmt.execute();
	            studentInfo = stmt.getString(1);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return studentInfo;
	    }
	 private List<SinhVienTheoPhong> processStudentInfo(String studentInfo) {
	        List<SinhVienTheoPhong> studentList = new ArrayList<>();

	        if (studentInfo != null && !studentInfo.isEmpty()) {
	            String[] students = studentInfo.split("; ");
	            for (String student : students) {
	                String[] details = student.split(", ");
	                if (details.length == 4) {
	                    String id = details[0].substring(4); // Lấy ID từ chuỗi "ID: "
	                    String name = details[1].substring(6); // Lấy tên từ chuỗi "Name: "
	                    String dob = details[2].substring(6); // Lấy ngày sinh từ chuỗi "DOB: "
	                    String gender = details[3].substring(9); // Lấy giới tính từ chuỗi "Gender: "

	                    // Tạo đối tượng Student và thêm vào danh sách
	                    studentList.add(new SinhVienTheoPhong(id, name, dob, gender));
	                }
	            }
	        }
	        return studentList;
	    }
	
}
