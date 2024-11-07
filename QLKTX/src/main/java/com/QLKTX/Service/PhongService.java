package com.QLKTX.Service;


import java.util.Optional;


import com.QLKTX.Entity.Phong;

public interface PhongService {
	Optional<Phong> findByMaPhongService(String maPhong);
	Phong findByMaPhong(String maPhong);
}
