package com.QLKTX.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QLKTX.Entity.TT_ThuePhong;
import com.QLKTX.Repository.TT_ThuePhongRepository;
@Service
@Transactional
public class TT_ThuePhongServiceImpl implements TT_ThuePhongService  {
	@Autowired 
	TT_ThuePhongRepository ttRepo;
	@Override
	public void add(TT_ThuePhong tt) {
		
		ttRepo.save(tt);
	}
	@Override
	public Optional<TT_ThuePhong> findByMaTTThuePhongService(Integer maThue) {
		// TODO Auto-generated method stub
		return ttRepo.findById(maThue);
	}
	@Override
	public TT_ThuePhong findByMaThuePhongService(Integer maThue) {
		// TODO Auto-generated method stub
		return ttRepo.findByMaThue(maThue);
	}


}
