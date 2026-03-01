package com.syncapi.sync_api.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.syncapi.sync_api.DTO.ItemPerfilResponseDTO;
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

    private static final class ItemPerfilResponseDTORowMapper implements RowMapper<ItemPerfilResponseDTO>{
        @Override
        public ItemPerfilResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            ItemPerfilResponseDTO itemPerfil = new ItemPerfilResponseDTO();
            itemPerfil.setId(rs.getLong("id"));
            itemPerfil.setIdUser(rs.getLong("idUser"));
            itemPerfil.setTitulo(rs.getString("titulo"));
            itemPerfil.setDescription(rs.getString("description"));
            itemPerfil.setImagen_doc(rs.getString("imagen_doc"));
            
            return itemPerfil;
        }
    }

    //Inserta un nou item a la base de dades
    public int insertItem(Item item){

        String sql = """
            INSERT INTO items(idUser, titulo, description, puntuacion, favoritos, categoria, onCreated, onUpdate)
            VALUES (?,?,?,?,?,?,?,?)
            """;

        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        int devolver = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
            );

            ps.setLong(1, item.getIdUser());
            ps.setString(2, item.getTitulo());
            ps.setString(3, item.getDescription());
            ps.setDouble(4, item.getPuntuacion());
            ps.setBoolean(5, item.isFavoritos());
            ps.setString(6, item.getCategoria());
            ps.setTimestamp(7, timestamp);
            ps.setTimestamp(8, timestamp);

            return ps;
        }, keyHolder);
        
        item.setId(keyHolder.getKey().longValue());
            
        return devolver;
    }

    public List<ItemPerfilResponseDTO>findByUserId(Long idUser){
        String sql = "SELECT * FROM items WHERE idUser = ?";
        try {
            return jdbcTemplate.query(sql, new ItemPerfilResponseDTORowMapper(), idUser);
        } catch (Exception e) {
            return null;
        }
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
