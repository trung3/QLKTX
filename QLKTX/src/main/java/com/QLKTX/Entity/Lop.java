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
@Table(name = "lop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lop implements Serializable{

	@Id
	@Column(name = "maLop")
	int idLop;
	
	@Column(name = "tenLop")
	String nameLop;

	public int getIdLop() {
		return idLop;
	}

	public void setIdLop(int idLop) {
		this.idLop = idLop;
	}

	public String getNameLop() {
		return nameLop;
	}

	public void setNameLop(String nameLop) {
		this.nameLop = nameLop;
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
