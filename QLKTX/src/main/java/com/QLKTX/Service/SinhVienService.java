package com.QLKTX.Service;

import java.util.List;
import java.util.Optional;


import com.QLKTX.Entity.sinhvien;

public interface SinhVienService  {
sinhvien add (sinhvien sv);
sinhvien update(String mssv );
Optional<sinhvien> findByMaSVService(String mssv);
sinhvien findByName(sinhvien name);
sinhvien findByEmail(String email);
sinhvien findBySdt(String sdt);
}
