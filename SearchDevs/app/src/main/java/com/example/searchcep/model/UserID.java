package com.example.searchcep.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserID {
    public UserID(String userID) {
        this.userID = userID;
    }

    @ColumnInfo(name="server_id")
    private String userID;
    @PrimaryKey(autoGenerate = true)
    private int internalID;

    public int getInternalID() {
        return internalID;
    }

    public void setInternalID(int internalID) {
        this.internalID = internalID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
