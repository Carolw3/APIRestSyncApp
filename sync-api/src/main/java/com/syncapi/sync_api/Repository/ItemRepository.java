package com.syncapi.sync_api.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

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
            item.setIdUser(rs.getLong("idUser"));
            item.setTitulo(rs.getString("titulo"));
            item.setDescription(rs.getString("description"));
            item.setPuntuacion(rs.getInt("puntuacion"));
            item.setFavoritos(rs.getBoolean("favoritos"));
            item.setImagen_doc(rs.getString("imagen_doc"));
            item.setImagen_per(rs.getString("imagen_per"));
            item.setCategoria(rs.getString("categoria"));
            
            return item;
        }
        
    }

    //Inserta un nou item a la base de dades
    public int insertItem(Item item){
        String sql = """
                INSERT INTO items(idUser, titulo, description, puntuacion, favoritos, categoria, onCreated, onUpdate) VALUES (?,?,?,?,?,?,?,?);
                """;

        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        return jdbcTemplate.update(sql,
            item.getIdUser(),
            item.getTitulo(),
            item.getDescription(),
            item.getPuntuacion(),
            item.isFavoritos(),
            item.getCategoria(),
            timestamp,
            timestamp
    
        );
    }

    //Devuelve un item segun el id
    public List<Item> findById(Long id){
        String sql = "SELECT * FROM items WHERE id = ?";
        try {
            return jdbcTemplate.query(sql, new ItemRowMapper(), id);
        } catch (Exception e) {
            return null;
        }
        
    }

    //Devuelve una lista con todos los items
    public List<Item> findAll(){
        String sql = "SELECT * FROM items";
        return jdbcTemplate.query(sql, new ItemRowMapper());
    }

    public int uploadImage(long id, String pathruta){
        String sql = "UPDATE items SET imagen_doc = ? WHERE id=?";
        return jdbcTemplate.update(sql, pathruta, id);
    }

    // Capa para borrar todos los items
    public int deleteAllItems(){
        String sql = "DELETE FROM items";
        return jdbcTemplate.update(sql);
    }

    // Capa para borrar un item mediante un id
    public int deleteItemPerId(Long id){
        String sql = "DELETE FROM items WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updatePerIdTitulo(Long id, String titulo){
        String sql = "UPDATE items SET titulo = ? WHERE id = ?";
        return jdbcTemplate.update(sql, titulo, id);
    }

    public int updatePerIdDescripcion(Long id , String description){
        String sql = "UPDATE items SET description = ? WHERE id = ?";
        return jdbcTemplate.update(sql, description, id);
    }

    public List<Item> ordenAlfa(){
        String sql = "SELECT * FROM items ORDER BY titulo ASC";
        return jdbcTemplate.query(sql, new ItemRowMapper());
    }

}
