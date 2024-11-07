package com.QLKTX.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QLKTX.Entity.Phong;
import com.QLKTX.Entity.lop;

import com.QLKTX.Repository.PhongRepository;

@Service
@Transactional
public class PhongServiceImpl implements PhongService {
	@Autowired
	PhongRepository phongReposi;



	@Override
	public Optional<Phong> findByMaPhongService(String maPhong) {
		// TODO Auto-generated method stub
		return phongReposi.findById(maPhong);
	}



	@Override
	public Phong findByMaPhong(String maPhong) {
		// TODO Auto-generated method stub
		return phongReposi.findByMaPhong(maPhong);
	}

}
