package com.example.imageupload.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data // Lombok : génère getters, setters, toString, etc.
@Document(collection = "images") 
public class ImageDocument {
    @Id 
    private String id;
    private String name;
    private String contentType;
    private byte[] imageData; // Stocke les données binaires de l'image
}