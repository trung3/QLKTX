package com.QLKTX.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "phong")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Phong implements Serializable{

	@Id
	@Column(name = "Maphong")
	String idPhong;
	
	@Column(name = "Sophong")
	int soPhong;

	@Column(name = "Sogiuong")
	int soGiuong;
	
	@Column(name = "Giathue")
	float giaThue;
	
	@Column(name = "Matoa")
	String maToa;
	
	@Column(name = "Loaiphong")
	boolean loaiPhong;
	
	@Column(name = "Trangthai")
	boolean trangThai;
	
	@Column(name = "Succhua")
	int sucChua;
	
	@Column(name = "Dao")
	int daO ;
	
	@Column(name = "Controng")
	int conTrong;

	public String getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(String idPhong) {
		this.idPhong = idPhong;
	}

	public int getSoPhong() {
		return soPhong;
	}

	public void setSoPhong(int soPhong) {
		this.soPhong = soPhong;
	}

	public int getSoGiuong() {
		return soGiuong;
	}

	public void setSoGiuong(int soGiuong) {
		this.soGiuong = soGiuong;
	}

	public float getGiaThue() {
		return giaThue;
	}

	public void setGiaThue(float giaThue) {
		this.giaThue = giaThue;
	}

	public String getMaToa() {
		return maToa;
	}

	public void setMaToa(String maToa) {
		this.maToa = maToa;
	}

	public boolean isLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(boolean loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public int getSucChua() {
		return sucChua;
	}

	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}

	public int getDaO() {
		return daO;
	}

	public void setDaO(int daO) {
		this.daO = daO;
	}

	public int getConTrong() {
		return conTrong;
	}

	public void setConTrong(int conTrong) {
		this.conTrong = conTrong;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	
	
	
	
//	@OneToMany
//	List<Product> products;

	


//	public List<Product> getProducts() {
//		return products;
//	}
//
//	public void setProducts(List<Product> products) {
//		this.products = products;
//	}
	
	
}
