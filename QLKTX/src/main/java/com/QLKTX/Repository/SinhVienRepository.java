package com.QLKTX.Repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.QLKTX.Entity.sinhvien;


public interface SinhVienRepository extends JpaRepository<sinhvien, String> {
	@Query("SELECT o FROM sinhvien o WHERE o.idSV LIKE ?1")
	Page<sinhvien> findByKeywords(String keywords,Pageable pgeable);
	
	@Query("SELECT o FROM sinhvien o WHERE o.email=?1")
	sinhvien findByEmail(String email);
	
	@Query("SELECT o FROM sinhvien o WHERE o.nameSV=?1 AND o.email=?2")
	sinhvien findByMSSVAndEmail(String id,String email);
	
	@Query("SELECT o FROM sinhvien o WHERE o.sdtSV=?1")
	sinhvien findBySdt(String sdt);
	
	@Query("SELECT o FROM sinhvien o WHERE o.nameSV=?1 AND o.sdtSV=?2")
	sinhvien findByMSSVAndSdt(String id,String sdt);
	
	@Query("SELECT o FROM sinhvien o WHERE o.idSV=?1")
	sinhvien findByMaSV(String SV);
}
