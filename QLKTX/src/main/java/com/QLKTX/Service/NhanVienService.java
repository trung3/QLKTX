package com.QLKTX.Service;

import java.util.Optional;


import com.QLKTX.Entity.NhanVien;

public interface NhanVienService  {
void add (NhanVien nv);
NhanVien update(String msnv );
Optional<NhanVien> findByMaNVService(String msnv);
NhanVien findByName(NhanVien name);
}
