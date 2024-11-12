package com.QLKTX.Service;

import java.util.List;
import java.util.Optional;


import com.QLKTX.Entity.ThuePhong;

public interface ThuePhongService {
	void add (ThuePhong thuePhong);
	ThuePhong update(Integer thuePhong );
	List<ThuePhong> findAllThuePhong();
	Optional<ThuePhong> findByMaThuePhongService(Integer maThue);
	Optional<ThuePhong> findByMaSVService(String maSV);
	ThuePhong findByMaPhong(ThuePhong maPhong);
	ThuePhong findByMaSV(String maSV);
	ThuePhong findByMThue(Integer ma);
}
