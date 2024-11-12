package com.QLKTX.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.QLKTX.Entity.TT_ThuePhong;



public interface TT_ThuePhongRepository extends JpaRepository<TT_ThuePhong, Integer>{
	@Query("SELECT o FROM TT_ThuePhong o WHERE o.maThuePhong.maThuePhong=:maTP")
	TT_ThuePhong findByMaThue(@Param("maTP") Integer maTP);
}
