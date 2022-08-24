package com.spring.boot.micro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Product")
public class Product {

	private int productid;
	
	@NotBlank(message = "Product Name is mandatory")
	private String productname;
	
	@NotBlank(message = "Price is mandatory")
	private double price;
	
	@NotBlank(message = "Quantity is mandatory")
	private int quantity;
	
	@NotBlank(message = "Location is mandatory")
	private String location;
	
	public Product()
	{
		
	}

	@Id
	@Column (name="productid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	

}
