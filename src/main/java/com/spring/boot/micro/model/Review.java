package com.spring.boot.micro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table (name="Review")
public class Review {
	@Id
	@NotBlank(message = "User Id is mandatory")
	private int userid;
	
	@NotBlank(message = "User Name is mandatory")
	private String username;
	
	@NotBlank(message = "Comment Id is mandatory")
	private String comment;
	
	@NotBlank(message = "Rating Id is mandatory")
	private int rating;

	
	private int productid;

	@NotBlank(message = "Review Data is mandatory")
	private String data;
	
	public Review()
	{
		
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@ManyToOne
    @JoinColumn(name = "productid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	


	
	
}
