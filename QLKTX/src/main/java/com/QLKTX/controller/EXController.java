package com.QLKTX.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.QLKTX.Entity.ThuePhong;
import com.QLKTX.Entity.sinhvien;
import com.QLKTX.Repository.SinhVienRepository;
import com.QLKTX.Repository.ThuePhongRepository;
import com.QLKTX.Service.SinhVienService;
import com.QLKTX.Service.SinhVienServiceImpl;
import com.QLKTX.Service.Export.ExSV;
import com.QLKTX.Service.Export.ExTP;

@Controller
public class EXController {

	 @Autowired
	    private ExSV excelExportSVService;
	 @Autowired
	 private ExTP excelExportTPService;

	 @Autowired
	 SinhVienRepository sv;
	 @Autowired
	 ThuePhongRepository thuephong;
	 @GetMapping("/export/excelsv")
	    public ResponseEntity<byte[]> exportExcelSV() throws IOException {
	        // Lấy danh sách sinh viên từ cơ sở dữ liệu
	        List<sinhvien> dataList = sv.findAll();

	        // Xuất dữ liệu ra file Excel
	        ByteArrayOutputStream outputStream = excelExportSVService.exportDataToExcel(dataList);

	        // Tạo header cho phản hồi
	        byte[] excelBytes = outputStream.toByteArray();
	        HttpHeaders headers = new HttpHeaders();
	        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=DSSV.xlsx");
	        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);

	        return ResponseEntity.ok()
	                .headers(headers)
	                .body(excelBytes);
	    }
	    
	    @GetMapping("/export/excelThuePhong")
	    public ResponseEntity<byte[]> exportExcelthuephong() throws IOException {
	        // Lấy danh sách sinh viên từ cơ sở dữ liệu
	        List<ThuePhong> dataList = thuephong.findAll();

	        // Xuất dữ liệu ra file Excel
	        ByteArrayOutputStream outputStream = excelExportTPService.exportDataToExcel(dataList);

	        // Tạo header cho phản hồi
	        byte[] excelBytes = outputStream.toByteArray();
	        HttpHeaders headers = new HttpHeaders();
	        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=DSThuePhong.xlsx");
	        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);

	        return ResponseEntity.ok()
	                .headers(headers)
	                .body(excelBytes);
	    }
}
