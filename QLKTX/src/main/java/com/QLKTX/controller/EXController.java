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

import com.QLKTX.Entity.sinhvien;
import com.QLKTX.Repository.SinhVienRepository;
import com.QLKTX.Service.SinhVienService;
import com.QLKTX.Service.SinhVienServiceImpl;
import com.QLKTX.Service.Export.ExSV;

@Controller
public class EXController {

	 @Autowired
	    private ExSV excelExportService;

	 @Autowired
	 SinhVienRepository sv;
	 @GetMapping("/export/excelsv")
	    public ResponseEntity<byte[]> exportExcel() throws IOException {
	        // Lấy danh sách sinh viên từ cơ sở dữ liệu
	        List<sinhvien> dataList = sv.findAll();

	        // Xuất dữ liệu ra file Excel
	        ByteArrayOutputStream outputStream = excelExportService.exportDataToExcel(dataList);

	        // Tạo header cho phản hồi
	        byte[] excelBytes = outputStream.toByteArray();
	        HttpHeaders headers = new HttpHeaders();
	        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=DSSV.xlsx");
	        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);

	        return ResponseEntity.ok()
	                .headers(headers)
	                .body(excelBytes);
	    }
}
