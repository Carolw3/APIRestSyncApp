package com.syncapi.sync_api.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.syncapi.sync_api.Log.ItemLog;
import com.syncapi.sync_api.Model.Item;
import com.syncapi.sync_api.Repository.ItemRepository;

@Service
public class ItemService {

    @Autowired
    ItemLog itemLog;

    @Autowired
    ItemRepository itemRepository;
    //Sube un nuevo item
    public int insertItem(Item item) throws IOException {

        itemLog.info(
                "ItemService",
                "insertItem",
                "Creant un item.");

        int result = itemRepository.insertItem(item);
        if(result < 1){
            itemLog.error(
                "ItemService",
                "insertItem",
                "El item con el titulo: " + item.getTitulo() + ", no se a ingresado correctamente. Mensaje de "+ ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor"));
        }else{
            itemLog.info(
                "ItemService",
                "insertItem",
                "Usuari creat correctament" );
        }
        return result;
    }
    
    //Devuelve todos los items
    public List<Item>findAll() throws IOException {
        List<Item> llista = itemRepository.findAll();

        if(llista.size() < 1){
            itemLog.error(
                "ItemService",
                "findAll",
                "No hay items registrados");
        }else{
            itemLog.info(
                "ItemService",
                "findAll",
                "Consultando todos los items." );
        }

        return llista;
    }

    //Busca el item por la id
    public Item findById(Long id) throws IOException {

        List<Item> items = itemRepository.findById(id);
        Item item = items.get(0);
        if(item == null){
            itemLog.error(
                "ItemService",
                "findById",
                "el item con id " + id + " no existe.");
        }else{
            itemLog.info(
                "ItemService",
                "findById",
                "Consultando el item con id: " + id );
        }

        return item;
    }

    // capa de service para actualizar un item mediante una id
    public int updatePerId(Long id) throws IOException{

        itemLog.info("ItemService", "UpdatePerId", "Actualizando item por id " + id);
        return 1;
    }

    // capa de servie para poder borrar todos los elementos de item
    public int deleteAllItems(){

        return 1;
    }

    // Capa de service para poder borrar un item mediante un id que nos pase el Controller
    public int deleteOneItem(Long id){
        return 1;
    }
    
    //Para subir la ruta de una imagen
    public String uploadImage(long item_id, MultipartFile imageFile) throws IOException {
        List<Item> item = itemRepository.findById(item_id);
        itemLog.info("ItemService", "uploadImage", "Afegint la imatge " + imageFile.getName() + " per el item con la id: " + item_id);
        if (item.isEmpty()) {
            itemLog.error("ItemService", "uploadImage", "Item amb id " + item_id + " no existeix");
            return null;
        }
        try{
            // creamos el path donde queremos que cree la carpeta
            Path imageDir = Paths.get("private/images");
            // Comprobamos que exista
            if (!Files.exists(imageDir)) {
                Files.createDirectories(imageDir);
            }
            // Creamos un nombre distinto para cada imagen
            String filename = "item_" + item_id + "_" + imageFile.getOriginalFilename();
            Path destination = imageDir.resolve(filename);
            // hacemos el nio2 el inputstream es para recuperar el binario de la imagen
            InputStream inputStream = imageFile.getInputStream();
            
            Files.copy(inputStream, destination, StandardCopyOption.REPLACE_EXISTING);
            
            // creamos una ruta relativa para guardar en la base de datos
            String relativePath = "images/" + filename;
            itemRepository.uploadImage(item_id, relativePath);

            itemLog.info("ItemService", "uploadImage", "La imatge s'ha guardat correctament. El path és: /private/" + relativePath);
            return "/private/" + relativePath;
        } catch(Exception e){
            e.printStackTrace();
    }
        return null;
    }

}
