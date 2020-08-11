package com.example.searchcep.DAO;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.searchcep.model.UserID;

@Dao
public interface UserIDDao {
    @Insert
    void insertUserID(UserID userId);
}
