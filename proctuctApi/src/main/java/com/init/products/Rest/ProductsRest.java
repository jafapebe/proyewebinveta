package com.init.products.Rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.init.products.daos.ProductDaos;
import com.init.products.entitys.Product;


@RestController
@RequestMapping("products")
public class ProductsRest {
	
	@Autowired
	private ProductDaos productDaos;
	
	@GetMapping
	public ResponseEntity<List<Product>> getProduct(){
		
		List<Product> Products = productDaos.findAll();
		
		return ResponseEntity.ok(Products);
	}
	

	@RequestMapping(value="{productId}", method=RequestMethod.GET)
	public ResponseEntity<Product> getProductId(@PathVariable("productId") Long productId){
		
		Optional<Product> OptionalProduct = productDaos.findById(productId);
		
		if(OptionalProduct.isPresent()) {
			return ResponseEntity.ok(OptionalProduct.get());
		}else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Product> crearProduct(@RequestBody Product product){
		
		Product newproduct = productDaos.save(product);
		
		return ResponseEntity.ok(newproduct);
	}
	
	
	
	@DeleteMapping(value="{productId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId){
		
		productDaos.deleteById(productId);
		
		return ResponseEntity.ok(null);
	}

	
	@PutMapping
	public ResponseEntity<Product> UpdateProduct(@RequestBody Product product){
	
		Optional<Product> OptionalProduct = productDaos.findById(product.getId());
		
		if(OptionalProduct.isPresent()) {
			
			Product updateproduct =  OptionalProduct.get();
			
			updateproduct.setName(product.getName());
			updateproduct.setCatId(product.getCatId());
			updateproduct.setPrecio(product.getPrecio());
			updateproduct.setExistencia(product.getExistencia());
			updateproduct.setProveId(product.getProveId());
			productDaos.save(updateproduct);
			
			return ResponseEntity.ok(updateproduct);
			
		}else {
			
			return ResponseEntity.notFound().build();
			
		}
	}
	
}
