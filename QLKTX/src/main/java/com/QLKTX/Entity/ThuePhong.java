package com.QLKTX.Entity;

import java.io.Serializable;
import java.time.LocalDate;



import javax.persistence.*;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "thuephong")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThuePhong implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Mathuephong")
	int maThuePhong;
	
	@ManyToOne
	@JoinColumn(name = "Maphong")
	Phong maPhong;
	
	@ManyToOne
	@JoinColumn(name = "Masv")
	sinhvien maSV;
	
	
	
	@Column(name = "Ngaybatdau")
	LocalDate  ngayBatDau ;
	

	@Column(name = "Ngayketthuc")
	LocalDate ngayKetThuc;
	
	@Column(name = "Giathue")
	float giaThue;

	public int getMaThuePhong() {
		return maThuePhong;
	}

	public void setMaThuePhong(int maThuePhong) {
		this.maThuePhong = maThuePhong;
	}

	public Phong getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(Phong maPhong) {
		this.maPhong = maPhong;
	}

	public sinhvien getMaSV() {
		return maSV;
	}

	public void setMaSV(sinhvien maSV) {
		this.maSV = maSV;
	}


	public LocalDate getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(LocalDate ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public LocalDate getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(LocalDate ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public float getGiaThue() {
		return giaThue;
	}

	public void setGiaThue(float giaThue) {
		this.giaThue = giaThue;
	}
	
	

	
	
	
}
