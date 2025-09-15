package com.example.imageupload.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.imageupload.service.ImageService;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService imageService;

    // Constructeur explicite (pas de Lombok)
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    // Page d'accueil
    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok(
                "Bienvenue sur Image Upload Service !\n"
                + "Utilisez POST /api/images/upload pour uploader des images.\n"
                + "Pour voir la liste des images, implémentez GET /api/images/list plus tard."
        );
    }

    // Endpoint pour uploader une image
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String imageId = imageService.uploadImage(file);
            return ResponseEntity.ok("✅ Image uploadée avec succès ! ID: " + imageId);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("❌ Échec de l'upload : " + e.getMessage());
        }
    }

    /*
    // Endpoint pour lister les images (à implémenter plus tard)
    @GetMapping("/list")
    public ResponseEntity<List<String>> listImages() {
        try {
            List<String> images = imageService.listImages();
            return ResponseEntity.ok(images);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
     */
}
