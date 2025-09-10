package com.example.imageupload.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.imageupload.model.ImageDocument;
import com.example.imageupload.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import java.io.IOException;

@Service // Marque cette classe comme un Service Spring (logique métier)
@RequiredArgsConstructor // Lombok : génère un constructeur avec les arguments "final"
public class ImageService {

    // Spring injecte automatiquement le Repository ici
    private final ImageRepository imageRepository;

    public String uploadImage(MultipartFile file) throws IOException {
        // 1. Crée un nouvel objet ImageDocument
        ImageDocument image = new ImageDocument();
        image.setName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setImageData(file.getBytes()); // Lit les bytes du fichier

        // 2. Sauvegarde l'objet en base via le Repository. La méthode .save() est fournie par MongoRepository
        image = imageRepository.save(image);

        // 3. Retourne l'ID généré par MongoDB
        return image.getId();
    }
}