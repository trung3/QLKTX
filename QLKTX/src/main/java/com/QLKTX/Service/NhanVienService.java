package com.QLKTX.Service;

import java.util.List;
import java.util.Optional;



import com.QLKTX.Entity.NhanVien;

public interface NhanVienService   {
NhanVien add (NhanVien nv);
NhanVien update(String msnv );
Optional<NhanVien> findByMaNVService(String msnv);
List<NhanVien> findAll();
NhanVien findByName(NhanVien name);
NhanVien findByEmail(String email);
NhanVien findBySdt(String sdt);
NhanVien findByMaNV(String NV);
}
