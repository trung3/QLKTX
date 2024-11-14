package com.QLKTX.Service.Export;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.QLKTX.Entity.ThuePhong;
import com.QLKTX.Entity.sinhvien;

@Service
public class ExTP {

	 public ByteArrayOutputStream exportDataToExcel(List<ThuePhong> dataList) throws IOException {
	        Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet("DSThuePhong");

	        // Tạo tiêu đề
	        Row header = sheet.createRow(0);
	        header.createCell(0).setCellValue("Mã thuê phòng");
	        header.createCell(1).setCellValue("Mã sinh viên");
	        header.createCell(2).setCellValue("Mã phòng");
	        header.createCell(3).setCellValue("Ngày bắt đầu");
	        header.createCell(4).setCellValue("Ngày kết thúc");
	        header.createCell(5).setCellValue("Giá thuê");
            
	        // Thêm dữ liệu
	        int rowNum = 1;
	        for (ThuePhong data : dataList) {
	            Row row = sheet.createRow(rowNum++);
	            row.createCell(0).setCellValue(data.getMaThuePhong());
	            row.createCell(1).setCellValue(data.getMaSV().getIdSV());
	            row.createCell(2).setCellValue(data.getMaPhong().getIdPhong());
	            row.createCell(3).setCellValue(data.getNgayBatDau());
	            row.createCell(4).setCellValue(data.getNgayKetThuc());
	            row.createCell(5).setCellValue(data.getGiaThue());
	           
	           
	        }

	        // Xuất dữ liệu ra ByteArrayOutputStream
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        workbook.write(outputStream);
	        workbook.close();

	        return outputStream;
	    }
}
