package com.gemy.spring.ProductApp.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gemy.spring.ProductApp.ExternalModels.Voucher;
import com.gemy.spring.ProductApp.Model.Product;
import com.gemy.spring.ProductApp.Repos.ProductRepo;



@RestController
@RequestMapping("/productapi")
public class ProductController {

	
	@Autowired
	ProductRepo repo ; 
	
	
	@Autowired
	RestTemplate restTemplate ; 
	
	
	@Value("${voucherService.url}")
	private String voucherServiceURL ; 
	
	
	
	
	
	
	@PostMapping("/products")
	public Product Create(@RequestBody Product product) {
		Voucher voucher =restTemplate.getForObject(voucherServiceURL + product.getVoucherCode(), Voucher.class);
		product.setPrice(product.getPrice().subtract(voucher.getDiscount()));
		return repo.save(product);
	}
	
	
	
	
	
	/*
	 * @GetMapping("/products/{code}") public Product getVoucher(@PathVariable("id")
	 * long id) { return repo.findById(id); }
	 */
	
	
}
