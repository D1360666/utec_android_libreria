package com.example.libreria.models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.libreria.entities.Libro;
import com.example.libreria.repositories.LibroRepository;

import java.util.List;

public class LibroViewModel extends AndroidViewModel {
    private LibroRepository libroRepository;
    private final LiveData<List<Libro>> libros;

    public LibroViewModel(@NonNull Application application) {
        super(application);
        libroRepository = new LibroRepository(application);
        libros = libroRepository.getLibros();
    }
}
