package com.QLKTX.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.QLKTX.Entity.sinhvien;


public interface SinhVienRepository extends JpaRepository<sinhvien, String> {
	@Query("SELECT o FROM users o WHERE o.Hoten=?1")
	sinhvien findByName(sinhvien name);
}
