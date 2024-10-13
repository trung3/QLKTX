package com.QLKTX.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sinhvien")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SinhVien implements Serializable{

	@Id
	@Column(name = "maSV")
	int idSV;
	
	@Column(name = "hoten")
	String nameSV;

	@Column(name = "sdt")
	String sdtSV;
	
	@ManyToOne
	@Column(name = "maLop")
	String idLop;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "gioiTinh")
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

	public String getIdLop() {
		return idLop;
	}

	public void setIdLop(String idLop) {
		this.idLop = idLop;
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
