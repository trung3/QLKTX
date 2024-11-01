package com.QLKTX.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.QLKTX.Entity.ThuePhong;


public interface ThuePhongRepository extends JpaRepository<ThuePhong, Integer> {
	@Query("SELECT o FROM ThuePhong o WHERE o.maPhong=?1")
	ThuePhong findByMaPhong(ThuePhong maPhong);
}