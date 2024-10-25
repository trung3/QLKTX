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
@Table(name = "phong")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Phong implements Serializable{

	@Id
	@Column(name = "maPhong")
	String idPhong;
	
	@Column(name = "soPhong")
	int soPhong;

	@Column(name = "soGiuong")
	int soGiuong;
	
	@Column(name = "giaThue")
	int giaThue;
	
	
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
