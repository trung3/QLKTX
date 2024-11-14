package com.QLKTX.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.QLKTX.Entity.NhanVien;
import com.QLKTX.Entity.ThuePhong;
import com.QLKTX.Repository.ThuePhongRepository;

@Service
@Transactional
@Configuration
@EnableTransactionManagement
public class ThuePhongServiceImpl implements ThuePhongService {
	@Autowired 
	ThuePhongRepository ThuePhongRepository;
	
	@Override
	public List<ThuePhong> findAllThuePhong() {
		// TODO Auto-generated method stub
		return ThuePhongRepository.findAll();
	}
	@Override
	public ThuePhong findByMaPhong(ThuePhong maPhong) {
		// TODO Auto-generated method stub
		return ThuePhongRepository.findByMaPhong(maPhong);
	}
	@Override
	public Optional<ThuePhong> findByMaThuePhongService(Integer maThue) {
		// TODO Auto-generated method stub
		return ThuePhongRepository.findById(maThue);
	}
	@Transactional(rollbackOn = Exception.class)
	    public String add(ThuePhong thue) {
		 try {
		        // Chèn dữ liệu vào cơ sở dữ liệu
		        ThuePhongRepository.save(thue);
		        return "Thêm phòng thuê thành công";
		    } catch (DataIntegrityViolationException e) {
		        // Kiểm tra nếu lỗi phát sinh từ trigger MySQL
		        if (e.getMessage().contains("Mã sinh viên đã có thuê phòng còn hiệu lực, không thể chèn thêm")) {
		            return "Mã sinh viên đã có thuê phòng còn hiệu lực, không thể chèn thêm";
		        }
		        return "Lỗi vi phạm toàn vẹn dữ liệu!";
		    } catch (Exception e) {
		        // Log lỗi chi tiết và trả về thông báo
		        e.printStackTrace();
		        return "Lỗi không xác định: " + e.getMessage();
		    }
	}
	@Override
	public ThuePhong findByMaSV(String maSV) {
		// TODO Auto-generated method stub
		return ThuePhongRepository.findByMaSV(maSV);
	}
	@Override
	public Optional<ThuePhong> findByMaSVService(String maSV) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(ThuePhongRepository.findByMaSV(maSV));
	}
	@Override
	public ThuePhong findByMThue(Integer ma) {
		// TODO Auto-generated method stub
		return ThuePhongRepository.findByMaThue(ma);
	}
	@Override
	public ThuePhong update(Integer thuePhong) {
		// TODO Auto-generated method stub
		return null;
	}
}
