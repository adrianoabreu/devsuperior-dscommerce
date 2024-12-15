package com.devsuperior.dscommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly =  true)
	public ProductDTO findById(Long id) {
//      Este trecho de codigo é somente uma maneira mais didatica de retornar DTO
//		Optional<Product> result = repository.findById(id);
//		Product product = result.get();
//		ProductDTO dto = new ProductDTO(product);
//		return dto;
		
//		Este trecho de codigo é a maneira mais avançada em retornar um DTO
		Product product = repository.findById(id).get();
		return new ProductDTO(product);		
	}
	
	@Transactional(readOnly =  true)
//	public List<ProductDTO> findAll() {
	public Page<ProductDTO> findAll(Pageable pageable) {
//		List<Product> result = repository.findAll();
		Page<Product> result = repository.findAll(pageable);
		return result.map(x -> new ProductDTO(x));
	}
	
	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		
		Product entity = new Product();
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setPrice(dto.getPrice());
		entity.setImgUrl(dto.getImgUrl());
		
		entity = repository.save(entity);
		
		return new ProductDTO(entity);		
	}
}
