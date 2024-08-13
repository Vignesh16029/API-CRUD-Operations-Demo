package com.crud.dto;

import java.util.List;

public class ResponseProductsDTO {
	private List<ProductDTO> productDtos;
	private long totalProducts;
	
	public List<ProductDTO> getProductDtos() {
		return productDtos;
	}
	public void setProductDtos(List<ProductDTO> productDtos) {
		this.productDtos = productDtos;
	}
	public long getTotalProducts() {
		return totalProducts;
	}
	public void setTotalProducts(long totalProducts) {
		this.totalProducts = totalProducts;
	}

}
