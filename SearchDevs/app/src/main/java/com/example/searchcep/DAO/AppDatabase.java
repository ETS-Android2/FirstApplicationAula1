package com.example.searchcep.DAO;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.searchcep.model.Dev;
import com.example.searchcep.model.UserID;
import com.example.searchcep.repository.Converters;

@Database(entities = {Dev.class, UserID.class}, version = 2)
@TypeConverters(Converters.class)
public abstract class AppDatabase extends RoomDatabase {

    public abstract DevDao devDao();
    public abstract UserIDDao idDao();
//    public abstract RepoDao repoDao();

    private static AppDatabase instance = null;

    public static AppDatabase getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context,
                    AppDatabase.class,
                    "tin_dev")
                    .allowMainThreadQueries() // Permite que o room rode na main principal
                    .fallbackToDestructiveMigration()  // recreate the database if necessary
                    .build();
        }
        return instance;
    }
}
