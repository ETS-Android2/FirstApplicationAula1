package com.example.searchcep.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.searchcep.model.Dev;

import java.util.List;

@Dao
public interface DevDao {
    @Query("SELECT * FROM Desenvolvedor")
    List<Dev> getAll();

    @Query("SELECT * FROM Desenvolvedor WHERE server_id LIKE :server_id")
    Dev findDevById(String... server_id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(List<Dev> devs);

    @Update
    void atualizar(Dev dev);

    @Insert
    void insert(Dev dev);

    @Delete
    void delete(Dev dev);


}
