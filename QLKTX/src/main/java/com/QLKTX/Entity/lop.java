package com.QLKTX.Entity;

import java.io.Serializable;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="lop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class lop  implements Serializable{

	@Id
	@Column(name = "Malop")
	String maLop;
	
	@Column(name = "Tenlop")
	String nameLop;

	public String getMaLop() {
		return maLop;
	}

	public String getNameLop() {
		return nameLop;
	}

	public void setNameLop(String nameLop) {
		this.nameLop = nameLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
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
