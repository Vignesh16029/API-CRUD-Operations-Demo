package com.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dto.ProductDTO;
import com.crud.dto.ResponseProductsDTO;
import com.crud.dto.UpdateProductDTO;
import com.crud.model.Product;
import com.crud.repository.ProductRepository;

@Service
public class ProductServiceImplementation implements ProductService {

	//Adding a single Product
	@Autowired
	private ProductRepository productRepository;
	@Override
	public Product createProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setProductName(productDTO.getProductName());
		product.setPrice(productDTO.getPrice());
		product.setQuantity(productDTO.getQuantity());
		product.setManufacturingDate(productDTO.getManufacturingDate());
		return productRepository.save(product);
	}

	//Fetching Product by Id
	@Override
	public ProductDTO getProductnyId(Integer id) {
		ProductDTO productDTO = new ProductDTO();
		Product product=productRepository.findById(id).orElse(null);
		if(product!=null) {
			//productDTO.setProductId(product.getProductId());
			productDTO.setProductName(product.getProductName());
			productDTO.setPrice(product.getPrice());
			//productDTO.setQuantity(product.getQuantity());
			productDTO.setManufacturingDate(product.getManufacturingDate());
		}
		
		return productDTO;
	}


	//Fetching all products
	@Override
	public ResponseProductsDTO getAllProducts() {
		ResponseProductsDTO responseProductsDTO= new ResponseProductsDTO();
		List<ProductDTO> productDTOs=new ArrayList<ProductDTO>();
		List<Product> products = productRepository.findAll();
		for(Product p:products) {
			ProductDTO productDTO=new ProductDTO();
			productDTO.setProductId(p.getProductId());
			productDTO.setProductName(p.getProductName());
			productDTO.setPrice(p.getPrice());
			productDTO.setQuantity(p.getQuantity());
			productDTO.setManufacturingDate(p.getManufacturingDate());
			productDTOs.add(productDTO);
		}
		responseProductsDTO.setProductDtos(productDTOs);
		responseProductsDTO.setTotalProducts(productRepository.count());
		return responseProductsDTO;
	}

	//update a product detail
	@Override
	public Product updateProduct(int id, String productName) {
		Product p = productRepository.findById(id).orElse(null);
		if(p!=null) {
			p.setProductName(productName);
		}
		
		return productRepository.save(p);
	}

	//Delete a Product
	@Override
	public String deleteProductbyid(int id, String productName) {
		Product d = productRepository.findById(id).orElse(null);
		if(productRepository.existsById(id)) {
			productRepository.deleteById(id);
		}
		return "Deleted Sucessfully";
	}
}

	
