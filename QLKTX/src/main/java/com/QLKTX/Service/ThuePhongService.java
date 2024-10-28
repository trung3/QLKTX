package com.QLKTX.Service;

import java.util.List;
import java.util.Optional;


import com.QLKTX.Entity.ThuePhong;

public interface ThuePhongService {
	void add (ThuePhong thuePhong);
	ThuePhong update(Integer thuePhong );
	List<ThuePhong> findAllThuePhong();
	Optional<ThuePhong> findByMaThuePhongService(Integer maThue);
	ThuePhong findByMaPhong(ThuePhong maPhong);
	
}
