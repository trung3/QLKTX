package com.QLKTX.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.QLKTX.Entity.lop;
import com.QLKTX.Repository.LopRepository;

public class LopServiceImpl implements LopService {
	@Autowired
	LopRepository lopRepo;

	@Override
	public List<lop> findAllLop() {
		return lopRepo.findAll();
	}

}
