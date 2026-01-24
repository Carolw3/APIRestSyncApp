package com.syncapi.sync_api.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syncapi.sync_api.Log.ItemLog;

@Service
public class ItemService {

    @Autowired
    ItemLog itemLog;

    //@Autowired
    //ItemRespository ItemRespository;

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
