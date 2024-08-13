package com.crud.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.dto.ProductDTO;
import com.crud.dto.ResponseProductsDTO;
import com.crud.dto.UpdateProductDTO;
import com.crud.model.Product;
import com.crud.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	//Adding a Product
	@PostMapping("/create/product")
	public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO){
		Product product2 = productService.createProduct(productDTO);
		return new ResponseEntity<>("Data Saved Sucessfully",HttpStatus.CREATED);
		
	}
	//Display All Products
	@GetMapping("/show/products")
	public ResponseEntity<ResponseProductsDTO> getAllProducts(){
		ResponseProductsDTO responseProductsDTO =productService.getAllProducts();
		return new ResponseEntity<>(responseProductsDTO,HttpStatus.OK);
	}
	//Display Product by ID
	@GetMapping("/show/products/{id}")
	public ResponseEntity<ProductDTO> getProductbyId(@PathVariable Integer id){
		ProductDTO productDTO=productService.getProductnyId(id);
		return new ResponseEntity<>(productDTO,HttpStatus.OK);
	}
	//Update Product
	@PutMapping("/update/{id}/productName")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody String productName){
		Product updatedProduct =productService.updateProduct(id, productName);		
		return new ResponseEntity<>("Data Updated Sucessfully",HttpStatus.ACCEPTED);
    }
	//Delete Product
	@DeleteMapping("/delete/{id}/productName")
	public ResponseEntity<String> deleteProductid (@PathVariable int id, @RequestBody String productName){
		String deletedProduct = productService.deleteProductbyid(id, productName);
		return new ResponseEntity<>("Data Deleted SUcessfully", HttpStatus.OK);
		
	}

}