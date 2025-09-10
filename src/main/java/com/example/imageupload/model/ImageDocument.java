package com.example.imageupload.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data // Lombok : génère getters, setters, toString, etc.
@Document(collection = "images") // Dit à Spring que cette classe est un document MongoDB
public class ImageDocument {
    @Id // Marque ce champ comme l'identifiant unique MongoDB
    private String id;
    private String name;
    private String contentType;
    private byte[] imageData; // Stocke les données binaires de l'image
}