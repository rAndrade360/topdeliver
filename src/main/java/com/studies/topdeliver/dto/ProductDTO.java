package com.studies.topdeliver.dto;

import com.studies.topdeliver.entities.Product;

public class ProductDTO {

    private Long id;
    private String name;
    private Double price;
    private String description;
    private String imageUri;

    public ProductDTO(){
    }

    public ProductDTO(Long id, String name, double price, String description, String imageUri) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUri = imageUri;
    }

    public ProductDTO(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.imageUri = product.getImageUri();
    }



}
