package com.QLKTX.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.QLKTX.Entity.NhanVien;
import com.QLKTX.Repository.NhanVienRepository;

@Service
@Transactional
public class NhanVienServiceImpl implements NhanVienService {
	@Autowired 
	NhanVienRepository NhanVienRepo;

	@Override
	public NhanVien add(NhanVien nv) {
		return NhanVienRepo.save(nv);
	}
	@Override
	public NhanVien update(String msnv) {
		NhanVien nv =  NhanVienRepo.getById(msnv);
		NhanVienRepo.save(nv);
		return nv;
		
	}
	@Override
	public Optional<NhanVien> findByMaNVService(String msnv) {
		return NhanVienRepo.findById(msnv);
	}
	@Override
	public NhanVien findByName(NhanVien name) {
		return NhanVienRepo.findByName(name);
	}
	@Override
	public List<NhanVien> findAll() {
	
		return NhanVienRepo.findAll();
	}
	@Override
	public NhanVien findByEmail(String email) {
		// TODO Auto-generated method stub
		return NhanVienRepo.findByEmail(email);
	}
	@Override
	public NhanVien findBySdt(String sdt) {
		// TODO Auto-generated method stub
		return NhanVienRepo.findBySdt(sdt);
	}
}
