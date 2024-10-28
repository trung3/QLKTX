package com.QLKTX.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.QLKTX.Entity.NhanVien;


public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
	@Query("SELECT o FROM NhanVien o WHERE o.hoTen=?1")
	NhanVien findByName(NhanVien name);
}
