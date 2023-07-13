package com.example.libreria.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.libreria.daos.ILibroDao;
import com.example.libreria.entities.Libro;

@Database(entities={Libro.class}, version=1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ILibroDao libroDao();
    private static volatile AppDatabase instance;

    public static AppDatabase getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "libreria").build();
        }
        return instance;
    }
}
