package com.syncapi.sync_api.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.syncapi.sync_api.Log.ItemLog;
import com.syncapi.sync_api.Model.Item;
import com.syncapi.sync_api.Repository.ItemRepository;

@Service
public class ItemService {

    @Autowired
    ItemLog itemLog;

    @Autowired
    ItemRepository itemRepository;

    //Penja un nou item
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
    
    //Devuelve todos los usuarios
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

        Item item = itemRepository.findById(id);
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


    
}
