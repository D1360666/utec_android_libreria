package com.example.libreria.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.libreria.entities.Libro;

import java.util.List;

@Dao
public interface ILibroDao {
    @Query("SELECT * FROM Libro")
    LiveData<List<Libro>> findAll();

    @Insert
    void insert(Libro libro);

    @Update
    void update(Libro libro);

    @Delete
    void delete(Libro libro);

    @Query("SELECT * FROM Libro WHERE id = :id")
    Libro findById(int id);

    @Query("SELECT * FROM Libro WHERE nombre LIKE :nombre")
    Libro findByNombre(String nombre);

}
