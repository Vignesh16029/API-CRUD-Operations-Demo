package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crud.dto.ProductDTO;
import com.crud.dto.ResponseProductsDTO;
import com.crud.dto.UpdateProductDTO;
import com.crud.model.Product;

@Service
public interface ProductService {
	
	public Product createProduct(ProductDTO productDTO);
	public ResponseProductsDTO getAllProducts();
	public ProductDTO getProductnyId(Integer id);
	public Product updateProduct(int id, String productName);
	public String deleteProductbyid(int id, String productName);
	
	

	
}
