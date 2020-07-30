package com.example.recyclerview.models;

import android.graphics.drawable.Drawable;

public class Desenvolvedor {

    private String serverId;
    private String name;
    private String user;
    private String bio;
    private String avatar;

    public Desenvolvedor(String serverId, String name, String user, String bio, String avatar) {
        this.serverId = serverId;
        this.name = name;
        this.user = user;
        this.bio = bio;
        this.avatar = avatar;
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

    public String getImagem() {
        return avatar;
    }

    public void setImagem(String imagem) {
        this.avatar = imagem;
    }


}
