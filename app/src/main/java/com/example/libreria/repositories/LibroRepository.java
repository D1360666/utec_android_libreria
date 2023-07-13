package com.example.libreria.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.libreria.daos.ILibroDao;
import com.example.libreria.database.AppDatabase;
import com.example.libreria.entities.Libro;

import java.util.List;

public class LibroRepository {
    private ILibroDao libroDao;

    private LiveData< List<Libro>> libros;

    public LibroRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        libroDao=db.libroDao();
        libros = libroDao.findAll();
    }

    public LiveData<List<Libro>> getLibros(){
        return libros;
    }

    public void insert(Libro libro){
        libroDao.insert(libro);
    }
}
