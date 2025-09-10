package com.example.imageupload.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.imageupload.model.ImageDocument;

// Hérite de MongoRepository qui fournit les méthodes CRUD de base (save, findById, delete, etc.)
// ImageDocument : le type d'objet à gérer
// String : le type de la clé primaire (id)
public interface ImageRepository extends MongoRepository<ImageDocument, String> {
}