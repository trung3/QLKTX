package com.QLKTX.Service;

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
	public void add(NhanVien nv) {
		NhanVienRepo.save(nv);
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
}
