package com.QLKTX.Service;

import java.util.Optional;


import com.QLKTX.Entity.sinhvien;

public interface SinhVienService  {
void add (sinhvien sv);
sinhvien update(String mssv );
Optional<sinhvien> findByMaSVService(String mssv);
sinhvien findByName(sinhvien name);
sinhvien findByEmail(String email);
sinhvien findBySdt(String sdt);
}
