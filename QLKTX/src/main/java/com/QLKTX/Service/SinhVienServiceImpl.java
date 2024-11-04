package com.QLKTX.Service;

import java.util.List;
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
	public sinhvien add(sinhvien sv) {
		return SinhVienRepository.save(sv);
	}
	@Override
	public sinhvien update(String mssv) {
		sinhvien sv =  SinhVienRepository.getById(mssv);
		SinhVienRepository.save(sv);
		return sv;
		
	}
	
	@Override
	public sinhvien findBySdt(String sdt) {
		// TODO Auto-generated method stub
		return SinhVienRepository.findBySdt(sdt);
	}
	@Override
	public sinhvien findByEmail(String email) {
		// TODO Auto-generated method stub
		return SinhVienRepository.findByEmail(email);
	}
	@Override
	public Optional<sinhvien> findByMaSVService(String mssv) {
		// TODO Auto-generated method stub
		return SinhVienRepository.findById(mssv);
	}
	
	
	@Override
	public sinhvien findByEmailService(String email) {
		// TODO Auto-generated method stub
		return SinhVienRepository.findByEmail(email);
	}
	
	@Override
	public sinhvien findByMSSVAndEmailService(String id, String email) {
		// TODO Auto-generated method stub
		return SinhVienRepository.findByMSSVAndEmail(id,email);
	}
	
	@Override
	public sinhvien findByMSSVAndSdtService(String id, String sdt) {
		// TODO Auto-generated method stub
		return SinhVienRepository.findByMSSVAndSdt(id, sdt);
	}
	@Override
	public sinhvien findByName(sinhvien name) {
		// TODO Auto-generated method stub
		return SinhVienRepository.findByName(name);
	}
}
