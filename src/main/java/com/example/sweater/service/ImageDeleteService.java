package com.example.sweater.service;

import com.example.sweater.domain.Front;
import com.example.sweater.domain.Module;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ImageDeleteService {
    @Value("${upload.path}")
    private String uploadPath;

    public void deleteFrontImages(Front front){
        if (front.getFilename() != null){
            try {
                Files.delete(Paths.get(uploadPath + "/" + front.getFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void deleteModuleImage(Module module){
        if (module.isImage() && module.getFilename() != null ){
            try {
                Files.delete(Paths.get(uploadPath + "/" + module.getFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void deleteModuleImages(List<Module> modules) {
        for (Module iterator : modules){
            if (iterator.isImage() && iterator.getFilename() != null ){
                try {
                    Files.delete(Paths.get(uploadPath + "/" + iterator.getFilename()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
