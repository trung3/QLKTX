package com.QLKTX.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.QLKTX.Entity.sinhvien;


public interface SinhVienRepository extends JpaRepository<sinhvien, String> {
	@Query("SELECT o FROM sinhvien o WHERE o.nameSV=?1")
	sinhvien findByName(sinhvien name);
	@Query("SELECT o FROM sinhvien o WHERE o.email=?1")
	sinhvien findByEmail(String email);
	@Query("SELECT o FROM sinhvien o WHERE o.sdtSV=?1")
	sinhvien findBySdt(String sdt);
}
