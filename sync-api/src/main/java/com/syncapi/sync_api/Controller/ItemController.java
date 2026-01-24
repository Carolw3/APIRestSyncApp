package com.syncapi.sync_api.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.syncapi.sync_api.Model.Item;
import com.syncapi.sync_api.Service.ItemService;



@RestController
@RequestMapping("/api")
public class ItemController {

    // Aqui van los autowired de service
    @Autowired
    ItemService itemService;


    //Sube un nuevo item
    @PostMapping("/item")
    public ResponseEntity<String> addUser(@RequestBody Item item) throws IOException {
        int result = itemService.insertItem(item);

        if(result > 0 ){
            return ResponseEntity.status(HttpStatus.OK).body("El item ha sido creado correctamente: " + item.getTitulo().toString());
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha avido un error al insertar el item");
        }
        
    }

    //Devuelve una lista de todos los items
    @GetMapping("/items")
    public ResponseEntity<List<Item>>getItem() throws IOException {
        List<Item> llista = itemService.findAll();
        if (llista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(itemService.findAll());
        }
    
    }

    //Devuelve el item por la id
    @GetMapping("/items/{id}") // Per exemple: --> http://localhost:8081/api/items/2 <--
    public ResponseEntity<Item> getUserById(@PathVariable Long id) throws IOException {
        
        Item item = itemService.findById(id); //Busca el item por la id

        if (item != null){   //Comprueba si el titem existe
            
            return ResponseEntity.ok(item);
        }else{
        
            return ResponseEntity.badRequest().body(null); // Devuelve esto si el item es null
        }

    }

    // Endpoint para poder actualizar un item mediante la id
    @PatchMapping("/item/{id}")
    public ResponseEntity<String> updatePorId(@PathVariable long id){
        // llamada a service

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

    // Endpoint para subir una imagen, lo que guadaremos en la base de datos no es la imagen en si guardaremos una ruta donde estaran alojadas esas imagenes
    @PostMapping("/item/{id}/image")
    public String postImage(@PathVariable long id, @RequestParam MultipartFile image) {
        
        return null;
    }
    
}
