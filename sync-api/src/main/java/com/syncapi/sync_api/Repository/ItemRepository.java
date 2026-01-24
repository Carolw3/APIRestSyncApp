package com.syncapi.sync_api.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.syncapi.sync_api.Log.ItemLog;
import com.syncapi.sync_api.Model.Item;

@Repository

public class ItemRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ItemLog itemLog;

    private static final class ItemRowMapper implements RowMapper<Item>{

        @Override
        public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
            Item item = new Item();
            item.setId(rs.getLong("id"));
            item.setTitulo(rs.getString("name"));
            item.setDescription(rs.getString("description"));
            item.setPuntuacion(rs.getInt("puntuacion"));
            item.setFavoritos(rs.getBoolean("favoritos"));
            item.setImagen_doc(rs.getString("imagen_doc"));
            item.setImagen_per(rs.getString("imagen_per"));
            item.setCategoria(rs.getString("categoria"));

            return item;
        }
        
    }

    

}
