package com.QLKTX.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sinhvien",schema="qlktx")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class sinhvien implements Serializable{

	@Id
	@Column(name = "Masv")
	int idSV;
	
	@Column(name = "Hoten")
	String nameSV;

	@Column(name = "Sdt")
	String sdtSV;
	
	@ManyToOne
	@JoinColumn(name = "Malop")
	lop maLop;
	
	@Column(name = "Email")
	String email;
	
	@Column(name = "GioiTinh")
	boolean gioiTinh;

	public int getIdSV() {
		return idSV;
	}

	public void setIdSV(int idSV) {
		this.idSV = idSV;
	}

	public String getNameSV() {
		return nameSV;
	}

	public void setNameSV(String nameSV) {
		this.nameSV = nameSV;
	}

	public String getSdtSV() {
		return sdtSV;
	}

	public void setSdtSV(String sdtSV) {
		this.sdtSV = sdtSV;
	}



	public lop getMaLop() {
		return maLop;
	}

	public void setMaLop(lop maLop) {
		this.maLop = maLop;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	

	
	
}
