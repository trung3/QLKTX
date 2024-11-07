package com.QLKTX.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.QLKTX.Entity.Phong;



public interface PhongRepository extends JpaRepository <Phong, String> {
	@Query("SELECT o FROM Phong o WHERE o.idPhong=?1")
	Phong findByMaPhong(String maPhong);
}
