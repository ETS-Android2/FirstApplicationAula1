package com.example.searchcep.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;

@Entity(tableName = "Desenvolvedor")
@JsonIgnoreProperties({"uid","createdAt","updatedAt","__v"})
public class Dev implements Serializable {

    @PrimaryKey(autoGenerate = true) private int uid;
    private ArrayList<String> likes = new ArrayList();
    private ArrayList<String> dislikes = new ArrayList();
    @ColumnInfo(name="server_id")
    private String _id;
    private String name;
    private String user;
    private String bio;
    private String avatar;

    public ArrayList<String> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<String> likes) {
        this.likes = likes;
    }

    public ArrayList<String> getDislikes() {
        return dislikes;
    }

    public void setDislikes(ArrayList<String> dislikes) {
        this.dislikes = dislikes;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Dev{" +
                "likes=" + likes +
                ", dislikes=" + dislikes +
                ", _id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", user='" + user + '\'' +
                ", bio='" + bio + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
