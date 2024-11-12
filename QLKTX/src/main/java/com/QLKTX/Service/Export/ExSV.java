package com.QLKTX.Service.Export;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.QLKTX.Entity.sinhvien;

@Service
public class ExSV {

	 public ByteArrayOutputStream exportDataToExcel(List<sinhvien> dataList) throws IOException {
	        Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet("DSSV");

	        // Tạo tiêu đề
	        Row header = sheet.createRow(0);
	        header.createCell(0).setCellValue("Mã số sinh viên");
	        header.createCell(1).setCellValue("Họ và tên");
	        header.createCell(2).setCellValue("Số điện thoại");
	        header.createCell(3).setCellValue("Email");
	        header.createCell(4).setCellValue("Mã lớp");
	        header.createCell(5).setCellValue("Giới tính");
            
	        // Thêm dữ liệu
	        int rowNum = 1;
	        for (sinhvien data : dataList) {
	            Row row = sheet.createRow(rowNum++);
	            row.createCell(0).setCellValue(data.getIdSV());
	            row.createCell(1).setCellValue(data.getNameSV());
	            row.createCell(2).setCellValue(data.getSdtSV());
	            row.createCell(3).setCellValue(data.getEmail());
	            row.createCell(4).setCellValue(data.getMaLop().getMaLop());
	            if(data.getGioiTinh()==true) {
	            	 row.createCell(5).setCellValue("Nam");
	            }else {
	            	 row.createCell(5).setCellValue("Nữ");
	            }
	           
	        }

	        // Xuất dữ liệu ra ByteArrayOutputStream
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        workbook.write(outputStream);
	        workbook.close();

	        return outputStream;
	    }
}
