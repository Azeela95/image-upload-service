package com.example.imageupload.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.imageupload.model.ImageDocument;
import com.example.imageupload.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import java.io.IOException;

@Service // (logique métier)
@RequiredArgsConstructor 
public class ImageService {

   
    private final ImageRepository imageRepository;

    public String uploadImage(MultipartFile file) throws IOException {
        //  Crée un nouvel objet ImageDocument
        ImageDocument image = new ImageDocument();
        image.setName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setImageData(file.getBytes()); // Lit les bytes du fichier

        // Sauvegarde l'objet en base via le Repository
        image = imageRepository.save(image);

        //  Retourne l'ID généré par MongoDB
        return image.getId();
    }
}