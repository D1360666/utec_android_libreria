package com.example.libreria;

import static org.junit.Assert.assertTrue;

import android.content.Context;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.example.libreria.daos.ILibroDao;
import com.example.libreria.database.AppDatabase;
import com.example.libreria.entities.Libro;
;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class LibroTest {
    private ILibroDao libroDao;
    private AppDatabase appDatabase;

    @Before
    public void createDb(){
        Context context = ApplicationProvider.getApplicationContext();
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        libroDao = appDatabase.libroDao();
    }

    @After
    public void closeDb(){
        appDatabase.close();
    }

    @Test
    public void findByNombreTest() throws Exception{
        Libro libro = new Libro();
        libro.setId(1);
        libro.setNombre("Libro");

        libroDao.insert(libro);

        Libro encontrado = libroDao.findByNombre("Libro");

        assertTrue("No se encontró el libro", libro.getId()==encontrado.getId());

    }
}
