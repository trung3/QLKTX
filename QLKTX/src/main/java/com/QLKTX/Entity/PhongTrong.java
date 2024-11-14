package com.QLKTX.Entity;

public class PhongTrong {
private String maPhong;
private int sucChua;
private int dangO;
public PhongTrong(String maPhong,
int sucChua,
int dangO) { 
    this.maPhong = maPhong;
    this.sucChua = sucChua;
    this.dangO = dangO;
}
public String getMaPhong() {
	return maPhong;
}
public void setMaPhong(String maPhong) {
	this.maPhong = maPhong;
}
public int getSucChua() {
	return sucChua;
}
public void setSucChua(int sucChua) {
	this.sucChua = sucChua;
}
public int getDangO() {
	return dangO;
}
public void setDangO(int dangO) {
	this.dangO = dangO;
}

}
