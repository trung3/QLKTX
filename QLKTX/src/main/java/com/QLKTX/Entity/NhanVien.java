package com.QLKTX.Entity;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "nhanvien")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Manv")
	String idNV;
	
	@Length(min = 6,message = "phải từ 6 kí tự trở lên")
	@Column(name = "Matkhau")
	String matKhau;

	@Column(name = "Hoten")
	String hoTen;
	
	@Length(min = 10,max=10,message = "chưa đúng")
	@Column(name = "Sdt")
	String sdt;
	
	@Email(message = "chưa đúng định dạng")
	@Column(name = "Email")
	String email;
	
	@Column(name = "Ghichu")
	String ghiChu;
	
	@NotNull(message = "Bạn chưa chọn trạng thái")
	@Column(name = "trangThai")
	boolean trangThai;

	
	
	public String getIdNV() {
		return idNV;
	}

	public void setIdNV(String idNV) {
		this.idNV = idNV;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	

	
	
	
}
