package com.QLKTX.Service;

import java.util.Optional;

import com.QLKTX.Entity.TT_ThuePhong;


public interface TT_ThuePhongService {
void add (TT_ThuePhong tt);
Optional<TT_ThuePhong> findByMaTTThuePhongService(Integer maThue);
TT_ThuePhong findByMaThuePhongService(Integer maThue);

}
