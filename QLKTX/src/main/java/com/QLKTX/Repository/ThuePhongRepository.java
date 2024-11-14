package com.QLKTX.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.QLKTX.Entity.ThuePhong;
import com.QLKTX.Entity.sinhvien;


public interface ThuePhongRepository extends JpaRepository<ThuePhong, Integer> {
	@Query("SELECT o FROM ThuePhong o WHERE o.maPhong=?1")
	ThuePhong findByMaPhong(ThuePhong maPhong);
	@Query("SELECT o FROM ThuePhong o WHERE o.maSV=?1")
	ThuePhong findByMaSV(String maSV);
	@Query("SELECT o FROM ThuePhong o WHERE o.maThuePhong=?1")
	ThuePhong findByMaThue(Integer maSV);
	
	@Query("SELECT o FROM ThuePhong o WHERE o.maSV.idSV LIKE ?1")
	Page<ThuePhong> findByKeywords(String keywords,Pageable pgeable);
}
