package com.spring.boot.micro.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.spring.boot.micro.model.Product;
import com.spring.boot.micro.model.Review;
import com.spring.boot.micro.repository.ProductRepository;
import com.spring.boot.micro.repository.ReviewRepository;



@Controller
public class MainController {
	@Autowired 
	private ProductRepository productRepository;

	@Autowired 
	private ReviewRepository reviewRepository;
	
//	private static int productId;
//	public static int getProductId()
//	{
//		return productId;
//	}
//	private static String ProductName;
//	public String getProductName()
//	{
//		return ProductName;
//	}
	
	@RequestMapping ("/")
	public String home(@Valid Product product, Review review, BindingResult result, Model m)
	{
        m.addAttribute("products", productRepository.findAll());
        m.addAttribute("reviews", reviewRepository.findAll());
		return "index";
	}
	@GetMapping("/product")
	public String product (Product product)
	{
		return "add-product";
	}
	
	@GetMapping("/review")
	public String review (Review review)
	{
		return "add-review";
	}
	
	
	//add the product
	@PostMapping("/add")
    public String add(@Valid Product product, BindingResult result, Model m) {
        if (result.hasErrors()) {
            return "add-product";
        }

        productRepository.save(product);
        m.addAttribute("products", productRepository.findAll());
        m.addAttribute("reviews", reviewRepository.findAll());
        return "index";
    }
	
	//add the review
	@PostMapping("/add2")
    public String add2(@Valid Review review, BindingResult result, Model m) {
        if (result.hasErrors()) {
            return "add-review";
        }

        reviewRepository.save(review);
        
        m.addAttribute("products", productRepository.findAll());
        m.addAttribute("reviews", reviewRepository.findAll());
        return "index";
    }
	

	
	//edit the product
	@GetMapping("/edit/{productid}")
	public String edit(@PathVariable("productid") int productid, Model model) {
	    Product product = productRepository.findById(productid)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid Product ID:" + productid));

	    model.addAttribute("product", product);
	    return "edit";
	}

	//update the product
	@PostMapping("/update/{productid}")
	public String update(@PathVariable("productid") int productid, @Valid Product product,
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	product.setProductid(productid);
	        return "edit";
	    }

	    productRepository.save(product);
	    model.addAttribute("products", productRepository.findAll());
	    model.addAttribute("reviews", reviewRepository.findAll());
	    return "index";
	}
	
	//edit the review
	@GetMapping("/edit2/{userid}")
	public String edit2(@PathVariable("userid") int userid, Model model) {
	    Review review = reviewRepository.findById(userid)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid User ID:" + userid));

	    model.addAttribute("review", review);
	    return "edit2";
	}

	//update the review
	@PostMapping("/update2/{userid}")
	public String update2(@PathVariable("userid") int userid, @Valid Review review,
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	review.setUserid(userid);
	        return "edit2";
	    }

	    reviewRepository.save(review);
	    model.addAttribute("products", productRepository.findAll());
	    model.addAttribute("reviews", reviewRepository.findAll());
	    return "index";
	}
	
	
	
	
	//delete a product
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int productid, Model model) {
	    Product product= productRepository.findById(productid)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid Product ID:" + productid));
	    productRepository.delete(product);
	    model.addAttribute("products", productRepository.findAll());
	    model.addAttribute("reviews", reviewRepository.findAll());
	    return "index";
	}
	
	//delete a review info
	@GetMapping("/delete2/{userid}")
	public String delete2 (@PathVariable("userid") int userId, Model model) {
	    Review review = reviewRepository.findById(userId)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid User ID:" + userId));
	    reviewRepository.delete(review);
	    model.addAttribute("products", productRepository.findAll());
	    model.addAttribute("reviews", reviewRepository.findAll());
	    return "index";
	}

}
