package com.QLKTX.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.QLKTX.Entity.sinhvien;
import com.QLKTX.Repository.SinhVienRepository;

@Service
@Transactional
public class SinhVienServiceImpl implements SinhVienService {
	@Autowired 
	SinhVienRepository SinhVienRepository;
	@Override
	public void add(sinhvien sv) {
		SinhVienRepository.save(sv);
	}
	@Override
	public sinhvien update(String mssv) {
		sinhvien sv =  SinhVienRepository.getById(mssv);
		SinhVienRepository.save(sv);
		return sv;
		
	}
	
	@Override
	public Optional<sinhvien> findByMaSVService(String mssv) {
		// TODO Auto-generated method stub
		return SinhVienRepository.findById(mssv);
	}
	@Override
	public sinhvien findByName(sinhvien name) {
		// TODO Auto-generated method stub
		return SinhVienRepository.findByName(name);
	}
}
