package com.QLKTX.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QLKTX.Entity.NhanVien;
import com.QLKTX.Entity.ThuePhong;
import com.QLKTX.Repository.ThuePhongRepository;

@Service
@Transactional
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
	@Override
	public void add(ThuePhong thue) {
		ThuePhongRepository.save(thue);
	}
	@Override
	public ThuePhong update(Integer maThue) {
		ThuePhong thue =  ThuePhongRepository.getById(maThue);
		ThuePhongRepository.save(thue);
		return thue;
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
}
