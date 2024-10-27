package com.QLKTX.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tt_thuephong")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TT_ThuePhong implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Mattthuephong")
	int maTTThuePhong;
	
	@ManyToOne
	@JoinColumn(name = "Mathuephong")
	ThuePhong maThuePhong;
	
	@ManyToOne
	@JoinColumn(name = "Manv")
	NhanVien maNV;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Thangnam")
	Date thangNam = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Ngaythanhtoan")
	Date ngayThanhToan = new Date();
	
	@Column(name = "Giathue")
	float giaThue;
	
	@Column(name = "Thanhtoan")
	boolean thanhToan;
	
	@Column(name = "Trangthai")
	boolean  trangThai;

	public int getMaTTThuePhong() {
		return maTTThuePhong;
	}

	public void setMaTTThuePhong(int maTTThuePhong) {
		this.maTTThuePhong = maTTThuePhong;
	}

	public ThuePhong getMaThuePhong() {
		return maThuePhong;
	}

	public void setMaThuePhong(ThuePhong maThuePhong) {
		this.maThuePhong = maThuePhong;
	}

	public NhanVien getMaNV() {
		return maNV;
	}

	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}

	public Date getThangNam() {
		return thangNam;
	}

	public void setThangNam(Date thangNam) {
		this.thangNam = thangNam;
	}

	public Date getNgayThanhToan() {
		return ngayThanhToan;
	}

	public void setNgayThanhToan(Date ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}

	public float getGiaThue() {
		return giaThue;
	}

	public void setGiaThue(float giaThue) {
		this.giaThue = giaThue;
	}

	public boolean isThanhToan() {
		return thanhToan;
	}

	public void setThanhToan(boolean thanhToan) {
		this.thanhToan = thanhToan;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	
	

	
	
	
}
