package com.studies.topdeliver.services;

import com.studies.topdeliver.dto.ProductDTO;
import com.studies.topdeliver.entities.Product;
import com.studies.topdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional
    public List<ProductDTO> findAll(){
        List<Product> products = repository.findAll();
        return products.stream().map((x) -> new ProductDTO(x)).collect(Collectors.toList());
    }
}
