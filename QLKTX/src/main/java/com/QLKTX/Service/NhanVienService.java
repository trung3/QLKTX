package com.QLKTX.Service;

import java.util.List;
import java.util.Optional;


import com.QLKTX.Entity.NhanVien;

public interface NhanVienService  {
void add (NhanVien nv);
NhanVien update(String msnv );
Optional<NhanVien> findByMaNVService(String msnv);
List<NhanVien> findAll();
NhanVien findByName(NhanVien name);
}
