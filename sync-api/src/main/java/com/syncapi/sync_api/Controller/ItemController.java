package com.syncapi.sync_api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.syncapi.sync_api.Log.ItemLog;
import com.syncapi.sync_api.Service.ItemService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api")
public class ItemController {

    // Aqui van los autowired de service
    @Autowired 
    ItemService itemService;

    // Endpoint para poder buscar un item mediante la id
    @PatchMapping("/item/{id}")
    public ResponseEntity<String> updatePorId(@PathVariable long id){
        // llamada a servide

        // if par deolver un reponseEntity
        

        return null;
    }

    // Endpoint para borrar todos los items
    @DeleteMapping("/items")
    public ResponseEntity<String> deleteAllItems(){
        return null;
    }

    // Endpoint para borrar un item mediante la id
    @DeleteMapping("/item/{id}")
    public ResponseEntity<String> deleteOneItem(@PathVariable long id){
        return null;
    }

    // Endpoint para subir una imagen, lo que guadaremos en la base de datos no es la imagen en si guardaremos una ruta donde esi esta alojada esas imagenes
    @PostMapping("/item/{id}/image")
    public String postImage(@PathVariable long id, @RequestParam MultipartFile image) {
        
        return null;
    }
    
}
